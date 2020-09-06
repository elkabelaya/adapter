
package com.kbogova.summatrixesclient;

/**
 *
 * @author elkabelaya
 */
public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException{
       System.out.println("summatrixesclient start");
        try {
            MatrixesHandler.generateMatrixes();
            MatrixesHandler.sumMatrixes();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("summatrixesclient complete");
    }
    
}
