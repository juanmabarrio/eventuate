package io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
