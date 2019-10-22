package controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logaut extends HttpServlet {
    private static final Logger logger=Logger.getLogger(Logaut.class.getSimpleName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doGet(HttpServletRequest req, HttpServletResponse resp) ");
        req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doPost(HttpServletRequest req, HttpServletResponse resp) ");
        req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req,resp);
    }
}
