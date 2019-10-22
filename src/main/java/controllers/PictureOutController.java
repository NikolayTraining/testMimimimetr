package controllers;

import db.pojo.TableMimimi;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class PictureOutController extends HttpServlet {
    private static final Logger logger=Logger.getLogger(PictureOutController.class.getSimpleName());
    private static UserService userService = new UserService();
    private static List<TableMimimi> tableMimimiList= new ArrayList<>();
    List<TableMimimi> tableMimimiList2= new ArrayList<>();
    private static int count1=0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doGet(HttpServletRequest req, HttpServletResponse resp) ");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doPost(HttpServletRequest req, HttpServletResponse resp) ");

        if (tableMimimiList.isEmpty()) {
            try {
                tableMimimiList = userService.loadingPictureTable();
                tableMimimiList2 = new CopyOnWriteArrayList(tableMimimiList);
                count1 = 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recording voice reservations to the database
        if (!(req.getParameter("Button1") == null)) {
            userService.counterCatePictureWriteTable(tableMimimiList.get(count1-2).getId(),
                                                        tableMimimiList.get(count1-2).getCounter());
        }

        if (!(req.getParameter("Button2") == null)) {
            userService.counterCatePictureWriteTable(tableMimimiList.get(count1-2).getId(),
                                                        tableMimimiList.get(count1-2).getCounter());
        }
        if (!(req.getParameter("Button3") == null)) {
            userService.counterCatePictureWriteTable(tableMimimiList.get(count1-1).getId(),
                                                         tableMimimiList.get(count1-1).getCounter());

        }

        if (!(req.getParameter("Button4") == null)) {
            userService.counterCatePictureWriteTable(tableMimimiList.get(count1-1).getId(),
                                                            tableMimimiList.get(count1-1).getCounter());

        }



        if (tableMimimiList.size() > count1) {

            req.setAttribute("outPicture1", tableMimimiList2.get(0).getPicture());
            req.setAttribute("outName1", tableMimimiList2.get(0).getName_picture());
            req.setAttribute("outPicture2", tableMimimiList2.get(1).getPicture());
            req.setAttribute("outName2", tableMimimiList2.get(1).getName_picture());
            req.getRequestDispatcher("WEB-INF/pages/loadpage.jsp").forward(req, resp);


            tableMimimiList2.remove(0);
            tableMimimiList2.remove(0);
            count1++;
            count1++;
              } else {


            req.getRequestDispatcher("/outpageEnd").forward(req, resp);
            tableMimimiList=new ArrayList<>();
        }

    }

}
