package com.system.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.*;
import com.system.model.DBConnectionManager;
import java.io.Serializable;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CalvinGabriel
 */
public class RetrieveCurriculum extends HttpServlet {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String dbQuery, yearID;
    private Set yrIdSet = new TreeSet();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String yrSelected = request.getParameter("selectCurr");
            DBConnectionManager dbCon = new DBConnectionManager();
            con = dbCon.getConnection();
            HttpSession ssn = request.getSession(false);
            if(ssn == null)
            {
                ssn = request.getSession();
            }
            if(yrSelected.equals("FIRST YEAR CURRICULUM"))
            {
                dbQuery = "SELECT yearID FROM YearLevel WHERE Year_Lvl = 1";
                stmt = con.prepareStatement(dbQuery);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    yearID = rs.getString("yearID").trim();                                      
                    yrIdSet.add(yearID);
                }                
                    System.out.println();
                    ssn.setAttribute("yearLevel", "First Year");
                    request.setAttribute("yrIdSet", yrIdSet);
                    RequestDispatcher rd = request.getRequestDispatcher("RetrieveCurrByYear.jsp");
                    rd.forward(request, response);                                
            }
            else if(yrSelected.equals("SECOND YEAR CURRICULUM"))
            {
                
                dbQuery = "SELECT yearID FROM YearLevel WHERE Year_Lvl = 2";
                stmt = con.prepareStatement(dbQuery);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    yearID = rs.getString("yearID");                                      
                    yrIdSet.add(yearID);
                }
                    System.out.println();
                    ssn.setAttribute("yearLevel", "Second Year");
                    request.setAttribute("yrIdSet", yrIdSet);
                    RequestDispatcher rd = request.getRequestDispatcher("RetrieveCurrByYear.jsp");
                    rd.forward(request, response);                                
            }
            else if(yrSelected.equals("THIRD YEAR CURRICULUM"))
            {
                
                dbQuery = "SELECT yearID FROM YearLevel WHERE Year_Lvl = 3";
                stmt = con.prepareStatement(dbQuery);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    yearID = rs.getString("yearID");                                      
                    yrIdSet.add(yearID);
                }
                    System.out.println();
                    ssn.setAttribute("yearLevel", "Third Year");
                    request.setAttribute("yrIdSet", yrIdSet);
                    RequestDispatcher rd = request.getRequestDispatcher("RetrieveCurrByYear.jsp");
                    rd.forward(request, response);                                
            }
            else if(yrSelected.equals("FOURTH YEAR CURRICULUM"))
            {
                
                dbQuery = "SELECT yearID FROM YearLevel WHERE Year_Lvl = 4";
                stmt = con.prepareStatement(dbQuery);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    yearID = rs.getString("yearID");                                      
                    yrIdSet.add(yearID);
                }
                    System.out.println();
                    ssn.setAttribute("yearLevel", "Fourth Year");
                    request.setAttribute("yrIdSet", yrIdSet);
                    RequestDispatcher rd = request.getRequestDispatcher("RetrieveCurrByYear.jsp");
                    rd.forward(request, response);                                
            }
            else if(yrSelected.equals("FIFTH YEAR CURRICULUM"))
            {
                
                dbQuery = "SELECT yearID FROM YearLevel WHERE Year_Lvl = 5";
                stmt = con.prepareStatement(dbQuery);
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    yearID = rs.getString("yearID");                                      
                    yrIdSet.add(yearID);
                }
                    System.out.println();
                    ssn.setAttribute("yearLevel", "Fifth Year");
                    request.setAttribute("yrIdSet", yrIdSet);
                    RequestDispatcher rd = request.getRequestDispatcher("RetrieveCurrByYear.jsp");
                    rd.forward(request, response);                                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    
        finally
        {
            if(rs != null)
            {
                try
                {
                    System.out.println("RESULT SET IS CLOSED");
                    rs.close();
                    
                }
                catch(SQLException ex)
                {
                    System.out.println("RESULT SET IS CLOSED");
                }    
            }
            if(stmt != null)
            {
                try
                {
                    System.out.println("PREPARED STATEMENT IS CLOSED");
                    stmt.close();
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
class yearSetAsc implements Comparator<String>
{
    @Override
    public int compare(String yearID1,String yearID2)
    {
        int val = yearID1.compareTo(yearID2);
            
        if(val == 0)
            return 0;
        else if(val < 0)
            return -1;
        else
            return 1;
    }        
}
