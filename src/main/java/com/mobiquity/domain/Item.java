package com.mobiquity.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Camacho
 * This class represent a item you add in the package.
 */
@Getter
@Setter
public class Item {
    private Integer index;
    private Float weight, cost;
    public Item(Integer index, Float weight, Float cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }
}
