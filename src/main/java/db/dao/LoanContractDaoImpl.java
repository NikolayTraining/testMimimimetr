package db.dao;

import db.connections.ConnectionManager;
import db.connections.ConnectionManagerPostgeImpl;
import db.pojo.TableMimimi;
import org.apache.log4j.Logger;
import services.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LoanContractDaoImpl implements LoanContractDAO {
    private static ConnectionManager connectionManager =
            ConnectionManagerPostgeImpl.getInstance();

    private static final Logger logger=Logger.getLogger(LoanContractDaoImpl.class.getSimpleName());


    @Override
    public List<TableMimimi> loadingPicture() throws SQLException {
        logger.info("Run: List<TableMimimi> loadingPicture()");
        Connection connection = connectionManager.getConnection();

        String znach=" SELECT lc.id, lc.picture, lc.name, lc.counter " +
                      "FROM public.mimimi lc ORDER BY lc.counter DESC ";
        PreparedStatement statement = connection.prepareStatement(znach );
        ResultSet set = statement.executeQuery();
        List<TableMimimi> loan = new ArrayList<>();
        while (set.next()) {

            TableMimimi loadingPicture = new TableMimimi(
                    set.getInt("id"),
                    set.getString("picture"),
                    set.getString("name"),
                    set.getInt("counter")
            );
            loan.add(loadingPicture);
        }
        connection.close();

        return loan;
    }



    @Override
    public boolean regLoanPicture(String picture, String name_picture) {
        logger.info("Run: boolean regLoanPicture(String picture, String name_picture)");
        Connection connection = connectionManager.getConnection();

        int countMaxID=new LoanContractDaoImpl().maxPicture()+1;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO public.mimimi (id,picture,name,counter) VALUES(?,?,?,0);"
            );
            preparedStatement.setInt(1, countMaxID);
            preparedStatement.setString(2, "image/"+picture);
            preparedStatement.setString(3,name_picture);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean counterCatePicture(int id_picture, int counter_picture) {
        logger.info("Run: boolean counterCatePicture(int id_picture, int counter_picture)");
        Connection connection = connectionManager.getConnection();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE public.mimimi SET counter = ? WHERE id = ?;"
            );
            preparedStatement.setInt(1, counter_picture+1);
            preparedStatement.setInt(2, id_picture);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
            }

    @Override
    public int maxPicture() {
        logger.info("Run: int maxPicture()");
        Connection connection = connectionManager.getConnection();
        int maxPictur=0;
        try {
            ResultSet resultSet=connection.createStatement().executeQuery("SELECT MAX(id) FROM public.mimimi");
            connection.close();
            resultSet.next();
            maxPictur =resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxPictur;
    }


}
