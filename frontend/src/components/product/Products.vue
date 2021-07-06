<template>
  <div class="account-form py-3 mt-8">
    <h4>Products</h4>
    <span v-if="!requests.length">No Products available.</span>
    <v-simple-table v-if="requests.length">
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">
              Name
            </th>
            <th>Amount</th>
            <th>Price</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item, index in requests"
            :key="index"
          >
            <td @click="openDetails(item.username)">
               {{ item.name }}
            </td>
            <td>{{ item.amount }}
            </td>
            <td>{{ item.price }}
            </td>
            <td>
              <v-btn color="primary" class="mt-3 mb-5" @click="openUpdate(item.id)">Update</v-btn>
            </td>
            <td>
              <v-btn color="primary" class="mt-3 mb-5" @click="deleteProduct(item.id, index)">Delete</v-btn>
            </td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>

  </div>
</template>

<script>
import ProductService from "../../services/ProductService";

export default {
  name: "Agents",
  data() {
    return {
      requests: [],
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
