<template>
  <div class="submit-form mt-10 mx-auto">
    <p class="headline">Add details</p>

    <h1>{{product.name}}</h1>
    Amount: {{product.amount}} <br />
    Price: {{product.price}}$ <br />

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
      }
    };
  },
  methods: {
    refresh() {
      this.submitted = false;
      this.ads = {};
    },
    getProduct(id) {
      ProductService.get(id)
        .then((response) => {
          this.product = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = "";
    this.getProduct(this.$route.params.id);
  },
};
</script>

<style>
.submit-form {
  max-width: 1200px;
}
</style>
