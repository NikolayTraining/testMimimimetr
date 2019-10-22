package services;

import db.dao.LoanContractDAO;
import db.dao.LoanContractDaoImpl;
import db.dao.UserDataDAO;
import db.dao.UserDataDaoImpl;
import db.pojo.TableMimimi;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService {

    private static final Logger logger=Logger.getLogger(UserService.class.getSimpleName());

    private static LoanContractDAO loanContractDAO = new LoanContractDaoImpl();
    private static UserDataDAO userDataDAO = new UserDataDaoImpl();
    private static List<TableMimimi> tableOutPageCat = new ArrayList<>();
    ResourceBundle rb = ResourceBundle.getBundle("parametrs");


    public boolean regPicture(String picture,String name_picture){
        logger.info(" Run: boolean regPicture(String picture,String name_picture)");
        return loanContractDAO.regLoanPicture(picture, name_picture);
    }

    public boolean checkAuthClient (String login, String password) throws SQLException {
        logger.info(" Run: boolean checkAuthClient (String login, String password)");
        return  userDataDAO.authClient(login,password);
    }

    public boolean writeNewClient(String login, String password){
        logger.info(" Run: boolean writeNewClient(String login, String password) ");
        if ( userDataDAO.coincidenceClient(login)!=true) {
            userDataDAO.writeNewClient(login, password);
            return true;
        }else return false;
    }

    public String coderUTF(String codeISO){
        logger.info(" Run: String coderUTF(String codeISO) ");
        String out1UTF = null;
        if (codeISO!=null) {
            try {
                out1UTF = new String(codeISO.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return out1UTF;
    }

    public List<TableMimimi> loadingPictureTable()throws SQLException{
        //Each cat can be proposed for voting only once.
        //Pairs must be chosen randomly for each user
        logger.info(" Run: List<TableMimimi> loadingPictureTable()  ");
        List<TableMimimi> randomCoteTable=new ArrayList<>();
        List<TableMimimi> tableCote=new CopyOnWriteArrayList<>(loanContractDAO.loadingPicture());
        Random random = new Random();
        int num=0;
        int count =tableCote.size();
        // implementation of randomization
        for (int i=0; i < count;i++) {
            num = random.nextInt(tableCote.size());
            randomCoteTable.add(tableCote.get(num));
            tableCote.remove(num);
        }

        return randomCoteTable;
    }




    public boolean counterCatePictureWriteTable(int id_picture,int counter_picture){
        logger.info(" Run: boolean counterCatePictureWriteTable(int id_picture,int counter_picture) ");
        loanContractDAO.counterCatePicture(id_picture,counter_picture);
        return true;
    }


    public List<TableMimimi> EndTableCat()throws SQLException{
        logger.info(" Run: List<TableMimimi> EndTableCat()  ");

        int i=0;
        while (i < (int)rb.getObject("mAX_QUANTITY_WITHDRAW_CAT")){
            tableOutPageCat.add(loanContractDAO.loadingPicture().get(i));
            i++;
        }
        return tableOutPageCat;
    }


}
