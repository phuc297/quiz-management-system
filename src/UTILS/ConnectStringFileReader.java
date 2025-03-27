package UTILS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConnectStringFileReader {

    public String readConnectionStringFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String connectionString = reader.readLine();
            return connectionString;
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp tin: " + e.getMessage());
        }
        return null;
    }
}
