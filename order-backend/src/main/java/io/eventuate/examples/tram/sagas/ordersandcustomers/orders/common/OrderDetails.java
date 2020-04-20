package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderDetails {

  private Long customerId;

  @Embedded
  private Money orderTotal;

  private Long productId;

  private Long quantity;

  public OrderDetails() {
  }

  public OrderDetails(Long customerId, Money orderTotal, Long productId, Long quantity) {
    this.customerId = customerId;
    this.orderTotal = orderTotal;
    this.quantity = quantity;
    this.productId = productId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Long getProductId() {
    return productId;
  }
}
