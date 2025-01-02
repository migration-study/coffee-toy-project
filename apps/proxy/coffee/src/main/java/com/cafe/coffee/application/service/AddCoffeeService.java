package com.cafe.coffee.application.service;

import com.cafe.coffee.application.input.AddCoffeeUseCase;
import com.cafe.coffee.application.output.CoffeeOutputPort;
import com.cafe.coffee.domain.model.Coffee;
import com.cafe.coffee.framework.adapter.in.web.dto.CoffeeInfoDTO;
import com.cafe.coffee.framework.adapter.in.web.dto.CoffeeOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddCoffeeService implements AddCoffeeUseCase {
    private final CoffeeOutputPort coffeeOutputPort;

    @Override
    public CoffeeOutputDTO addCoffee(CoffeeInfoDTO coffeeInfoDTO) {
        String creatorId = findCreator(coffeeInfoDTO);

        Coffee coffee = Coffee.createCoffee(coffeeInfoDTO.getTitle()
                                          , coffeeInfoDTO.getId()
                                          , creatorId);

        Coffee saveCoffee = coffeeOutputPort.saveCoffee(coffee);

        return CoffeeOutputDTO.toDTO(saveCoffee);
    }

    @Override
    public String findCreator(CoffeeInfoDTO coffeeInfoDTO) {
        return coffeeOutputPort.loadCreatorById(coffeeInfoDTO.getId());
    }
}
