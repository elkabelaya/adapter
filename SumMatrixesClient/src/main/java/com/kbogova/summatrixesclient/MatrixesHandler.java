/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kbogova.summatrixesclient;;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author elkabelaya
 */
public class MatrixesHandler {
    final static Random random = new Random();
    
    
    static void sumMatrixes() throws Exception {
        System.out.println("sum Matrixes from " + Paths.WRITE_MATRIXES_FILE);
        
        IMatrixesSummator matrixesSummator = new MatrixSummatorAdapter();
        matrixesSummator.sum();
    }
    
    //creates 2 matrixes with the same dimentions and writes them in file F2.txt
    static void generateMatrixes()  throws Exception {
        System.out.println("generate random Matrixes and write to " + Paths.WRITE_MATRIXES_FILE);
        FileWriter writer = new FileWriter(new File(Paths.WRITE_MATRIXES_FILE));
        int randomRows = random.nextInt(10);
        int randomColumns = random.nextInt(10);
        
        if (randomRows < 1){
            randomRows = 1;
        }
        if (randomColumns < 1){
            randomColumns = 1;
        }
        for(int i = 0; i < 2; i++){
            writer.write(generateMatrix(randomRows, randomColumns));
        }
        
        writer.close();
    }
    
    //creates  matrix with setted dimentions and random values,  returns matrix string representation
    static String  generateMatrix(int rowsNumber, int columnsNumber){
        String result = "";
        double scale = Math.pow(10, 2);
        result += "matrix " + rowsNumber + "x" + columnsNumber + "\n";
        for(int i=0; i< rowsNumber; i++){
            
            for(int j=0; j< columnsNumber; j++){ 
                result += "\t" + Math.round(random.nextDouble()*100*scale)/scale;
            }
            result += "\n";
        }
        return result;
    }
}
