package com.project.site.Modules.Reservation.repository;

import com.project.site.Modules.Reservation.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
