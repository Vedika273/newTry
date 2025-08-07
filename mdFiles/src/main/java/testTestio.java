import java.io.*;
import java.util.Scanner;

public class testTestio {

    public static void main(String[] args) throws IOException {
        String filePath = "/C:/Users/Vedika/OneDrive/Documents/programming exam is soon.csv/";
        //try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        try (Scanner reader = new Scanner(new FileReader(filePath))) {
            String line;
            //while ((line = reader.nextLine()) != null) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());  // print the whole CSV line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // text output
        // over-write mode
        String file = "C:\\Users\\Vedika\\OneDrive\\Documents\\programmingTest.csv";
        try (FileWriter fw = new FileWriter(file, true)) {        // appending mode
            fw.write("hello");
        } catch (IOException e) {
            System.out.println("Fail to write to the file");
        }
        // once the try-catch structure is over, the input resource will be released
    }
}



