package db.dao;

import java.sql.SQLException;

public interface UserDataDAO {
    public boolean authClient(String login, String password) throws SQLException;
    public void writeNewClient(String login, String password);
    public int maxClient();
    public boolean coincidenceClient(String login);
}
