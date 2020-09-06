
package com.kbogova.summatrixes;

import java.awt.Point;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elkabelaya
 */
public class MatrixesSummator {

    double[][][] matrixes = new double[2][][];
    
    public void run() throws Exception {
        readMatrixes();
        writeMatrixes(sumMatrixes());
        
    }
        
    private void readMatrixes() throws Exception{
        Scanner fileScanner;
        Scanner lineScanner;
        String lineString;
        String cellString;

        double[][] matrix = null;

        String[] sizes;

        int numOfMatrixes = 0;
        int numOfRows = 0;
        int numOfColumns = 0;
        int currentRow = -1;
        int currentColumn = -1;

        System.out.println("read matrixes from " + Paths.READ_FILE);
        fileScanner = new Scanner (new File(Paths.READ_FILE));

        while (fileScanner.hasNext()){
            lineString = fileScanner.nextLine();
            if ( lineString.length() == 0 ){
                continue;
            } else if ( lineString.indexOf("matrix") == 0){
                
                sizes = lineString.split(" ")[1].split("x");
                numOfRows = Integer.parseInt(sizes[0]);
                numOfColumns = Integer.parseInt(sizes[1]);
                
                matrix = new double[numOfRows][numOfColumns];
                matrixes[numOfMatrixes] = matrix;
                numOfMatrixes++;
                currentRow = -1;

                continue;


            } else {

                currentRow++;
                currentColumn = -1;

                if (currentRow > numOfRows - 1){
                    throw new Exception("non correct num of rows");
                }

                lineScanner = new Scanner (lineString);
                while (lineScanner.hasNext()){
                    currentColumn++;
                    if (currentColumn > numOfColumns - 1){
                        throw new Exception("non correct num of columns");
                    }

                    cellString = lineScanner.next();
                    matrix[currentRow][currentColumn] = Double.parseDouble(cellString);
                }
                lineScanner.close();

            }

            

        }
        
        fileScanner.close();
        
    }
    
    
    
    private double[][] sumMatrixes()  throws Exception{
       
        if (!Matrix.canSum(matrixes[0],matrixes[1])){
             throw new Exception("impossible to sum matrixes with different dimensions");
        }
        
        System.out.println("sum matrixes");
        return Matrix.Sum(matrixes[0], matrixes[1]);
        
        
    }
    
    private void writeMatrixes(double[][] matrix)  throws Exception {
        System.out.println("write matrix to " + Paths.WRITE_FILE);
        FileWriter writer = new FileWriter(new File(Paths.WRITE_FILE));
        writer.write(Matrix.toString(matrix));
        writer.close();
        
        
    }
    
    
    
}
