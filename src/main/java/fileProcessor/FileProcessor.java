package fileProcessor;

import validator.validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcessor {
    validator validator = new validator();

    public List<String> readFile(String filePath) {
        Path file = Path.of(filePath);

        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendToFile(String filePath, String content) {
        Path file = Path.of(filePath);

        try {
            Files.writeString(file, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile(String filePath){
        Path file = Path.of(filePath);

        try {
            Files.write(file, new byte[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validate(Path file) {
        validator.validateFile(file);
    }

}
