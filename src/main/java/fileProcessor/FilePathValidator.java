package fileProcessor;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathValidator {

    public static boolean isFileExists(Path filePath){
        return Files.exists(filePath);
    }

}
