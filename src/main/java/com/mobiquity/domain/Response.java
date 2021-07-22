package com.mobiquity.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Juan Camacho
 * This is a object used to handle the information we need of the packages to be return.
 */
public class Response {
    private Float cost = 0f;
    private Float weight = 0f;
    private Set<Integer> costIndex = new HashSet<>();

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Set<Integer> getCostIndex() {
        return costIndex;
    }

    public void setCostIndex(Set<Integer> costIndex) {
        this.costIndex = costIndex;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
