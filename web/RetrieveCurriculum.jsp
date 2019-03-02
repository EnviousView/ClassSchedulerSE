<%-- 
    Document   : RetrieveCurriculum
    Created on : 02 17, 19, 8:15:45 PM
    Author     : CalvinGabriel
--%>

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
        <form action="RetrieveCurriculumUSTArki" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="card w-75 border-white">
                <div class="card-body">
                    <div class="form-group row">
                        <input type="submit" name="selectCurr" value="FIRST YEAR CURRICULUM" class="btn btn-outline-dark btn-lg btn-block">
                        <input type="submit" name="selectCurr" value="SECOND YEAR CURRICULUM" class="btn btn-outline-dark btn-lg btn-block">
                        <input type="submit" name="selectCurr" value="THIRD YEAR CURRICULUM" class="btn btn-outline-dark btn-lg btn-block">
                        <input type="submit" name="selectCurr" value="FOURTH YEAR CURRICULUM" class="btn btn-outline-dark btn-lg btn-block">
                        <input type="submit" name="selectCurr" value="FIFTH YEAR CURRICULUM" class="btn btn-outline-dark btn-lg btn-block">
                    </div>   
                </div>   
            </div>    
        </div>
        </form>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    
    </body>
</html>
