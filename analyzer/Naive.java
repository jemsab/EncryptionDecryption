package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Naive implements PatternAlgorithm {

    @Override
    public boolean matchFileType(String fileName, String pattern) {
        boolean fileContainsPattern = false;

        byte[] patternByteArray = pattern.getBytes();

        try{
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
                    fileContainsPattern = true;
                    break;
                }
            }

            if (! isDocumentFormat)
                fileContainsPattern = false;
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileContainsPattern;
    }


}
