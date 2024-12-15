package com.cafe.coffee.application.usecase;

import com.cafe.coffee.framework.web.dto.CoffeeInfoDTO;
import com.cafe.coffee.framework.web.dto.CoffeeOutputDTO;

public interface AddCoffeeUseCase {
    public CoffeeOutputDTO addCoffee(CoffeeInfoDTO coffeeInfoDTO);

    public String findCreator(CoffeeInfoDTO coffeeInfoDTO);
}
