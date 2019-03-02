<%-- 
    Document   : AssignRoom
    Created on : 01 29, 19, 12:28:39 PM
    Author     : CalvinGabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assign Rooms</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    </head>
    <body>
        <form action="AssignRoomServletArki" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="card w-50">
                <h5 class="card-header">Rooms</h5>
                <div class="card-body">
                    <div class="form-group row">
                        <br>
                        <div class="col-sm-4">
                            <label for="nStudRm">Number of Studio Rooms</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="nStudRm" name="numStudRoom">
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="col-sm-4">
                            <label for="nStudRm">Number of Lecture Rooms</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="nLecRm" name="numLecRoom">
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="col-sm-4">
                            <label for="nHybrdRm">Number of Hybrid Rooms</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="nHybrdRm" name="numHybrdRoom">
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="col-sm-4">
                            <label for="nCmpRm">Number of Computer Rooms</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="nCmpRm" name="numCompRoom">
                            <br>
                            <input type="submit" class="btn btn-grey" name="Submit" value="Submit">
                        </div>
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
