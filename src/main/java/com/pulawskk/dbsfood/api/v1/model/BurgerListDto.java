package com.pulawskk.dbsfood.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BurgerListDto implements Serializable {
    private final static Long serialVersionUID = 17868656567L;
    List<BurgerDto> burgers;
}
