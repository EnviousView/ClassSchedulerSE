package com.system.web;

import com.system.model.Curriculum;
import com.system.model.CurriculumList;
import com.system.model.DBConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CalvinGabriel
 */
public class UpdateCurriculum extends HttpServlet {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String strCourseCode, strCourseName, strStudUnit, strLecUnit, strPairingDays;
    private int nNumDays;
    private float fDay1, fDay2, fDay3;        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        String btnAction = request.getParameter("btnManage");
        String[] sCrsCode = request.getParameterValues("courseCode");
        String[] sCrsName = request.getParameterValues("courseName");
        String[] sStudUnits = request.getParameterValues("courseStudUnits");
        String[] sLecUnits = request.getParameterValues("courseLecUnits");
        String[] sNumDays = request.getParameterValues("courseNumDays");
        String[] sPairDays = request.getParameterValues("pairingDays");
        String[] sDay1 = request.getParameterValues("day1");
        String[] sDay2 = request.getParameterValues("day2");
        String[] sDay3 = request.getParameterValues("day3");
        DBConnectionManager dbconn = new DBConnectionManager();
        con = dbconn.getConnection();
        HttpSession ssn = request.getSession(false);
        if(ssn == null)
        {
            ssn = request.getSession();
        }
        List clumList = (List)ssn.getAttribute("selectedClumList");            
        String yearID =  (String) ssn.getAttribute("selectedYrId"); 
        if(btnAction.equals("Save"))
        {                
            for(int i = 0;i < sCrsCode.length; i++)
            {
                String[] isCrsCode = sCrsCode[i].split(",");
                String[] isCrsName = sCrsName[i].split(",");
                String[] isStudUnits = sStudUnits[i].split(",");
                String[] isLecUnits = sLecUnits[i].split(",");
                String[] isNumDays = sNumDays[i].split(",");
                String[] isPairDays = sPairDays[i].split(",");
                String[] isDay1 = sDay1[i].split(",");
                String[] isDay2 = sDay2[i].split(",");
                String[] isDay3 = sDay3[i].split(",");

                    for(int j=0; j < sCrsCode.length; j++)
                    {
                        CurriculumList cl = new CurriculumList();
                        List rcurriculumList = cl.addCurriculum(isCrsCode[j], isCrsName[j], Integer.parseInt(isStudUnits[j]), Integer.parseInt(isLecUnits[j]), Integer.parseInt(isNumDays[j]), isPairDays[j], Float.parseFloat(isDay1[j]), Float.parseFloat(isDay2[j]), Float.parseFloat(isDay3[j]));
                        Iterator it = rcurriculumList.iterator();
                        while(it.hasNext())
                        {
                            Curriculum clum = (Curriculum)it.next();
                            
                            if(clumList.contains(clum.getCourseCode()))
                            {    
                                String query = "UPDATE Curriculum SET Course_Code = ?, Course_Name = ?,Studio_Unit = ?,Lec_Unit = ?,No_of_Days = ?,Pairing_Days = ?, Day1 = ?,Day2 = ?,Day3 = ? WHERE CourseCode = ?;";
                                ps = con.prepareStatement(query);

                                ps.setString(1, clum.getCourseCode());
                                ps.setString(2, clum.getCourseName());
                                ps.setInt(3, clum.getStudioUnits());
                                ps.setInt(4, clum.getLectureUnits());
                                ps.setInt(5, clum.getNumDays());
                                ps.setString(6, clum.getPairingDays());
                                ps.setFloat(7, clum.getDay1());
                                ps.setFloat(8, clum.getDay2());
                                ps.setFloat(9, clum.getDay3());
                                ps.setString(10, clum.getCourseCode());
                                int psi = ps.executeUpdate();
                                if(psi!=0)
                                {
                                    System.out.println("Data inserted");
                                }
                                else
                                {
                                    System.out.println("Failed to insert data");
                                }
                            }
                            else
                            {
                                String query = "INSERT INTO Curriculum(Course_Code,Course_Name,Studio_Unit,Lec_Unit,No_of_Days,Pairing_Days,Day1,Day2,Day3,yearID) VALUES(?,?,?,?,?,?,?,?,?,?);";
                                ps = con.prepareStatement(query);

                                ps.setString(1, clum.getCourseCode());
                                ps.setString(2, clum.getCourseName());
                                ps.setInt(3, clum.getStudioUnits());
                                ps.setInt(4, clum.getLectureUnits());
                                ps.setInt(5, clum.getNumDays());
                                ps.setString(6, clum.getPairingDays());
                                ps.setFloat(7, clum.getDay1());
                                ps.setFloat(8, clum.getDay2());
                                ps.setFloat(9, clum.getDay3());
                                ps.setString(10, yearID);

                                int psi = ps.executeUpdate();
                                if(psi!=0)
                                {
                                    System.out.println("Data inserted");
                                }
                                else
                                {
                                    System.out.println("Failed to insert data");
                                }
                            }
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("EditCurriculum.jsp");
                        rd.forward(request, response);
                    }
                }                
            }
            else
            {
                String dbQuery = "SELECT Course_Code,Course_Name,Studio_Unit,Lec_Unit,No_of_Days,Pairing_Days,Day1,Day2,Day3 From Curriculum WHERE yearID= ?";
                ps = con.prepareStatement(dbQuery);
                rs = ps.executeQuery();
                while(rs.next())
                {
                    rs.getString("Course_Code");
                }    
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {            
            if(ps != null)
            {
                try
                {
                    System.out.println("PREPARED STATEMENT IS CLOSED");
                    ps.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }    
            }
            if(con != null)
            {
                try
                {
                    System.out.println("CONNECTION IS CLOSED");
                    con.close();
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }    
            }    
        }
    }   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
