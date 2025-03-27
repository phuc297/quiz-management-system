package CONNECT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryExecutor {

    private static QueryExecutor instance;
    private Connection con;

    public QueryExecutor() {
        con = DatabaseConnection.getConnection();
    }

    public static QueryExecutor getInstance() {
        if (instance == null) {
            instance = new QueryExecutor();
        }
        return instance;
    }

    public ResultSet ExcuteQuery(String query) {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(QueryExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int ExcuteNonQuery(String query) {
        try {
            Statement statement = con.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(QueryExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Object ExcuteScalar(String query) {

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object scalar = null;
            if (resultSet.next()) {
                scalar = resultSet.getObject(1);
            }
            return scalar;
        } catch (SQLException ex) {
            Logger.getLogger(QueryExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
