package io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Access(AccessType.FIELD)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Long stock;

//  Long lockSomeStock() {
//   return creditLimit.subtract(creditReservations.values().stream().reduce(Money.ZERO, Money::add));
//  }

  public Product() {
  }

  public Product(String name, Long stock) {
    this.name = name;
    this.stock = stock;
  }

  public Long getId() {
    return id;
  }
  public Long getStock() {
    return stock;
  }

  public void reserveStock(Long productId, Long stockToReserve) {
    if (getStock() >= stockToReserve) {
      this.stock = this.stock - stockToReserve;
    } else
      throw new ProductNotAvailableException();
  }
}
