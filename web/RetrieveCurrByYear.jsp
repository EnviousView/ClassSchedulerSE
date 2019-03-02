<%-- 
    Document   : RetrieveCurrByYear
    Created on : 02 25, 19, 6:28:58 PM
    Author     : CalvinGabriel
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieve a Curriculum</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Curriculum</h1>
        <% String yearLevel = (String)session.getAttribute("yearLevel");%>
        <h6 class="text-center"><%out.println(yearLevel);%></h6>
        <form action="RetrieveCurrByYearUSTArki" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="card w-25 border-white">
                <div class="card-body">
                    <div class="form-group row">
                        <select class="custom-select" name="yearIDList" data-style="btn-dark" data-live-search="true">
                        <%List yrSetList = new ArrayList();
                          yrSetList.addAll((Set)request.getAttribute("yrIdSet"));
                          Iterator it = yrSetList.iterator();
                          while(it.hasNext())
                          {%>
                          <% String yrId = (String)it.next();%>                          
                              <option value="<% out.print(yrId); %>" class="text-center"><%out.println(yrId);%></option>                          
                        <%}%>
                        </select>  
                    </div>
                    <div class="form-group row justify-content-center">
                        <input type="submit" name="manageCurr" value="Select" class="btn btn-grey">                        
                    </div>    
                </div>   
        </div>
        </form>
                    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
                    
    </body>
</html>
