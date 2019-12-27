package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static PatternAlgorithm patternAlgorithm;

    public static void main(String[] args) {

        switch(args[0]){
            case "--naive":
                patternAlgorithm = new Naive();
                break;
            case "--KMP":
                patternAlgorithm = new KMP();
                break;
            default :
                patternAlgorithm = new Naive();
                break;
        }

        final String fileName = args[0];
        final String pattern = args[1];
        final String result = args[2];

        boolean fileContainsPattern = patternAlgorithm.matchFileType(fileName, pattern);

        if (fileContainsPattern)
            System.out.println(result);
        else
            System.out.println("Unknown file type");



    }
}
