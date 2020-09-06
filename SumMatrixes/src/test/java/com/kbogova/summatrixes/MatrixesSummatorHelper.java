/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kbogova.summatrixes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

/**
 *
 * @author elkabelaya
 */
public class MatrixesSummatorHelper {
    
    static void setFOFile(String fromName) throws Exception{
        
        File originalFile = new File(fromName);
        File renamedFile = new File(Paths.READ_FILE);
        
        Files.copy(originalFile.toPath(), renamedFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        
    
    }
    
    static boolean checkF1Summ(String etalonFileName){
        try{
            byte[] f1 = Files.readAllBytes((new File(Paths.WRITE_FILE)).toPath());
            byte[] f2 = Files.readAllBytes((new File(etalonFileName)).toPath());
            return Arrays.equals(f1, f2);
        } catch(Exception ex){
            return false;
        }

    
    }
    
    
}
