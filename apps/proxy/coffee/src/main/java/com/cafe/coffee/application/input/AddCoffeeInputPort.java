package com.cafe.coffee.application.input;

import com.cafe.coffee.application.output.CoffeeOutputPort;
import com.cafe.coffee.application.usecase.AddCoffeeUseCase;
import com.cafe.coffee.domain.model.Coffee;
import com.cafe.coffee.framework.web.dto.CoffeeInfoDTO;
import com.cafe.coffee.framework.web.dto.CoffeeOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class AddCoffeeInputPort implements AddCoffeeUseCase {
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
