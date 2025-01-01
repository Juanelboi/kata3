package software.ulpgc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ResourceDownloader {

    public static void download(String resourceUrl, String outputPath) {
        try {
            URL url = new URL(resourceUrl);
            InputStream inputStream = url.openStream();
            Path path = Paths.get(outputPath);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        } catch (IOException e) {

        }
    }
}