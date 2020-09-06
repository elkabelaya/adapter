
package com.kbogova.summatrixesclient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Scanner;
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
public class MatrixesHandlerTest {
    
    public MatrixesHandlerTest() {
    }
    
    /**
     * Test of sumMatrixes method, of class MatrixesHandler.
     */
    @Test
    public void testSumMatrixes() throws Exception {
        System.out.println("sumMatrixes");
        File testFile = new File("testfiles/test1.txt");
        File matrixesFile = new File(Paths.WRITE_MATRIXES_FILE);
        File resultFile = new File(Paths.WRITE_SUM_MATRIXES_FILE);
        File etalonFile = new File("testfiles/test1_etalon.txt");

        Files.copy(testFile.toPath(), matrixesFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        MatrixesHandler.sumMatrixes();
        
        byte[] f1 = Files.readAllBytes(resultFile.toPath());
        byte[] f2 = Files.readAllBytes(etalonFile.toPath());
        
        assert(Arrays.equals(f1, f2));
    }

    /**
     * Test of generateMatrixes method, of class MatrixesHandler.
     */
    @Test
    public void testGenerateMatrixes() throws Exception {
        Scanner fileScanner;
        Scanner lineScanner;
        String lineString;
        String[] temp;
        int numRows;
        int numColumns;
        int numMatrixes = 2;
        
        
        File f = new File(Paths.WRITE_MATRIXES_FILE);
        assert(true);
        
        System.out.println("generateMatrixes");
        MatrixesHandler.generateMatrixes();
        assert(f.exists());
        
        fileScanner = new Scanner (f);
        for (var i=0; i< numMatrixes; i++){
           
            lineString = fileScanner.nextLine();
            temp = lineString.split(" ");
            assert("matrix".equals(temp[0]));

            temp = temp[1].split("x");
            assert(temp.length == 2);

            numRows = Integer.parseInt(temp[0]);
            numColumns = Integer.parseInt(temp[1]);
            assert(numRows > 0 && numColumns > 0);

            while (fileScanner.hasNext() && numRows > 0){
                numColumns = Integer.parseInt(temp[1]);
                lineString = fileScanner.nextLine();
                numRows--;
                 lineScanner = new Scanner (lineString);
                    while (lineScanner.hasNext()){
                        numColumns--;
                        assert(!Double.isNaN(Double.parseDouble(lineScanner.next())));

                    }
            }

            assert(numRows == 0 && numColumns == 0);
        }
        
        
    }

    
    
}
