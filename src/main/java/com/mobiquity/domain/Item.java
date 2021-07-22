package com.mobiquity.domain;

/**
 * @author Juan Camacho
 * This class represent a item you add in the package.
 */
public class Item {

    private Integer index;

    private Float weight;

    private Float cost;

    public Item(Integer index, Float weight, Float cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
