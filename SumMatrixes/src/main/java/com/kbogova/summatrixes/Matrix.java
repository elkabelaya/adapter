
package com.kbogova.summatrixes;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author elkabelaya
 */
public class Matrix {
    static String   toString(double[][] matrix){
        
        
        int rowsNumber;
        int columnsNumber;
        String result = "";
        
        if (matrix != null && matrix.length > 0){
            rowsNumber = matrix.length;
            columnsNumber = matrix[0].length;
            result = "matrix " + rowsNumber + "x" + columnsNumber + "\n";
            for (int i = 0; i < rowsNumber; i++){
                for (int j = 0; j < columnsNumber; j++){
                    result += matrix[i][j];
                    if (j<columnsNumber-1){
                       result += "\t";
                    }
                }
                result += "\n";
            }
        }
        return result;
    
    }
    
    public static boolean canSum(double[][] matrix1, double[][] matrix2){
        if (matrix1 != null && matrix2 != null &&
            matrix1.length > 0 && matrix2.length> 0 && 
            matrix1.length == matrix2.length && 
            matrix1[0].length == matrix2[0].length
        ){            
            
            return true;
        }
        
        return false;
    }
    
    static double[][] Sum(double[][] matrix1, double[][] matrix2){
        
        int rowsNumber = matrix1.length;
        int columnsNumber = matrix1[0].length;
        double[][] resultMatrix = new double[rowsNumber][columnsNumber];
        
        
        for (int i = 0; i < rowsNumber; i++){
            for (int j = 0; j < columnsNumber; j++){
                BigDecimal bd = new BigDecimal(Double.toString(matrix1[i][j] + matrix2[i][j]));
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                resultMatrix[i][j] = bd.doubleValue();
                
            }
        }
        
        return resultMatrix;
    
    }
}
