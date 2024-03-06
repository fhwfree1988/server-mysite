package com.project.site.Modules.Reservation.model.dto;

import com.project.site.Modules.User.model.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;
//import javax.validation.constraints.NotNull;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long id;

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    @Schema(type = "string", example = "14:30")
    private LocalTime startTime;

    @NotNull
    @Schema(type = "string", example = "14:30")
    private LocalTime endTime;

    @NotNull
    private Users user;

    @NotNull
    private Types.AmenityType amenityType;


}
