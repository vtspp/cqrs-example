package br.com.booking.controller;

import br.com.booking.command.BookingCreateCommand;
import br.com.booking.dto.BookingResponse;
import br.com.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequestMapping ("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @GetMapping
    public Mono<BookingResponse> createBooking () {
        UUID uuid = UUID.randomUUID();
        this.service.createBooking(
                BookingCreateCommand.builder()
                .identifier(uuid)
                .type(BookingCreateCommand.builder().getClass().getName())
                .build());
        return Mono.just(BookingResponse.builder()
                .identifier(uuid)
                .build());
    }
}