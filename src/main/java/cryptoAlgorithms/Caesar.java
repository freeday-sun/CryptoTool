package cryptoAlgorithms;

import fileProcessor.FileProcessor;

import java.nio.file.Path;

public class Caesar {
    FileProcessor fileProcessor = new FileProcessor();

    public void encrypt(String inputFile,String outputFile) {
        fileProcessor.write(Path.of(outputFile), fileProcessor.readFile(Path.of(inputFile)).get(0));
    }

    public void decrypt(String inputFile,String outputFile) {
        fileProcessor.write(Path.of(outputFile), fileProcessor.readFile(Path.of(inputFile)).get(0));
    }
}
