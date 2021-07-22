package com.mobiquity.service;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.Packer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juan Camacho
 * This test to emulate how is going to be call from the main program
 */
public class PackerTest {

    @Test
    public void main() throws APIException {
        String expected = "4\n-\n2,7\n8,9\n";
        String output = Packer.pack("src/test/resources/example_input");
        Assert.assertEquals(expected,output);
    }

}
