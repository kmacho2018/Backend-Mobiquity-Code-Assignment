package com.mobiquity.service;

import com.mobiquity.domain.Package;
import com.mobiquity.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Juan Camacho
 * This tests are to validate logic, and use PackageFileReaderTest logic to get info from the files
 */
public class PackageTest {

    @Test
    public void singleLarge() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/single-large.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(4));
    }

    @Test
    public void oneValueBigger() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/single-bigger.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(0, aPackage.getMaxCostIndex().size());
    }

    @Test
    public void oneValueSmaller() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/single-smaller.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
    }

    @Test
    public void twoOne1() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/two-one1.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
    }

    @Test
    public void twoOne2() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/two-one2.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(2));
    }

    @Test
    public void twoOne3() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/two-one3.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
    }

    @Test
    public void twoNone() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/two-none.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(0, aPackage.getMaxCostIndex().size());
    }

    @Test
    public void twoTwo() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/two-two.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(2, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(2));
    }

    @Test
    public void fourFour() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/four-four.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        Assert.assertEquals(4, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(2));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(3));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(4));
    }

    @Test
    public void fourThree() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/four-three.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);
        Package aPackage = result.get(0);
        System.out.println(aPackage.getMaxCostIndex());
        System.out.println(aPackage.getMaxCost());
        Assert.assertEquals(3, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(1));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(3));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(4));
    }

    @Test
    public void example1() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/example1.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);

        Package aPackage = result.get(0);
        System.out.println(aPackage.getMaxCostIndex());
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(4));
    }

    @Test
    public void example2() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/example2.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);

        Package aPackage = result.get(0);
        System.out.println(aPackage.getMaxCostIndex());
        Assert.assertEquals(0, aPackage.getMaxCostIndex().size());
    }

    @Test
    public void example3() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/example3.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);

        Package aPackage = result.get(0);
        System.out.println(aPackage.getMaxCostIndex());
        Assert.assertEquals(2, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(2));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(7));
    }

    @Test
    public void example4() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/example4.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(1,result.size(),0);

        Package aPackage = result.get(0);
        System.out.println(aPackage.getMaxCostIndex());
        Assert.assertEquals(2, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(8));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(9));
    }

    @Test
    public void multipleExample() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/multiple.txt");
        result.forEach(aPackage -> {
            aPackage.calculateMaxCost();
        });
        Assert.assertEquals(4,result.size(),0);

        Package aPackage = result.get(0);
        Assert.assertEquals(1, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(4));

        aPackage = result.get(1);
        Assert.assertEquals(0, aPackage.getMaxCostIndex().size());

        aPackage = result.get(2);
        Assert.assertEquals(2, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(2));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(7));

        aPackage = result.get(3);
        Assert.assertEquals(2, aPackage.getMaxCostIndex().size());
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(8));
        Assert.assertTrue(aPackage.getMaxCostIndex().contains(9));
    }
}

