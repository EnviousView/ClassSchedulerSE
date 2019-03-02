<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!Home Page</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel ="stylesheet" type ="text/css" href ="design/styles.css">
    </head>
    <body>
    <div class = "main-header">
    	<img src = "design/architecture.png" height = "85" width = "85" style = "float: left" alt = "arch_logo">
        <h1>COLLEGE OF ARCHITECTURE</h1>
        <h5>CLASS SCHEDULER</h5>
    </div>
        <br>
        <br>
        <form action="InputServletArkiUST" method="post">
        <div class="row align-items-center justify-content-center">
            <div class="card w-50">
                <h5 class="card-header">Year</h5>
                <div class ="card-body">                    
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="sltyrlvl" required>Select Year Level</label>
                            </div>
                                <div class="col-sm-6">
                                    <select class="form-control form-control-sm" name="yearLevel" id="sltyrlvl" required>
                                        <option value="1">First Year</option>
                                        <option value="2">Second Year</option>
                                        <option value="3">Third Year</option>
                                        <option value="4">Fourth Year</option>
                                        <option value="5">Fifth Year</option>
                                    </select>
                                </div>
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="cutoffTime">Cut-Off Time</label>
                            </div>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" id="cutoffTime" name="cutofftimeFrom" placeholder="Cut-Off Time From" min="0" max="24" size="2" required>
                                </div>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" id="cutoffTime" name="cutofftimeTo" placeholder="Cut-Off Time To" min="0" max="24" size="2" required>
                                </div>
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="numofSec">Number of Sections</label>
                            </div>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" id="numofSec" name="numofSection" placeholder="No. of Sections" min="0" max="99" size="2" required>
                            </div>    
                        </div>        
                        <br>
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="sltSem">Semester</label>
                            </div>
                            <div class="col-sm-6">
                                <select class="form-control form-control-sm" name="semester" id="sltSem" required>
                                    <option value="1">First Term</option>
                                    <option value="2">Second Term</option>
                                    <option value="3">Special Term</option>
                                </select>
                            </div>
                        </div>    
                        <br>
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="schoolYr">School Year</label>
                            </div>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" id="schoolYr" name="sy" placeholder="School Year" min="2019" max="2999" size="4" required>    
                            </div>
                        </div>  
                </div>
            </div>
        </div>
        <br>
        <div class="row align-items-center justify-content-center">
            <div class="card w-50">
                <h5 class="card-header">Curriculum</h5>
                <div class ="card-body">
                    <div class="form-check form-check-inline">
                        <div class="col-sm-4">
                            <label for="add">Method</label>
                        </div>
                        <div class="col-sm-6">
                            <input class="form-check-input" type="radio" name="method" id="add" value="AddCurriculum" required>
                            <label class="form-check-label" for="add">Add Curriculum</label>
                        </div>
                        <div class="col-sm-6">
                            <input class="form-check-input" type="radio" name="method" id="select" value="RetrieveCurriculum">
                            <label class="form-check-label" for="select">Select Curriculum</label>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group row">
                        <div class="col-sm-4">
                            <label for="noofC">Number of Courses</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="number" class="form-control" id="noofC" name="numofC" placeholder="No. of Courses" min="0" max="99" size="2" required>
                            <br>
                            <input type="submit" class="btn btn-grey" name="Submit">
                        </div>
                    </div>  
                </div>
            </div>
        </div>
        </form>
        <br>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        
    </body>
</html>