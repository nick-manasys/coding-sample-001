package nz.co.manasys.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * File utility class
 *
 */
public class FileUtility {
    public static String getFileContents(File file) {
        byte[] encoded = "".getBytes();
        try {
            encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(encoded);
    }

    public static void writeStringToFilename(String string, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(string);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
