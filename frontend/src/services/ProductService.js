import http from "../http-common";

class ProductService {
  save(post) {
    return http.post("/product/", post);
  }
  getProducts() {
    return http.get(`/product`);
  }
  get(id) {
    return http.get(`/product/${id}`);
  }
  update(id, post) {
    return http.put(`/product/${id}`, post);
  }
  delete(id) {
    return http.delete(`/product/${id}`);
  }
  order(post) {
    return http.post("/order/", post);
  }
}

export default new ProductService();
