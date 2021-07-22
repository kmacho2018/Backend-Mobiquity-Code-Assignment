package com.mobiquity.service;

import com.mobiquity.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

/**
 * This tests are to validate that the file exist and has been read correctly
 */
public class PackageFileReaderTest {

    @Test
    public void fileNotFound() {
        try {
            PackageFileReaderService.read("wrongpath");
            Assert.fail();
        } catch (APIException ae) {
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
}
