package io.eventuate.examples.tram.sagas.ordersandcustomers.product.web;

import io.eventuate.examples.tram.sagas.ordersandcustomers.product.service.ProductService;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.Product;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.webapi.CreateProductRequest;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.webapi.CreateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping(value = "/product", method = RequestMethod.POST)
  public CreateProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
    Product product = productService.createProduct(createProductRequest.getName(), createProductRequest.getQuantity());
    System.out.println("product id ->"+ product.getId());
    return new CreateProductResponse(product.getId());
  }
}
