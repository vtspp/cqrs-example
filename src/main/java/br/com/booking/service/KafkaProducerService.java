package br.com.booking.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class KafkaProducerService {

    private KafkaTemplate template;

    public <T> Mono<T> producer (Mono<T> payload) {
        this.template.send("test-topic", payload)
                .completable()
                .whenComplete((o, o2) -> System.out.println("Enviar para o eventSource"))
                .thenApply(o -> o);
        return Mono.empty();
    }
}