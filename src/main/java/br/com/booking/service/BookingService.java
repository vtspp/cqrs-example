package br.com.booking.service;

import br.com.booking.command.BookingCreateCommand;
import br.com.booking.event.BookingCreatedEvent;
import br.com.booking.status.BookingStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookingService {

    private KafkaProducerService producerService;

    public void createBooking (BookingCreateCommand command) {
        Mono.just(command)
                .map(bookingCreateCommand -> BookingCreatedEvent.builder()
                        .identifier(bookingCreateCommand.getIdentifier())
                        .type(BookingCreatedEvent.class.getPackageName())
                        .status(BookingStatus.CREATED)
                        .build())
                .log()
                .publish(producerService::producer);
    }

    public void bookingCreated (BookingCreatedEvent event) {

    }
}