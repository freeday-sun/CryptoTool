package fileProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {

    public List<String> readFile(Path file) {
        if (isFileBad(file))
            return null;

        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Path file, String content) {
        if (isFileBad(file))
            return;

        try {
            Files.writeString(file, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isFileBad(Path file) {
        if (!FilePathValidator.isFileExists(file)) {
            System.out.printf("Cannot access file %s", file.toAbsolutePath());
            return true;
        }
        return false;
    }
}
