package controllers;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ResourceBundle;


@WebServlet("/imagepage/*")
public class PictureServlet extends HttpServlet {
    private static final Logger logger=Logger.getLogger(PictureServlet.class.getSimpleName());
    ResourceBundle rb = ResourceBundle.getBundle("parametrs");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doGet(HttpServletRequest req, HttpServletResponse resp) ");

        String URLAfterWebDomain = req.getRequestURI();
        System.out.println("TUTTT1 "+URLAfterWebDomain);
        if(URLAfterWebDomain.startsWith("/login/imagepage/") == false)
            return;
    //    String relativeImagePath = URLAfterWebDomain.substring("/".length());
        String relativeImagePath = StringUtils.substringAfterLast(URLAfterWebDomain,"imagepage/");
        System.out.println("TUTTT2 "+relativeImagePath);
        resp.setContentType("image/jpeg");
        ServletOutputStream outStream;
        outStream = resp.getOutputStream();

        FileInputStream fin = new FileInputStream(rb.getString("iMAGES_BASE_CAT")+relativeImagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch =0; ;
        while((ch=bin.read())!=-1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Run: void doPost(HttpServletRequest req, HttpServletResponse resp) ");
        doGet(req, resp);
    }
}
