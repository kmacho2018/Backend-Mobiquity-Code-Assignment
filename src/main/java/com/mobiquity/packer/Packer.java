package com.mobiquity.packer;

import com.mobiquity.domain.Package;
import com.mobiquity.exception.APIException;
import com.mobiquity.service.PackageFileReaderService;

import java.util.Iterator;
import java.util.List;

/**
 * @author Juan Camacho
 * Packer Class with all its processing methods.
 */
public class Packer {

    /**
     * Method that read, calculate and print results of a package.
     * @param filePath
     * @return
     * @throws APIException
     */
    public static String pack(String filePath) throws APIException {

        //Read file Package
        List<Package> packageList = PackageFileReaderService.read(filePath);

        //Calculate Max Cost of the package
        packageList = calculateMaxCost(packageList);

        //Print results;
        return printResult(packageList);
    }

    /**
     * This methods call the calculation package per package
     *
     * @param packageList
     * @return
     */
    private static List<Package> calculateMaxCost(List<Package> packageList) {
        packageList.forEach(pkg -> {
            pkg.calculateMaxCost();
        });
        return packageList;
    }

    /**
     * This creates the string result
     *
     * @param packageList with the information
     * @return
     */
    private static String printResult(List<Package> packageList) {
        StringBuffer buffer = new StringBuffer();
        packageList.forEach(pkg -> {
            if (pkg.getMaxCostIndex().isEmpty()) {
                buffer.append("-");
            }
            for (Iterator<Integer> iterator = pkg.getMaxCostIndex().iterator(); iterator.hasNext(); ) {
                buffer.append(iterator.next().toString());
                if (iterator.hasNext()) {
                    buffer.append(",");
                }
            }
            buffer.append("\n");
        });
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
