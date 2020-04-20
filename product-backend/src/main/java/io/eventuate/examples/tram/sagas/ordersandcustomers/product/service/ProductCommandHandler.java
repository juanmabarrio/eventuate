package io.eventuate.examples.tram.sagas.ordersandcustomers.product.service;

import io.eventuate.examples.tram.sagas.ordersandcustomers.product.api.commands.ReserveProductCommand;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.api.replies.ProductNotAvailable;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.api.replies.ProductReserved;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.api.replies.ProductNotFound;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.ProductNotAvailableException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.product.domain.ProductNotFoundException;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class ProductCommandHandler {

  private ProductService productService;

  public ProductCommandHandler(ProductService productService) {
    this.productService = productService;
  }

  public CommandHandlers commandHandlerDefinitions() {
    return SagaCommandHandlersBuilder
            .fromChannel("productService")
            .onMessage(ReserveProductCommand.class, this::reserveProduct)
            .build();
  }

  public Message reserveProduct(CommandMessage<ReserveProductCommand> cm) {
    ReserveProductCommand cmd = cm.getCommand();
    try {
      productService.reserveProduct(cmd.getProductId(), cmd.getOrderId(), cmd.getQuantity());
      return withSuccess(new ProductReserved());
    } catch (ProductNotFoundException e) {
      return withFailure(new ProductNotFound());
    } catch (ProductNotAvailableException e) {
      return withFailure(new ProductNotAvailable());
    }
  }

}
