
package com.kbogova.summatrixesclient;

import com.kbogova.summatrixes.MatrixesSummator;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author elkabelaya
 */
public class MatrixSummatorAdapter implements IMatrixesSummator{
    
    @Override
    public void sum() throws Exception{
        sum(Paths.WRITE_MATRIXES_FILE, Paths.WRITE_SUM_MATRIXES_FILE);
    }
    
    //renames file, for MatrixesSummator could handle them 
    //calls MatrixesSummator.run
    //and then renames result file
    private void sum(String fromReadFile, String toWriteFile) throws Exception{
        System.out.println("adapt path names");
        
        String adaptedPathFrom = com.kbogova.summatrixes.Paths.READ_FILE;
        String adaptedPathTo = com.kbogova.summatrixes.Paths.WRITE_FILE;
        
        copyFile(fromReadFile, adaptedPathFrom);
        MatrixesSummator summator = new MatrixesSummator();
        summator.run();
        renameFile(adaptedPathTo, toWriteFile);
        deleteFile(adaptedPathFrom);
        deleteFile(adaptedPathTo);
    }
    
    
    private void renameFile (String fromName, String toName) throws Exception{
        File originalFile = new File(fromName);
        File renamedFile = new File(toName);

        if (!originalFile.exists()){
           throw new Exception( fromName + " does not  exists");
        }


        boolean success = originalFile.renameTo(renamedFile);

        if (!success) {
           throw new Exception( "error on rename files");
        }
    }
    
    private void copyFile (String fromName, String toName) throws Exception{
        File originalFile = new File(fromName);
        File renamedFile = new File(toName);

        Files.copy(originalFile.toPath(), renamedFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        
    }
    
    private void deleteFile (String name){
        try{
            File file = new File(name); 
            file.delete();
        } catch(Exception ex){
             //do nothing if not deleted succssfully - it doesn't influent to main logics
        }

       
    }
   
}
