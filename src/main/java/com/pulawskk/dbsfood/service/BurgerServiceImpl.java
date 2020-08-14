package com.pulawskk.dbsfood.service;


import com.pulawskk.dbsfood.api.v1.mapper.BurgerMapper;
import com.pulawskk.dbsfood.api.v1.model.BurgerDto;
import com.pulawskk.dbsfood.api.v1.model.BurgerListDto;
import com.pulawskk.dbsfood.controller.v1.BurgerController;
import com.pulawskk.dbsfood.controller.ResourceNotFoundException;
import com.pulawskk.dbsfood.domain.Burger;
import com.pulawskk.dbsfood.repository.BurgerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BurgerServiceImpl implements BurgerService {

    private final BurgerMapper mapper;

    private final BurgerRepository burgerRepository;

    public BurgerServiceImpl(BurgerMapper mapper, BurgerRepository burgerRepository) {
        this.mapper = mapper;
        this.burgerRepository = burgerRepository;
    }

    /**
     * Return base url for burgers api
     * @return url
     */
    private String getBurgerBaseUrl() {
        return BurgerController.BURGER_BASE_URL + "/";
    }

    @Override
    public BurgerDto findBurgerByParameter(String parameter) {
        try {
            Long id = Long.parseLong(parameter);
            if (id > 0) {
                return findBurgerById(id);
            }
        } catch (NumberFormatException exception) {
            return findBurgerByName(parameter);
        }
        throw new ResourceNotFoundException("Not found burger with parameter: " + parameter);
    }

    @Override
    public BurgerDto findBurgerByName(String name) {
        BurgerDto burgerDto = mapper.burgerToBurgerDto(burgerRepository.findBurgerByName(name).orElseThrow(ResourceNotFoundException::new));
        burgerDto.setOrderUrl(getBurgerBaseUrl() + burgerDto.getId());
        return burgerDto;
    }

    @Override
    public BurgerDto findBurgerById(Long id) {
        BurgerDto burgerDto = mapper.burgerToBurgerDto(burgerRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
        burgerDto.setOrderUrl(getBurgerBaseUrl() + burgerDto.getId());
        return burgerDto;
    }

    @Cacheable(cacheNames = "burgerListCache")
    @Override
    public BurgerListDto findAllBurgers() {
        return new BurgerListDto(burgerRepository.findAll()
                .stream()
                .map(mapper::burgerToBurgerDto)
                .map(dto -> {
                    dto.setOrderUrl(getBurgerBaseUrl() + dto.getId());
                    return dto;
                })
                .collect(Collectors.toList()));
    }

    @Override
    public BurgerDto createNewBurger(BurgerDto burgerDto) {
        Burger savedBurger = burgerRepository.save(mapper.burgerDtoToBurger(burgerDto));
        BurgerDto savedBurgerDto = mapper.burgerToBurgerDto(savedBurger);
        savedBurgerDto.setOrderUrl(getBurgerBaseUrl() + savedBurger.getId());
        return savedBurgerDto;
    }

    @Override
    public void deleteBurgerById(Long id) {
        burgerRepository.deleteById(id);
    }

}
