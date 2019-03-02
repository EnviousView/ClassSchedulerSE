<%-- 
    Document   : SelectedCurrByYear
    Created on : 02 26, 19, 11:40:38 AM
    Author     : CalvinGabriel
--%>

<%@page import="java.util.*" import="com.system.model.Curriculum" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieved Curriculum</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    </head>
    <body>
        <form action="EditCurriculumUSTArki" method="post">
            <table class="table table-borderless">
            <tr>
                <th scope="col">Course Code</th>
                <th scope="col">Course Name</th>
                <th scope="col">Course Studio Units</th>
                <th scope="col">Course Lecture Units</th>
                <th scope="col">Course Number of Days</th>
                <th scope="col">Pairing Days</th>
                <th scope="col">Day1</th>
                <th scope="col">Day2</th>
                <th scope="col">Day3</th>
            </tr>
            <%List clumList = (List)session.getAttribute("selectedClumList");
              Iterator it = clumList.iterator();
              while(it.hasNext())
              {
            %>
            <tr>
                <%Curriculum clum = (Curriculum)it.next();
                  String courseCode = clum.getCourseCode();
                  String courseName = clum.getCourseName();
                  int studUnit = clum.getStudioUnits();
                  int lecUnit = clum.getLectureUnits();
                  int numofDays = clum.getNumDays();
                  String pairingDays = clum.getPairingDays();
                  float day1 = clum.getDay1();
                  float day2 = clum.getDay2();
                  float day3 = clum.getDay3();                  
                %>
                <td><%out.print(courseCode); %></td>
                <td><%out.print(courseName); %></td>
                <td><%out.print(studUnit); %></td>
                <td><%out.print(lecUnit); %></td>
                <td><%out.print(numofDays); %></td>
                <td><%out.print(pairingDays); %></td>
                <td><%out.print(day1); %></td>
                <td><%out.print(day2); %></td>
                <td><%out.print(day3); %></td>
            </tr>
            <%}%>
            <tr>
                <td></td>
                <td></td>
                <td></td>                
                <td><input type="submit" value="Select" name="manageCurr" class="btn btn-grey"></td>
                <td><input type="submit" value="Edit" name="manageCurr" class="btn btn-grey"></td>
            </tr>       
            </table>
        </form>
            
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

    </body>
</html>
