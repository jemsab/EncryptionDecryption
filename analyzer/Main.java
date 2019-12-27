package analyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        int debugCounter = 0;

        final String fileName = args[0];
        final String patternString = args[1];
        final String resultString = args[2];

        byte[] patternByteArray = patternString.getBytes();


        try(InputStream is = new FileInputStream(fileName)){

            byte[] fileBytes = Files.readAllBytes(Paths.get(fileName));

            boolean isDocumentFormat = true;

            for(int i = 0; i < fileBytes.length; i++){

                if (i < (fileBytes.length - patternByteArray.length)){
                    for(int j = 0; j < patternByteArray.length; j++){
                        if(! (fileBytes[i + j] == patternByteArray[j])){
                            isDocumentFormat = false;
                        } else {
                            isDocumentFormat = true;
                        }
                    }

                }
                if(isDocumentFormat){
                    System.out.println(resultString);
                    break;
                }

            }

            if (! isDocumentFormat)
                System.out.println("Unknown file type");
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
