package com.pulawskk.dbsfood.service;


import com.pulawskk.dbsfood.api.v1.model.BurgerDto;
import com.pulawskk.dbsfood.api.v1.model.BurgerListDto;

public interface BurgerService {

    BurgerDto findBurgerByName(String name);

    BurgerDto findBurgerById(Long id);

    BurgerListDto findAllBurgers();

    BurgerDto createNewBurger(BurgerDto burgerDto);

    void deleteBurgerById(Long id);

    BurgerDto findBurgerByParameter(String parameter);
}
