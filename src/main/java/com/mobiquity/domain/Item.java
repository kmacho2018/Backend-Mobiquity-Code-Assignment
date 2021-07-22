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
}
