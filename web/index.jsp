
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <meta charset="UTF-8">
    </head>
    <body>
        <div class="wrapper">
            <div class="content">
                <div class="loginContainer">
                    <form class="loginForm" action="UserInfo">
                        <div class="box1">
                            <span>
                                Login
                            </span>
                        </div>

                        <div class="box2">
                            <span>
                                <input class="user" type="number" placeholder="User" name="userInput" required />
                            </span>
                            
                            <span> 
                                <input class="password" type="password" placeholder="Password" name="passInput" required/>
                            </span>
                        </div>

                        <div class="box3">
                            <span>
                                <button class="summitBtn" type="submit">Login</button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
