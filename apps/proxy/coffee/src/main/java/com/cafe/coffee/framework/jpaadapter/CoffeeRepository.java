package com.cafe.coffee.framework.jpaadapter;

import com.cafe.coffee.domain.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    public Coffee save(Coffee coffee);

}
