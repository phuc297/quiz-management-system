package CONNECT;

import UTILS.ConnectStringFileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private static Connection connection;
    private static String url;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                ConnectStringFileReader fileReader = new ConnectStringFileReader();
                url = fileReader.readConnectionStringFromFile("sqlConnectString.txt");

                if (url != null) {
                    connection = DriverManager.getConnection(url);
                    System.out.println("Connected to database.");
                }else{
                    System.out.println("Connection failed.");
                    JOptionPane.showMessageDialog(null, "Kiểm tra lại chuỗi kết nối");
                }

            } catch (SQLException e) {
                System.out.println("Connection failed.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
