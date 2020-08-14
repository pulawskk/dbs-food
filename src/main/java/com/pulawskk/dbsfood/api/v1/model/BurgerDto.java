package com.pulawskk.dbsfood.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BurgerDto implements Serializable {
    private final static Long serialVersionUID = 17868656567L;
    private Long id;
    private String name;
    private String price;

    @JsonProperty(value = "order_url")
    private String orderUrl;

    private String ingredientsJson;
}
