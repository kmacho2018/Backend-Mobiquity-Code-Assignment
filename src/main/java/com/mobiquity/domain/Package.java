package com.mobiquity.domain;

import com.mobiquity.service.PackageService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author Juan Camacho
 * This represents the package you send to a friend (is one line in the document we read).
 */
@Getter
@Setter
public class Package {

    private Float maxWeight;
    private List<Item> itemList;
    private Response response = new Response();

    /**
     * Method that calculates the maximum cost with the items we have
     */
    public void calculateMaxCost(){
        PackageService.fillPackage(new Response(), maxWeight, itemList, response);
    }

    public Set<Integer> getMaxCostIndex(){
        return response.getCostIndex();
    }

    public Float getMaxCost(){
        return response.getCost();
    }
}
