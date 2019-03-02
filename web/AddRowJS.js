$(document).ready(function () 
            {
                var counter = 0;

                $("#addrow").on("click", function (event) 
                {
                    var newRow = $("<tr>");
                    var cols = "";

                    cols += '<td><input type="text" class="form-control" name="courseCode"/></td>';
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



            $("table.order-list").on("click", ".ibtnDel", function (event) 
            {
                $(this).closest("tr").remove();
            });


            });


