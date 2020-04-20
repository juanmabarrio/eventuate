package io.eventuate.examples.tram.sagas.ordersandcustomers.product.webapi;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;

public class CreateProductRequest {
  private String name;
  private Long quantity;

  public CreateProductRequest() {
  }

  public CreateProductRequest(String name, Long quantity) {

    this.name = name;
    this.quantity = quantity;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }
}
