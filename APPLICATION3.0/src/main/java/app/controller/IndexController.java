
package app.controller;

import app.model.User;
import app.model.dao.UserDao;
import app.service.UserDaoService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class IndexController implements Serializable{
    
    @Inject
    @Default
    UserDaoService<User> userDaoService;
    
    public void testMethod(){
        
        System.out.println("testMethod");
        
        User user = new User("ADMIN", "dasdfdsdasd");
        System.out.println(user);
        
        userDaoService.save(user);
        
      /*   List<User> userList  = userDaoService.getUserList();
         if(userList != null || !userList.isEmpty()){
            userList.forEach(System.out::println);
         }
        */
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUcces", "Udao Się");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
