package com.pulawskk.dbsfood.controller.v1;

import com.pulawskk.dbsfood.api.v1.model.BurgerDto;
import com.pulawskk.dbsfood.api.v1.model.BurgerListDto;
import com.pulawskk.dbsfood.service.BurgerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(BurgerController.BURGER_BASE_URL)
@CrossOrigin
public class BurgerController {

    public static final String BURGER_BASE_URL = "/api/v1/burgers";

    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public BurgerListDto getAllBurgers() {
        return burgerService.findAllBurgers();
    }

    @RequestMapping("{parameter}")
    public BurgerDto getBurgerByParameter(@PathVariable String parameter) {
        return burgerService.findBurgerByParameter(parameter);
    }
}
