package com.cafe.coffee.application.input;

import com.cafe.coffee.framework.adapter.in.web.dto.CoffeeInfoDTO;
import com.cafe.coffee.framework.adapter.in.web.dto.CoffeeOutputDTO;

public interface AddCoffeeUseCase {
    public CoffeeOutputDTO addCoffee(CoffeeInfoDTO coffeeInfoDTO);

    public String findCreator(CoffeeInfoDTO coffeeInfoDTO);
}
