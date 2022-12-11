package com.project.site.Modules.User.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.project.site.Modules.Reservation.model.entity.Reservation;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    private Set<Reservation> reservations;

   /* public static User MapDTOToEntity(UserDTO userDto){
        User user = UserDTO.builder()
                .id(userDto.getId())
                .name(userDto.getName()).build();
        return user;
    }*/
}

