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
        
    </head>
    <body>
        <form action="UpdateCurriculumUSTArki" method="post">
            <table class="table table-borderless order-list" id="myTable">
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
                <td><input type="button" class="btn btn-grey " id="editrow" value="Edit"></td>
                <td><input type="button" class="ibtnDel btn btn-md btn-danger " value="Delete"></td>
            </tr>
            <% } %>                           
            </table>
            <div class="row align-items-center justify-content-center">
                <input type="submit" value="Select" name="btnManage" class="btn btn-grey">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Save" name="btnManage" class="btn btn-grey">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="Add Course" name="btnAdd" class="btn btn-grey"  id="addrow">
            </div>  
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
            

            $("#addrow").on("click", function (event) 
                {
                    var newRow = $("<tr>");
                    var cols = "";

                    cols += '<td><input type="text" class="form-control" name="courseCode" value=""/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseName"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseStudUnits"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseLecUnits"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseNumDays"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day0"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day1"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day2"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day3"/></td>';

                    cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger " value="Delete"></td>';
                    newRow.append(cols);
                    $("table.order-list").append(newRow);
                });
            $("#editrow").on("click", function (event) 
                {
                    $(this).closest("tr").remove();
                    var newRow = $("<tr>");
                    var cols = "";
                    var cN = $(this).closest("tr").find('td:eq(0)').text();
                    var cC = $(this).closest("tr").find('td:eq(1)').text();
                    var sU = $(this).closest("tr").find('td:eq(2)').text();
                    var lU = $(this).closest("tr").find('td:eq(3)').text();
                    var nD = $(this).closest("tr").find('td:eq(4)').text();
                    var pD = $(this).closest("tr").find('td:eq(5)').text();
                    var d1 = $(this).closest("tr").find('td:eq(6)').text();
                    var d2 = $(this).closest("tr").find('td:eq(7)').text();
                    var d3 = $(this).closest("tr").find('td:eq(8)').text();
                    
                    cols += '<td><input type="text" class="form-control" name="courseCode" value="' + cN +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseName" value="' + cC +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseStudUnits" value="' + sU +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseLecUnits" value="' + lU +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="courseNumDays" value="' + nD +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day0" value="' + pD +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day1" value="' + d1 +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day2" value="' + d2 +'"/></td>';
                    cols += '<td><input type="text" class="form-control" name="day3" value="' + d3 +'"/></td>';

                    cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger " value="Delete"></td>';
                    newRow.append(cols);
                    $("table.order-list").append(newRow);
                });
            $("table.order-list").on("click", ".ibtnDel", function (event) {
                $(this).closest("tr").remove();       
                
            });    
        });
        </script>    
    </body>
</html>
