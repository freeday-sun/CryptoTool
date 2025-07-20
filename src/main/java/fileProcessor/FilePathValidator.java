package fileProcessor;

import fileProcessor.BadFilePathException.BadFilePathExpection;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathValidator {

    public static boolean isFileExists(Path filePath){
        return Files.exists(filePath);
    }

    public static boolean isDirectory(Path filePath){
        return Files.isDirectory(filePath);
    }

    public static void isFileBad(Path file) throws BadFilePathExpection {
        if (!isFileExists(file)) {
            throw new BadFilePathExpection("Cannot access file " + file.toAbsolutePath().toString());
        } else if (!isDirectory(file)) {
            throw new BadFilePathExpection("Provided file is a directory!");
        }
    }

}
