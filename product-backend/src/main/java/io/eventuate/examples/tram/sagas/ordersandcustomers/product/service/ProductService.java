package io.eventuate.examples.tram.sagas.ordersandcustomers.product.service;

import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.Product;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.ProductNotAvailableException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.ProductNotFoundException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.ProductRepository;



public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(String name, Long stock) {
    Product product  = new Product(name, stock);
    return productRepository.save(product);
  }

  public void reserveProduct(long productId, long orderId, long quantity) throws ProductNotAvailableException {
    Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    product.reserveStock(orderId, quantity);
  }
}
