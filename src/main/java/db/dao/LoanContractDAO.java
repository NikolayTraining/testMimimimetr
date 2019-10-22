package db.dao;

import db.pojo.TableMimimi;

import java.sql.SQLException;
import java.util.List;

public interface LoanContractDAO {
    public List<TableMimimi> loadingPicture() throws SQLException;
    public boolean regLoanPicture(String picture, String name_picture);
    public boolean counterCatePicture(int id_picture, int counter_picture);
    public int maxPicture();
}
