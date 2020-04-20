package io.eventuate.examples.tram.sagas.ordersandcustomers.product.api.commands;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;
import io.eventuate.tram.commands.common.Command;

public class ReserveProductCommand implements Command {
  private Long orderId;
  private Long quantity;
  private long productId;
  public ReserveProductCommand() {
  }

  public ReserveProductCommand(Long productId, Long orderId, Long quantity) {
    this.productId = productId;
    this.orderId = orderId;
    this.quantity = quantity;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }
}
