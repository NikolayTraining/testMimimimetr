package controllers;


import org.apache.log4j.Logger;
import services.UserService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Upload extends HttpServlet {
    private static final Logger logger=Logger.getLogger(Upload.class.getSimpleName());
    private static UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doGet(HttpServletRequest req, HttpServletResponse resp) ");
        req.getRequestDispatcher("WEB-INF/pages/adminload.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doPost(HttpServletRequest req, HttpServletResponse resp) ");
        String s= req.getParameter("description");
        userService.coderUTF(s);

        ServletContext sc = req.getServletContext();
        req.getPart("file");


        req.setAttribute("message2", "Picture Load");

        req.getRequestDispatcher("WEB-INF/pages/adminload.jsp").forward(req,resp);
    }


}
