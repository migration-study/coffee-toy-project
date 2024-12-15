package com.cafe.coffee.application.output;

import com.cafe.coffee.domain.model.Coffee;

import java.util.Optional;

public interface CoffeeOutputPort {
    public String loadCreatorById(Long id);

    public Coffee saveCoffee(Coffee coffee);
}
