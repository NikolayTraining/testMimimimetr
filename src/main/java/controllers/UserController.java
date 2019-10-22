package controllers;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.UserService;


@Controller
public class UserController {
    private static final Logger logger=Logger.getLogger(UserController.class.getSimpleName());
    private static UserService userService = new UserService();


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String appendUser( Model model){
        logger.info("Run: RequestMapping(value = \"/user\", method = RequestMethod.GET) ");
        return "WEB-INF/pages/user.jsp";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String appendUser(@RequestParam("userName") String name,
                             @RequestParam("userPassword") String age,
                             Model model){
        logger.info("Run: RequestMapping(value = \"/user\", method = RequestMethod.POST) ");
        model.addAttribute("nameUser",userService.coderUTF(name));
        model.addAttribute("password",userService.coderUTF(age));
        if (userService.writeNewClient(userService.coderUTF(name),userService.coderUTF(age))==false){

            model.addAttribute("Message","Пользователь с таким логином уже существует");
            return "WEB-INF/pages/user.jsp";
        }else {

            return "/loadPage";
        }

    }

}
