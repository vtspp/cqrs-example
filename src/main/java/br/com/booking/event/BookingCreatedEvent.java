package br.com.booking.event;

import br.com.booking.status.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingCreatedEvent {
    private UUID identifier;
    private String type;
    private BookingStatus status;
}