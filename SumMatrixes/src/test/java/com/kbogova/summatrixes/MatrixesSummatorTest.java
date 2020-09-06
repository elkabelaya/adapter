/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kbogova.summatrixes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elkabelaya
 */
public class MatrixesSummatorTest {
    
    public MatrixesSummatorTest() {
    }

    
   
    /**
     * Test of run method, of class MatrixesSummator.
     */
    @org.junit.jupiter.api.Test
    public void testRun_WrongDimensions() throws Exception {
        System.out.println("run with wrong dimensions");
        Boolean exceptionCalled = false;
        MatrixesSummator instance = new MatrixesSummator();
        MatrixesSummatorHelper.setFOFile("./testfiles/test1.txt");
        try {
            instance.run();
        } catch(Exception ex){
            exceptionCalled = true;
        }
        assertTrue(exceptionCalled);
        
    }
    
    @org.junit.jupiter.api.Test
    public void testRun_EmptyFile() throws Exception {
        System.out.println("run with empty file");
        Boolean exceptionCalled = false;
        MatrixesSummator instance = new MatrixesSummator();
        MatrixesSummatorHelper.setFOFile("./testfiles/test2.txt");
        try {
            instance.run();
        } catch(Exception ex){
            
            exceptionCalled = true;
        }
        assertTrue(exceptionCalled);
        
    }
    
    @org.junit.jupiter.api.Test
    public void testRun_3x3() throws Exception {
        System.out.println("run with correct file");
        Boolean exceptionCalled = false;
        MatrixesSummator instance = new MatrixesSummator();
        MatrixesSummatorHelper.setFOFile("./testfiles/test3.txt");
        instance.run();
        
        assertTrue(MatrixesSummatorHelper.checkF1Summ("./testfiles/test3_etalon.txt"));
        
    }
    
    @org.junit.jupiter.api.Test
    public void testRun_WrongFileStructure() throws Exception {
        System.out.println("run with wrong file structure");
        Boolean exceptionCalled = false;
        MatrixesSummator instance = new MatrixesSummator();
        MatrixesSummatorHelper.setFOFile("./testfiles/test4.txt");
        try {
            instance.run();
        } catch(Exception ex){
            
            exceptionCalled = true;
        }
        assertTrue(exceptionCalled);
        
    }
    
    
}
