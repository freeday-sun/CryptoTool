package fileProcessor;

import fileProcessor.BadFilePathException.BadFilePathExpection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {

    public List<String> readFile(Path file) {
        fileCheck(file);

        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Path file, String content) {
        fileCheck(file);

        try {
            Files.writeString(file, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fileCheck(Path file) {
        try {
              FilePathValidator.isFileBad(file);
        } catch (BadFilePathExpection e) {
            throw new RuntimeException(e);
        }
    }

}
