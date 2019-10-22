package db.dao;

import com.sun.org.apache.bcel.internal.generic.Select;
import db.connections.ConnectionManager;
import db.connections.ConnectionManagerPostgeImpl;
import db.pojo.UserDate;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataDaoImpl implements UserDataDAO {
    private static ConnectionManager connectionManager =
            ConnectionManagerPostgeImpl.getInstance();

    private static final Logger logger=Logger.getLogger(UserDataDaoImpl.class.getSimpleName());

    @Override
    public boolean authClient(String login, String password) throws SQLException {
        logger.info("Run: boolean authClient(String login, String password) ");
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id,login,password,enabled,role " +
                "FROM public.users WHERE login = ? AND password = ?"
        );
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet set = statement.executeQuery();
        List<UserDate> userDataList = new ArrayList<>();
        while (set.next()) {
            UserDate userData = new UserDate(
                    set.getInt("id"),
                    set.getString("login"),
                    set.getString("password"),
                    set.getBoolean("enabled"),
                    set.getString("role")

            );
            userDataList.add(userData);
        }
        connection.close();

        boolean f = false;
        for (int i = 0; i < userDataList.size(); i++) {
            if (userDataList.get(i).getLogin().equals(login)
                    && userDataList.get(i).getPassword().equals(password)) {
                f = true;
            }
        }
        return f;
    }

    @Override
    public void writeNewClient(String login, String password) {
        logger.info("Run: void writeNewClient(String login, String password)");
        Connection connection = connectionManager.getConnection();
        int countMaxID=new UserDataDaoImpl().maxClient()+1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO public.users (id ,login,password," +
                    "enabled,role ) VALUES(?,?,?,TRUE ,'role_user');"
            );
            preparedStatement.setInt(1, countMaxID);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3,  password);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int maxClient() {
        logger.info("Run: int maxClient()");
        Connection connection = connectionManager.getConnection();
        int maxUser=0;
        try {
            ResultSet resultSet=connection.createStatement().executeQuery("SELECT MAX(id) FROM public.users");
            connection.close();
            resultSet.next();
            maxUser =resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxUser;
    }

    @Override
    public boolean coincidenceClient(String login_c)  {
        logger.info("Run: boolean coincidenceClient(String login_c)");
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        boolean f = false;
        try {
            statement = connection.prepareStatement("SELECT login FROM public.users WHERE login = ? AND enabled=TRUE " );
            statement.setString(1, login_c);

            ResultSet set = statement.executeQuery();
            List<UserDate> userDataList = new ArrayList<>();
            while (set.next()) {
                UserDate userData = new UserDate(
                        set.getString("login")
                );
                userDataList.add(userData);
            }
            connection.close();

            for (int i = 0; i < userDataList.size(); i++) {
                if (userDataList.get(i).getLogin().equals(login_c)) {
                    f = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
        }

}

