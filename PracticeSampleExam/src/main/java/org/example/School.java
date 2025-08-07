package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class School {

    public void export (String fileName) {
        File file = new File("src/main/resources" + fileName);
        try (FileWriter fw = new FileWriter(file)) {
            for ( User user : users) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
