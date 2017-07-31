<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
   
    </head>
    <body>
       
        <nav class="navbar navbar-toggleable-md navbar-inverse  " style="background-color: #333333; margin-bottom: 10vh">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href='<c:url value="/home" />'>Home</a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item"> <!-- <li class="nav-item active"> -->
                    <a class="nav-link" href="#">1</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">2</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link " href="#">3</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link " href="#">4</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link " href="#">5</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link " href='#'>5</a>
                  </li>
                </ul>
               
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"> <!-- <li class="nav-item active"> -->
                        aaaa
                    </li>
                    <li class="nav-item">
                        bbbb
                    </li>
              
                </ul>
              
            </div>
        </nav>
        
    </body>
</html>
