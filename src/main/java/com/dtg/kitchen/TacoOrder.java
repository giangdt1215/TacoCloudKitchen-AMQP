package com.dtg.kitchen;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder {

    private Date placedAt;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;

    private List<Taco> tacos = new ArrayList<>();
}
