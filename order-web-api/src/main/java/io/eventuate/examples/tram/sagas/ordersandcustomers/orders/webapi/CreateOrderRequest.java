package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.webapi;


import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;

public class CreateOrderRequest {
  private Money orderTotal;
  private Long customerId;
  private Long productId;
  private Long quantity;

  public CreateOrderRequest() {
  }

  public CreateOrderRequest(Long customerId, Money orderTotal) {
    this.customerId = customerId;
    this.orderTotal = orderTotal;
    this.productId = productId;
    this.quantity = quantity;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Long getProductId() {
    return productId;
  }

  public Long getQuantity() {
    return quantity;
  }
}
