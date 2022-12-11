package com.sample.mysite.Modules.Reservation.repository;

import com.sample.mysite.Modules.Reservation.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
