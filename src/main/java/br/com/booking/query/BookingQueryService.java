package br.com.booking.query;

import br.com.booking.event.BookingCreatedEvent;
import br.com.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingQueryService {
    private final BookingRepository repository;

    public void bookingRegister (BookingCreatedEvent event) {
        this.repository.save(event);
    }
}