<%-- 
    Document   : EditCurriculum.jsp
    Created on : 02 27, 19, 11:18:37 AM
    Author     : CalvinGabriel
--%>

<%@page import="java.util.*" import="com.system.model.Curriculum" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editing a Curriculum</title> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script>
            function addRow() {

            var tableID="ticketCreate";
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;

            if(rowCount<9){
                //You declared var in front of the same variable twice. Don't do that.
                //You were appending cells inside existing cell. Add them to row instead.
                var row = table.insertRow(rowCount);
                var cell1 = row.insertCell(0);
                var element1 = document.createElement('input');
                element1.type="text";
                cell1.appendChild(element1);
                row.insertCell(1);
                row.insertCell(2);
            }
        }

        function removeRow(){
            var tableID="ticketCreate";
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;

            if(rowCount>1){   
                //you had type in deletRow. Also, you can pass in -1 to remove the last row        
                table.deleteRow(-1); 
            }
        }       
        </script>    
    </head>
    <body>
        <form action="EditCurriculumUSTArki" method="post">
            <table class="table table-borderless" id="ticketCreate">
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
                <td><input type="text" class="form-control" name="courseCode" value="<%out.println(courseCode);%>"></td>
                <td><input type="text" class="form-control" name="courseName" value="<%out.println(courseName);%>"></td>
                <td><input type="text" class="form-control" name="courseStudUnits" value="<%out.println(studUnit);%>"></td>
                <td><input type="text" class="form-control" name="courseLecUnits" value="<%out.println(lecUnit);%>"></td>
                <td><input type="text" class="form-control" name="courseNumDays" value="<%out.println(numofDays);%>"></td>
                <td>
                    <select class="form-control form-control-sm" name="pairingDays">
                        <option value="<%out.println(pairingDays);%>" selected><%out.println(pairingDays);%></option>
                        <option value="M">Monday</option>
                        <option value="T">Tuesday</option>
                        <option value="W">Wednesday</option>
                        <option value="Th">Thursday</option>
                        <option value="F">Friday</option>
                        <option value="S">Saturday</option>
                        <option value="M-T">M-T</option>
                        <option value="M-W">M-W</option>
                        <option value="M-Th">M-Th</option>
                        <option value="M-F">M-F</option>
                        <option value="M-S">M-S</option>
                        <option value="T-W">T-W</option>
                        <option value="T-Th">T-Th</option>
                        <option value="T-F">T-F</option>
                        <option value="T-S">T-S</option>
                        <option value="W-Th">W-Th</option>
                        <option value="W-F">W-F</option>
                        <option value="W-S">W-S</option>
                        <option value="Th-F">Th-F</option>
                        <option value="Th-S">Th-S</option>
                        <option value="F-S">F-S</option>
                    </select>
                </td>
                <td><input type="text" class="form-control" name="day1" value="<%out.println(day1);%>"></td>
                <td><input type="text" class="form-control" name="day2" value="<%out.println(day2);%>"></td>
                <td><input type="text" class="form-control" name="day3" value="<%out.println(day3);%>"></td>
            </tr>
            <% } %>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td><input type="button" class="btn btn-grey" id="addrow" value="Add Row" onclick="addRow()"></td>
                <td></td>
                <td><input type="submit" value="Submit" name="Submit" class="btn btn-grey"></td>
            </tr>       
            </table>
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

    </body>
</html>
