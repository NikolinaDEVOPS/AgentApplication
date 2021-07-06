<template>
  <div class="submit-form mt-10 mx-auto">
    <p class="headline">Add product</p>

    <div v-if="!submitted">
      <v-form ref="form" lazy-validation>
        <v-text-field
          v-model="product.name"
          label="Name"

        ></v-text-field>

        <v-text-field
          v-model="product.amount"
          label="Amount"
          type="number"
        ></v-text-field>

        <v-text-field
          v-model="product.price"
          label="Price"
          type="number"
        ></v-text-field>

        <v-text-field
          v-model="product.picture"
          label="Picture"
        ></v-text-field>


      </v-form>

      <v-btn color="primary" class="mt-3" @click="save">Submit</v-btn>
    </div>

    <div v-else>
      <v-card class="mx-auto">
        <v-card-title>
          Submitted successfully!
        </v-card-title>
      </v-card>
    </div>
  </div>
</template>

<script>
import ProductService from "../../services/ProductService";

export default {
  name: "add-product",
  data() {
    return {
      product: {
        name: "",
        amount : "",
        price: "",
        picture: ""
      },
      submitted: false,
    };
  },
  methods: {
    save() {

      ProductService.save(this.product)
        .then((response) => {
          console.log(response.data);
          this.submitted = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    refresh() {
      this.submitted = false;
      this.ads = {};
    },

  },
};
</script>

<style>
.submit-form {
  max-width: 1200px;
}
</style>
