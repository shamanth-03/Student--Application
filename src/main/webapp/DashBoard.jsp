<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/js/all.min.js" integrity="sha512-b+nQTCdtTBIRIbraqNEwsjB6UvL3UEMkXnhzd8awtCYh0Kcsjl9uEgwVFVbhoj3uu1DO1ZMacNvLoyJJiNfcvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <title>Dashboard</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Outfit:wght@100..900&display=swap');
        *{
            font-family: "Outfit", sans-serif;

        }
        body{
           margin: 0px;
           padding: 0px; 
        }
        header{
            display: flex;
            background-color: darkblue;
            justify-content: space-between;
            border-radius: 0px 0px 15px 15px;
            width: 100%;
          


        }
        header h2{
            color: cadetblue;
            margin-left: 50px;
        
            
        }

        
        .menu{
            margin-right: 30px;
            /* width: 100%; */
            display: flex;
            justify-content: end;
            /* margin-left: 0px; */
        }
        .menu a{
            text-decoration: none;
            color: beige;
            margin: 0px 20px ;
            align-content:  center;
            
        }
        .menu a :hover{
            border-radius: 10px;
            background-color: beige;
            color: black;
            height: 40px;
            padding: 0px 5px;
            margin: 15px 0px;
            align-content:  center;
            
        }

        #logout{
            height: 50px;
            width: 80px;
            margin-top: 10px;
            margin-right: 50px;
            border: none;
            border-radius: 10px;
            background-color: red;
            color: beige;
            font-size: 17px;
            font-weight: bold;
            box-shadow: 0px 0px 10px black;
        }

        #logout:active {
            background-color: rgb(159, 13, 13);
        }

        .sec1{
            /* width: 100%; */
            padding: 30px 0px 30px 50px;
            /* border: 2px solid black; */
            border-radius: 10px;
            box-shadow: 0px 0px 10px black;
            margin: 20px;
        }
        .tab1{
            width:100%;     
        }
        .tab1 tr{
            font-size: 15px;
        }

        .sec2{
            height: 70px;
            width: 100%;
            background-color: darkblue;
            border-radius: 10px;
            display: flex;
            
           

        }
        #icon{
            position: relative;
            left: 37px;
            top:24px
        }
        #search{
            height: 35px;
            width: 250px;
            border-radius: 10px;
            border: none ;
            padding-left: 30px;
            margin-top: 15px;
            margin-left: 15px;
        }
        #search:active{
            border: none;
            
        }
        .details{
        font-weight: bold;
        }
        



    </style>
</head>
<body>
<% if(session.getAttribute("student")!=null){%>
<%Student s =(Student)session.getAttribute("student"); %>
    <header>
        <h2>Welcome <%=s.getName() %></h2>
        <div class="menu">
            <a href="#"><h3>Home</h3></a>
            <a href="Update.jsp"><h3>Update Account</h3></a>
            <a href="#"><h3>Reset Password</h3></a>
            <button id="logout" onclick="window.location.href='Login.jsp'">Log out</button>
        </div>

    </header>

    <main>
    <% if(request.getAttribute("success")!=null){%>
	<%request.getAttribute("success"); %>	<%}%>
        <section class="sec1">
            <h1>Student Details:</h1>
            <table class="tab1" >
               <tr class="details">
                    <td>Student ID: </td>
                    <!-- <td><input type="text" name="id"></td>                  -->
                    <td>Student Name: </td>
                    <!-- <td><input type="text" name="name"></td>    -->
                    <td>Student Phone No.: </td>
                    <!-- <td><input type="text" name="phone"></td>    -->
                    <td>Student Mail ID: </td>
                    <!-- <td><input type="text" name="mail"></td>    -->
                    <td>Student Branch: </td>
                    <!-- <td><input type="text" name="branch"></td> -->
                    <td>Student Location: </td>
                    <!-- <td><input type="text" name="loc"></td> -->
                </tr>
                
                <tr>
                <td><%=s.getId() %></td>
                <td><%=s.getName() %></td>
                <td><%=s.getPhone() %></td>
                <td><%=s.getMail() %></td>
                <td><%=s.getBranch() %></td>
                <td><%=s.getLoc() %></td>
                
                </tr>
                

            </table>


        </section>

        <section class="sec2">
            <i class="fa-solid fa-magnifying-glass" id="icon" ></i>
            <input type="search" name="search" id="search" placeholder="Search Users">

            
        </section>
        
    </main>
    <%} else{
    	request.setAttribute("error", "session expaired");
    	RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
    	rd.forward(request,response);
    }%>
    
</body>
</html>
