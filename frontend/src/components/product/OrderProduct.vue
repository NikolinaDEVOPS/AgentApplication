<template>
  <div class="account-form py-3 mt-8">
    <h4>Products</h4>
    <span v-if="!requests.length">No Products available.</span>
    <v-simple-table v-if="requests.length">
      <template v-slot:default>
        <thead>
          <tr>

            <th>#</th>
            <th class="text-left">
              Name
            </th>
            <th>Amount</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item, index in requests"
            :key="index"
          >
            <td>
              <v-checkbox
              @change="check($event, item)"
              ></v-checkbox>
            </td>
            <td @click="openDetails(item.username)">
               {{ item.name }}
            </td>
            <td>{{ item.amount }}
            </td>
            <td>{{ item.price }}
            </td>

          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <h6> TOTAL : {{ order.total }}$</h6>
    <v-text-field
      v-model="order.customerName"
      label="Name"

    ></v-text-field>

    <v-text-field
      v-model="order.customerLastName"
      label="Last Name"
    ></v-text-field>

    <v-text-field
      v-model="order.address"
      label="Address"
    ></v-text-field>
    <v-btn color="primary" class="mt-3" @click="save">Submit</v-btn>


  </div>
</template>

<script>
import ProductService from "../../services/ProductService";

export default {
  name: "OrderProduct",
  data() {
    return {
      requests: [],
      order: {
        customerName: "",
        customerLastName: "",
        address: "",
        total: 0,
        productIds: []
      }
    };
  },
  methods: {
    getProducts() {
      ProductService.getProducts()
        .then((response) => {
          this.requests = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    openDetails(id) {
      this.$router.push({ name: "product-details", params: { id: id } });
    },
    openUpdate(id) {
      this.$router.push({ name: "edit-product", params: { id: id } });
    },
    deleteProduct(id, index) {
      ProductService.delete(id).then(()=> {
        this.requests.splice(index, 1)
      })
    },
    check(clicked, item) {
      if(clicked) {
        this.order.productIds.push(item.id);
        this.order.total += item.price;
        return;
      }
      const ind = this.order.productIds.findIndex((x) => x === item.id);
      this.order.total -= item.price;

      this.order.productIds.splice(ind, 1);
    },
    save() {
      ProductService.order(this.order)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = "";
    this.getProducts();

  }
};
</script>

<style>
.account-form {
  max-width: 1200px;
  margin: auto;
}
.account-header {
  max-width: 800px;
    margin: auto;

}
</style>
