package cryptoAlgorithms.caesar;

import Validator.BadKeyException.BadKey;
import Validator.Validator;
import fileProcessor.FileProcessor;

import java.util.Arrays;
import java.util.List;

public class Caesar {
    FileProcessor fileProcessor = new FileProcessor();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public void encrypt(String inputFile, String outputFile, int key) {
        List<String> fileContent = fileProcessor.readFile(inputFile);
        Validator.validateKey(key);
        fileProcessor.clearFile(outputFile);

        for (String line : fileContent) {
            char[] chArray = line.toLowerCase().toCharArray();
            char[] tempArray = new char[chArray.length];

            for (int i = 0; i < chArray.length; i++) {
                int index = Arrays.binarySearch(alphabet, chArray[i]);
                if (index == -1) {
                    tempArray[i] = chArray[i];
                } else {
                    tempArray[i] = alphabet[(index + key) % alphabet.length];
                }
            }
            fileProcessor.appendToFile(outputFile, new String(tempArray) + "\n");
        }

    }

    public void decrypt(String inputFile, String outputFile, int key) {
        encrypt(inputFile, outputFile, alphabet.length - (key % alphabet.length));
    }

}
