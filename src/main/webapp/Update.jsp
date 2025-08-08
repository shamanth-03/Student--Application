<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
   <title>Update Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }

        header {
            height: 60px;
            width: 100%;
            color: darkblue;
            font-size: 30px;
            text-align: center;
            margin-top: 20px;
        }

        header h1 {
            margin-top: 0;
            padding: 10px;
        }

        footer h2 {
            padding: 10px;
        }

        .heading {
            text-align: center;
        }

        main {
            height: 730px;
            width: 400px;
            box-shadow: 0px 0px 10px black;
            margin: 80px auto;
            border-radius: 10px;
            padding: 20px;
            /* text-align: center; */
        }


        .inputfield {
            display: flex;
            flex-direction: column;
            padding: 10px;
            font-size: large;

        }

        #txtbox {
            height: 30px;
            width: 350px;
            /* margin: 10px; */
            border-top-style: none;
            border-right-style: none;
            border-left-style: none;
            outline: none;
        }


        .inputfieldSelect{
            display: flex;

            padding: 10px;
            font-size: large;
        }


        .inputfieldSelect select {
            margin-left: 20px;
            width: 100px;

        }


        .btn {
            margin: 20px;
            text-align: center;
            height: 40px;
            width: 200px;
            border: none;
            border-radius: 5px;
            background-color: blue;
            color: white;
            font-size: larger;


        }


        .btn:hover {
            background-color: white;
            color: black;
            border: 1px solid black;
            cursor: pointer;
        }

        .txt {
            text-align: center;
            font-size: small;
        }
        .error{
        color: red;
        }
    </style>
</head>

<body>
    <header>
        <h1>Pentagon Space</h1>
    </header>
    <main> 
    <%if(session.getAttribute("student")!=null) {%>
    <%Student s=(Student)(session.getAttribute("student")); %>
        <form action="signup" method="post">
            <div class="heading">
                <h1>Update Details</h1>
            </div>
            
           
            
            <div class="inputfield">
                <label>Enter your Name: </label>
                <input type="text" name="name"  id="txtbox" value="<%=s.getName()%>">
            </div>

            <div class="inputfield">
                <label>Enter your Phone number: </label>
                <input type="tel" name="phone" id="txtbox" value="<%=s.getPhone()%>" >
            </div>

            <div class="inputfield">
                <label>Enter your Mail ID: </label>
                <input type="email" name="mail"  id="txtbox" value="<%=s.getMail()%>" >
            </div>

            
            <div class="inputfield">
                <label>Enter your Branch: </label>
                <input type="text" name="branch" id="txtbox" value="<%=s.getBranch()%>">
               
            </div>
            <div class="inputfield">
                <label>Enter your Location: </label>
                <input type="text" name="loc" required id="txtbox" value="<%=s.getLoc()%>">
            </div>
            <!-- <div class="inputfield">
                <label>Enter the Password: </label>
                <input type="password" name="password" required id="txtbox">
            </div>

            <div class="inputfield">
                <label>Confirm your Password: </label>
                <input type="password" name="confirm" required id="txtbox">
            </div> -->

            <center><input type="submit" value="Update" class="btn"></center>

            <div class="txt">
                <p> <a href="DashBoard.jsp">Click here</a> to go Back</p>
            </div>

        </form>
	<%}else{
    	request.setAttribute("error", "session expaired");
    	RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
    	rd.forward(request,response);
    }%>
	
    </main>

</body>

</html>

 
