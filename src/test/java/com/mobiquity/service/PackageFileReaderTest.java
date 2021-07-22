package com.mobiquity.service;

import com.mobiquity.domain.Package;
import com.mobiquity.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Juan Camacho
 * This tests are to validate that the file exist and has been read correctly.
 */
public class PackageFileReaderTest {

    @Test
    public void fileNotFound(){
        try{
            PackageFileReaderService.read("wrongpath");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("File not found", ae.getMessage());
        }
    }

    @Test
    public void emptyFIle(){
        try{
            PackageFileReaderService.read("src/test/resources/empty.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid File", ae.getMessage());
        }
    }

    @Test
    public void invalidFile() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/invalid.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid File", ae.getMessage());
        }
    }

    @Test
    public void onlyWeight() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/onlyWeight.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid File - no items", ae.getMessage());
        }
    }

    @Test
    public void wrongDataItem() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/wrongDataItem.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid File - item values", ae.getMessage());
        }
    }

    @Test
    public void simpleCase() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/single.txt");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(81, result.get(0).getMaxWeight(), 0);
        Assert.assertEquals(6, result.get(0).getItemList().size(), 0);
    }

    @Test
    public void simpleLargeCase() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/single-large.txt");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(81, result.get(0).getMaxWeight(), 0);
        Assert.assertEquals(15, result.get(0).getItemList().size(), 0);
    }

    @Test
    public void invalidCost() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/invalidCost.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }

    @Test
    public void invalidIndex() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/invalidIndex.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }

    @Test
    public void multipleCase() throws APIException {
        List<Package> result = PackageFileReaderService.read("src/test/resources/multiple.txt");
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(81, result.get(0).getMaxWeight(), 0);
        Assert.assertEquals(6, result.get(0).getItemList().size(), 0);
        Assert.assertEquals(75, result.get(2).getMaxWeight(), 0);
        Assert.assertEquals(9, result.get(2).getItemList().size(), 0);
    }

    @Test
    public void wrongDataItem2() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/wrongDataItem2.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }

    @Test
    public void wrongDataItem3() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/wrongDataItem3.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid cost values", ae.getMessage());
        }
    }

    @Test
    public void wrongDataItem4() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/wrongDataItem4.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid cost values", ae.getMessage());
        }
    }

    @Test
    public void wrongDataItem5() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/wrongDataItem5.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid max weight", ae.getMessage());
        }
    }

    @Test
    public void emptyLine() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/empty-line.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }

    @Test
    public void cost101() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/cost101.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }

    @Test
    public void maxWeight101() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/max-weight101.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid max weight", ae.getMessage());
        }
    }

    @Test
    public void weight101() throws APIException {
        try{
            PackageFileReaderService.read("src/test/resources/weight101.txt");
            Assert.fail();
        }catch (APIException ae){
            Assert.assertEquals("Invalid values", ae.getMessage());
        }
    }
}
