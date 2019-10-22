package controllers;

import db.dao.UserDataDaoImpl;
import db.pojo.TableMimimi;
import org.apache.log4j.Logger;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OutPageEnd extends HttpServlet {
    private static UserService userService=new UserService();
    private static List<TableMimimi> tableMimimis=new ArrayList<>();
    private static final Logger logger=Logger.getLogger(OutPageEnd.class.getSimpleName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            logger.info(" Run: void doPost(HttpServletRequest req, HttpServletResponse resp)");
        try {

            tableMimimis=new CopyOnWriteArrayList<>(userService.EndTableCat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("EndTableCat",tableMimimis);

        req.getRequestDispatcher("WEB-INF/pages/loadpageend.jsp").forward(req,resp);
    }
}
