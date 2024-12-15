package com.cafe.coffee.framework.web.dto;

import com.cafe.coffee.domain.model.Coffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CoffeeOutputDTO {
    private String title;
    private String userId;
    private LocalDateTime createAt;

    public static CoffeeOutputDTO toDTO(Coffee coffee) {
        CoffeeOutputDTO coffeeOutputDTO = new CoffeeOutputDTO();
        coffeeOutputDTO.setTitle(coffee.getTitle());
        coffeeOutputDTO.setUserId(coffee.getCreator().getUserId());
        coffeeOutputDTO.setCreateAt(coffee.getCreateAt());
        return coffeeOutputDTO;
    }
}
