package com.mobiquity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Juan Camacho
 * This class represent a object used to handle the information we need of the packages to be return.
 */
@Getter
@Setter
public class Response {
    private Float cost = 0f, weight = 0f;
    private Set<Integer> costIndex = new HashSet<>();
}
