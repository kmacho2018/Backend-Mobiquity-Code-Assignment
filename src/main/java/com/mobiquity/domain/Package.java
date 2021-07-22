package com.mobiquity.domain;

import java.util.List;
import java.util.Set;

/**
 * @author Juan Camacho
 * This represents the package you send to a friend (is one line in the document we read).
 */
public class Package {

    private Float maxWeight;

    private List<Item> itemList;

    public Package(Float maxWeight, List<Item> itemList) {
        this.maxWeight = maxWeight;
        this.itemList = itemList;
    }

    public Float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    private Response response = new Response();

    public Float getMaxCost() {
        return response.getCost();
    }

    public Set<Integer> getMaxCostIndex() {
        return response.getCostIndex();
    }
}
