package io.eventuate.examples.tram.sagas.ordersandcustomers.product;

import io.eventuate.examples.tram.sagas.ordersandcustomers.product.web.ProductWebConfiguration;
import io.eventuate.tram.spring.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.messaging.common.ChannelMapping;
import io.eventuate.tram.messaging.common.DefaultChannelMapping;
import io.eventuate.tram.sagas.spring.orchestration.SagaOrchestratorConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import({ProductConfiguration.class,
        ProductWebConfiguration.class,
        TramEventsPublisherConfiguration.class,
        TramCommandProducerConfiguration.class,
        SagaOrchestratorConfiguration.class,
        TramJdbcKafkaConfiguration.class})
@ComponentScan
public class ProductServiceMain {

  @Bean
  public ChannelMapping channelMapping() {
    return DefaultChannelMapping.builder().build();
  }

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceMain.class, args);
  }
}
