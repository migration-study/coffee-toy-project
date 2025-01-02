package com.cafe.coffee.framework.adapter.out.persistance;

import com.cafe.coffee.domain.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddCoffeeRepository extends JpaRepository<Coffee, Long> {
    public Coffee save(Coffee coffee);

}
