package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practice {
     //write table like data
    public static void FileWriter(String path) {
        File file = new File("src/main/resources");
        try (FileWriter fw = new FileWriter("src/main/resources", true)) {
            //fw.write();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


