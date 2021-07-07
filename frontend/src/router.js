import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/product/add",
      name: "add-product",
      component: () => import("./components/product/AddProduct.vue")
    },
    {
      path: "/product/:id/update",
      name: "edit-product",
      component: () => import("./components/product/EditProduct.vue")
    },
    {
      path: "/products",
      name: "products",
      component: () => import("./components/product/Products.vue")
    },
    {
      path: "/orders",
      name: "orders",
      component: () => import("./components/product/OrderProduct.vue")
    },
    {
      path: "/product/:id",
      name: "product-details",
      component: () => import("./components/product/ProductDetails.vue")
    },
  ]
});
