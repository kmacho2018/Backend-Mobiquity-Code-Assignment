package com.mobiquity.service;

import com.mobiquity.domain.Item;
import com.mobiquity.domain.Package;
import com.mobiquity.exception.APIException;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;

/**
 * @author Juan Camacho
 * Object to convert the file information into a object structure
 */
public class PackageFileReaderService {

    /**
     * Read a package
     * @param filePath File path of the package.
     * @return Return Collection of package model.
     * @throws APIException
     */
    public static List<Package> read(String filePath) throws APIException {
        File file = new File(filePath);
        List<Package> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            //Check if file is empty
            if (!scanner.hasNextLine()) {
                throw new APIException("Invalid File");
            }

            //Read line by line
            while (scanner.hasNextLine()) {
                result.add(createPackage(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new APIException("File not found", e);
        } catch (APIException ae) {
            throw ae;
        } catch (Exception e) {
            throw new APIException("Invalid values", e);
        }

        return result;
    }

    /**
     * Create a package from a String
     * @param line
     * @return
     * @throws APIException
     */
    private static Package createPackage(String line) throws APIException {
        Scanner scanner = new Scanner(line);
        Float maxWeight = scanner.nextFloat();
        if (maxWeight <= 0 || maxWeight > 100) {
            throw new APIException("Invalid max weight");
        }
        if (!scanner.next().equals(":"))
            throw new APIException("Invalid File");

        List<Item> itemList = new ArrayList<>();
        while (scanner.hasNext()) {
            itemList.add(createItem(scanner.next()));
        }
        if (itemList.isEmpty()) {
            throw new APIException("Invalid File - no items");
        }
        return new Package(maxWeight, itemList);
    }

    /**
     *  Create a item.
     * @param item Name of the item.
     * @return Return Item model.
     * @throws APIException
     */
    private static Item createItem(String item) throws APIException {
        String[] values = item.substring(1, item.length() - 1).split(",");
        if (values.length != 3) {
            throw new APIException("Invalid File - item values");
        }

        Integer index = Integer.valueOf(values[0]);

        Float weight = Float.valueOf(values[1]);

        String costString = values[2];

        if (!costString.startsWith(Currency.getInstance("EUR").getSymbol())) {
            throw new APIException("Invalid cost values");
        }

        Float cost = Float.valueOf(costString.substring(1, values[2].length()));
        if (weight <= 0 || cost <= 0 || weight > 100 || cost > 100) {
            throw new APIException("Invalid values");
        }

        return new Item(index, weight, cost);
    }
}

