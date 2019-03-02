package com.system.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import com.system.model.DBConnectionManager;
import com.system.model.CurriculumList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author CalvinGabriel
 */
public class RetrieveCurrByYear extends HttpServlet {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String dbQuery, courseCode, courseName, pairingDays;
    private int studUnit, lecUnit, numofDays;
    private float fday1, fday2, fday3;
    private List cl = new ArrayList();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String yearId = request.getParameter("yearIDList"); 
            DBConnectionManager dbcon = new DBConnectionManager();
            CurriculumList clumList = new CurriculumList();
            
            con = dbcon.getConnection();
            dbQuery = "select c.Course_Code, c.Course_Name, c.Studio_Unit, c.Lec_Unit, c.No_of_Days, c.Pairing_Days, c.Day1, c.Day2, c.Day3 from Curriculum c INNER JOIN  YearLevel y ON c.yearID = y.yearID where c.yearID=?";
            ps = con.prepareStatement(dbQuery);
            ps.setString(1, yearId);
            HttpSession ssn = request.getSession(false);
            if(ssn == null)
            {
                ssn = request.getSession();
            }
            rs = ps.executeQuery();
            while(rs.next())
            {
                courseCode = rs.getString("Course_Code");
                courseName = rs.getString("Course_Name");
                studUnit = rs.getInt("Studio_Unit");
                lecUnit = rs.getInt("Lec_Unit");
                numofDays = rs.getInt("No_of_Days");
                pairingDays = rs.getString("Pairing_Days");
                fday1 = rs.getFloat("Day1");
                fday2 = rs.getFloat("Day2");
                fday3 = rs.getFloat("Day3");
                System.out.println(courseCode);
                cl = clumList.addCurriculum(courseCode, courseName, studUnit, lecUnit, numofDays, pairingDays, fday1, fday2, fday3);
            }
            //System.out.println(courseCode);
            ssn.setAttribute("selectedClumList", cl);
            RequestDispatcher rd = request.getRequestDispatcher("SelectedCurrByYear.jsp");
            rd.forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
