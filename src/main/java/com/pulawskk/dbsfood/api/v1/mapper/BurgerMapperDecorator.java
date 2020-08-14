package com.pulawskk.dbsfood.api.v1.mapper;

import com.pulawskk.dbsfood.api.v1.model.BurgerDto;
import com.pulawskk.dbsfood.domain.Burger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BurgerMapperDecorator implements com.pulawskk.dbsfood.api.v1.mapper.BurgerMapper {

    private BurgerMapper burgerMapper;

    @Autowired
    public void setBurgerMapper(BurgerMapper burgerMapper) {
        this.burgerMapper = burgerMapper;
    }

    @Override
    public BurgerDto burgerToBurgerDto(Burger burger) {
        BurgerDto burgerDto = burgerMapper.burgerToBurgerDto(burger);
        burgerDto.setIngredientsJson(burger.toStringIngredients());
        return burgerDto;
    }

    @Override
    public Burger burgerDtoToBurger(BurgerDto burgerDto) {
        return burgerMapper.burgerDtoToBurger(burgerDto);
    }
}
