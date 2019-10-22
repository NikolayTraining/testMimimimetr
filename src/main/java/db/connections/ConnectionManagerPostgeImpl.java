package db.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManagerPostgeImpl implements ConnectionManager {

    private static ConnectionManager connectionManager;

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerPostgeImpl();
        }
        return connectionManager;
    }

    private ConnectionManagerPostgeImpl() {
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        ResourceBundle rb = ResourceBundle.getBundle("parametrs"); // parametrs.properties

        try {
            Class.forName(rb.getString("driverBase"));

            connection = DriverManager.getConnection(
                    rb.getString("baseUrl"),
                    rb.getString("baseUser"),
                    rb.getString("basePassword")
            );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}