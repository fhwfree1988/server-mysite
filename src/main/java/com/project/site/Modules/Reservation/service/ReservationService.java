package com.project.site.Modules.Reservation.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.project.site.Modules.Reservation.model.entity.Reservation;
import com.project.site.Modules.Reservation.repository.ReservationRepository;
import com.project.site.Modules.User.model.entity.Users;
import com.project.site.Modules.User.repository.UserRepository;
import com.project.site.Modules.Reservation.model.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(final ReservationRepository reservationRepository,
            final UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .collect(Collectors.toList());
    }

    public ReservationDTO get(final Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation();
        mapToEntity(reservationDTO, reservation);
        return reservationRepository.save(reservation).getId();
    }

    public void update(final Long id, final ReservationDTO reservationDTO) {
        final Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
    }

    public void delete(final Long id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO mapToDTO(final Reservation reservation,
            final ReservationDTO reservationDTO) {
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setUser(reservation.getUser() == null ? null : reservation.getUser());
        return reservationDTO;
    }

    private Reservation mapToEntity(final ReservationDTO reservationDTO,
            final Reservation reservation) {
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        if (reservationDTO.getUser() != null && (reservation.getUser() == null || !reservation.getUser().getId().equals(reservationDTO.getUser().getId()))) {
            final Users user = userRepository.findById(reservationDTO.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            reservation.setUser(user);
        }
        return reservation;
    }


    //Static Methods
    public static Set<ReservationDTO> MapToDTO(Set<Reservation> userReservations){
        Set<ReservationDTO> userReservationsDto = userReservations.stream().map(
                (model) -> ReservationDTO.builder()
                        .reservationDate(model.getReservationDate())
                        .startTime(model.getStartTime())
                        .endTime(model.getEndTime())
                        .user(model.getUser())
                        .amenityType(model.getAmenityType())
                        .build()
        ).collect(Collectors.toSet());

        return userReservationsDto;
    }

    public static Reservation MapDTOToEntity(ReservationDTO userReservationsDto){
        Reservation userReservations = Reservation.builder()
                .reservationDate(userReservationsDto.getReservationDate())
                .startTime(userReservationsDto.getStartTime())
                .endTime(userReservationsDto.getEndTime())
                .user(userReservationsDto.getUser())
                .amenityType(userReservationsDto.getAmenityType())
                .build();

        return userReservations;
    }
    public static Set<Reservation> MapDTOToEntity(Set<ReservationDTO> userReservationsDto){
        Set<Reservation> userReservations = userReservationsDto.stream().map(
                (model) -> Reservation.builder()
                        .reservationDate(model.getReservationDate())
                        .startTime(model.getStartTime())
                        .endTime(model.getEndTime())
                        .user(model.getUser())
                        .amenityType(model.getAmenityType())
                        .build()
        ).collect(Collectors.toSet());

        return userReservations;
    }
}
