package controllers;

import db.pojo.TableMimimi;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController extends HttpServlet{
    private static UserService userService = new UserService();
    private static final Logger logger=Logger.getLogger(IndexController.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doGet(HttpServletRequest req, HttpServletResponse resp) ");
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        String dataSource1=req.getParameter("dataSource");

        req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doPost(HttpServletRequest req, HttpServletResponse resp) ");
        String login = userService.coderUTF(req.getParameter("userName"));
        String password = userService.coderUTF(req.getParameter("userPassword"));

        try {
            if (login.equals("admin")&&userService.checkAuthClient(login,password)==true){
                System.out.println("sachol");
                req.getRequestDispatcher("WEB-INF/pages/adminload.jsp").forward(req, resp);
            }else {

                if (userService.checkAuthClient(login, password) == true) {

                    req.getRequestDispatcher("/loadPage").forward(req, resp);

                } else {
                    req.setAttribute("message", "ERROR Use Login");
                    req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}