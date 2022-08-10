package br.com.booking.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository {

    <T> void save (T obj);
}
