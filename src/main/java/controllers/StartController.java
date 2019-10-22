package controllers;


import db.pojo.TableMimimi;
import db.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@Controller
public class StartController {
    private static final Logger logger=Logger.getLogger(StartController.class.getSimpleName());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex() {
        logger.info("Run: RequestMapping(value = \"/\",method = RequestMethod.GET) ");

        return "WEB-INF/pages/index.jsp";
    }



}
