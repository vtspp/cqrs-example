package br.com.booking.command;

import br.com.booking.status.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingCreateCommand {
    private UUID identifier;
    private String type;
    private BookingStatus status;
}