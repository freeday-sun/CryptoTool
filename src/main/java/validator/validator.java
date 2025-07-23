package validator;

import validator.BadKeyException.BadKey;
import fileProcessor.BadFilePathException.BadFilePathExpection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class validator {

    public static void validateKey(int key){
        if (key < 0) {
            throw new BadKey("Key is supposed to be > 0 but a negative integer was provided");
        }
    }

    public void validateFile(Path file) {
        try {
            isFileBad(file);
        } catch (BadFilePathExpection e) {
            throw new RuntimeException(e);
        }
    }

    private void isFileBad(Path file) throws BadFilePathExpection {
        if (isFileNonexists(file)) {
            throw new BadFilePathExpection("Cannot access file " + file.toAbsolutePath());
        } else if (isDirectory(file)) {
            throw new BadFilePathExpection("Provided file is a directory!");
        } else if (isFileEmpty(file)) {
            throw new BadFilePathExpection("File is empty!");
        }
    }

    private boolean isFileNonexists(Path filePath) {
        return Files.notExists(filePath);
    }

    private boolean isDirectory(Path filePath) {
        return Files.isDirectory(filePath);
    }

    private boolean isFileEmpty(Path filePath){
        try {
            return Files.size(filePath) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
