package app.controller;

import app.exceptions.UserNotFoundException;
import app.model.User;
import app.service.UserDaoService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HibernateTestController {
   
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private UserDaoService userDaoService;
   
    @Autowired(required=true)
    @Qualifier(value="userDaoService")
    public void setUserService(UserDaoService us){
	this.userDaoService = us;
    }
    
    @RequestMapping(value = "/SaveUser", method = RequestMethod.GET)
    public String saveUserTest(Model model){
        
        User user = new User();
        user.setUsername("Admin");
        user.setPassword("qwerty123456");
        
        userDaoService.save(user);
        
        user = new User();
        user.setUsername("Pawel");
        user.setPassword("wqdfdsfdsf");
        
        userDaoService.save(user);
        return "index";
    }
    
    @RequestMapping(value = "/GetUser", method = RequestMethod.GET)
    public String getUserTest(Model model){
        
        
        // userDaoService.getUserById(1).toString();
       // userDaoService.getUserById(6).toString();
         userDaoService.getUserByName("Admin").toString();
         userDaoService.getUserByName("dsadasd").toString();
       
        return "index";
    }
    
    @RequestMapping(value = "/GetUserList", method = RequestMethod.GET)
    public String getUserListTest(Model model){                
        
        model.addAttribute("userList", userDaoService.getUserList()); 
        return "userListPage";
    }
   
    @RequestMapping(value = "/CheckUserLogin", method = RequestMethod.GET)
    public String checkUserLoginExist(Model model){                
        
        logger.info("User result: "+userDaoService.checkUserLoginExist("Admin"));
        logger.info("User result: "+userDaoService.checkUserLoginExist("weqweqweq"));
        logger.info("User result: "+userDaoService.checkUserLoginExist("Pawel"));
        return "index";
    }
    
    
    
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFound(Model model){
        model.addAttribute("exceptionName", UserNotFoundException.class.getName());
        return "exceptionInfoPage";
    }


}
