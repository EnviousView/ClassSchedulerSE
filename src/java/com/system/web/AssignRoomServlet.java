package com.system.web;

import com.system.model.Curriculum;
import com.system.model.CurriculumList;
import com.system.model.DBConnectionManager;
import com.system.model.HashMapPlotting;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CalvinGabriel
 */
public class AssignRoomServlet extends HttpServlet {

    Connection con;
    PreparedStatement pdstmt;
        
    private double dbhr, dbhr2, dbhr3, hrday1, hrday2, hrday3;
    private int numofSections, icutofftimeF, icutofftimeT, hrSpan, totalStudUnits, totalLecUnits, iyearLevel, timeArrF, timeArrT, nday, iday, pday1, pday2, pday3;
    private String[] strDays;
    private int secRemains;
    private List <String[][]> arrRoomList = new ArrayList <>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String strStudRooms = request.getParameter("numStudRoom");
            String strLecRooms = request.getParameter("numLecRoom");
            String strHybrdRooms = request.getParameter("numHybrdRoom");
            String strCompRooms = request.getParameter("numCompRoom");
            int iStudRooms = Integer.parseInt(strStudRooms);
            int iLecRooms = Integer.parseInt(strLecRooms);
            int iHybrdRooms = Integer.parseInt(strHybrdRooms);
            int iCompRooms = Integer.parseInt(strCompRooms);
            String [][] plotSched = new String[27][5];
            
            HttpSession ssn = request.getSession(false);
            if(ssn == null)
            {
                request.getSession();
                //declare new array
            }
            //String [][] plottedSched = (String[][])ssn.getAttribute("plotSchedArray");
            List currList = (ArrayList) ssn.getAttribute("curriculumList");
            int iNumCourse = (Integer) ssn.getAttribute("numCourse");
            String yearID =  (String) ssn.getAttribute("yrID");
            DBConnectionManager dbcnnct = new DBConnectionManager();
            con = dbcnnct.getConnection();
            String query = "SELECT Year_Level, Cutoff_time_from, Cutoff_time_to, No_of_Sections FROM YearLevel WHERE YearID=?";
            pdstmt = con.prepareStatement(query);
            pdstmt.setString(1, yearID);
            ResultSet rs = pdstmt.executeQuery();
            while(rs.next())
            {
                iyearLevel = rs.getInt("Year_Level");
                icutofftimeF = rs.getInt("Cutoff_time_from");
                icutofftimeT = rs.getInt("Cutoff_time_to");
                numofSections = rs.getInt("No_of_Sections");
            }
            hrSpan = icutofftimeT - icutofftimeF;
            timeArrF = (icutofftimeF - 7) * 2;
            timeArrT = ((icutofftimeT - 6) * 2) + 1;
            Iterator it = currList.iterator();
            while(it.hasNext())
            {
                Curriculum clum = (Curriculum)it.next();
                CurriculumList cList = new CurriculumList();               
                totalStudUnits = cList.totalStudUnits(currList);
                totalLecUnits = cList.totalLecUnits(currList);
                String courseName = clum.getCourseName();
                String pairDay = clum.getPairingDays();                    
                nday = clum.getNumDays();
                
                HashMapPlotting map = new HashMapPlotting();
                HashMap hmap = map.HashMapPlotting(iStudRooms, iLecRooms, iHybrdRooms, iCompRooms);
                Iterator itrt = hmap.entrySet().iterator();
                while(itrt.hasNext())
                {
                    Map.Entry <String, String[][]> mape = (Map.Entry)itrt.next();
                    String roomNo = mape.getKey();
                    String [][] room = mape.getValue();
                    if((pairDay.length() == 1) || (pairDay.length() == 2))
                    {
                        if(pairDay.equals("M"))
                            iday = 0;
                        else if(pairDay.equals("T"))
                            iday = 1;
                        else if(pairDay.equals("W"))
                            iday = 2;
                        else if(pairDay.equals("Th"))
                            iday = 3;
                        else if(pairDay.equals("F"))
                            iday = 4;
                        else if(pairDay.equals("S"))
                            iday = 5;      
                    }
                    else
                    {
                        strDays = pairDay.split("-");
                        if(strDays[0].equals("M"))
                            pday1 = 0;
                        else if(strDays[0].equals("T"))
                            pday1 = 1;
                        else if(strDays[0].equals("W"))
                            pday1 = 2;
                        else if(strDays[0].equals("Th"))
                            pday1 = 3;
                        else if(strDays[0].equals("F"))
                            pday1 = 4;
                        else if(strDays[0].equals("S"))
                            pday1 = 5;
                        else if(strDays[1].equals("M"))
                            pday2 = 0;
                        else if(strDays[1].equals("T"))
                            pday2 = 1;
                        else if(strDays[1].equals("W"))
                            pday2 = 2;
                        else if(strDays[1].equals("Th"))
                            pday2 = 3;
                        else if(strDays[1].equals("F"))
                            pday2 = 4;
                        else if(strDays[1].equals("S"))
                            pday2 = 5;
                        else if(strDays[2].equals("M"))
                            pday3 = 0;
                        else if(strDays[2].equals("T"))
                            pday3 = 1;
                        else if(strDays[2].equals("W"))
                            pday3 = 2;
                        else if(strDays[2].equals("Th"))
                            pday3 = 3;
                        else if(strDays[2].equals("F"))
                            pday3 = 4;
                        else if(strDays[2].equals("S"))
                            pday3 = 5;
                    }    

                    if(nday == 1)
                    {
                        hrday1 = clum.getDay1();
                        for(int i=0;i<numofSections;i++)
                        {
                            dbhr = hrday1/0.5;
                            int ttlhrc = (int) dbhr;
                            int counter = 1;

                            for(int j=timeArrF;j<=timeArrT;j++)
                            {                               
                                if((room[timeArrT][iday] == null))
                                {
                                    for(int k=0;k<ttlhrc;k++)
                                    {
                                        if((room[j][iday] == null))
                                        {
                                            room[j][iday] =  iyearLevel + "A" + counter + courseName;
                                            currList.remove(clum); // remove the curriculum if successfully assigned in a room
                                            counter++;
                                        }                                        
                                    }
                                }
                                else 
                                {                                            
                                    System.out.println("The Cutofftime Range specified is fully scheduled");
                                    secRemains = i; // getting the sections remaining
                                    break;
                                    //Error Message and Notify the user how to solve it
                                }
                            }                           
                        }
                        arrRoomList.add(room); // add array to list of room that has been used
                    }
                    else if(nday == 2)
                    {
                        hrday1 = clum.getDay1();
                        hrday2 = clum.getDay2();
                        for(int i=0;i<numofSections;i++)
                        {  
                            dbhr = hrday1/0.5;
                            dbhr2 = hrday2/0.5;
                            int ttlhrc = (int) dbhr;
                            int ttlhrc2 = (int) dbhr2;
                            int counter = 1;

                            for(int j=timeArrF;j<=timeArrT;j++)
                            {                               
                                if(room[j][pday1] == null)
                                {
                                    for(int k=0;k<ttlhrc;k++)
                                    {
                                        if((room[timeArrT][pday1] != null) && (k<ttlhrc))
                                        {
                                            System.out.println("This day is fully scheduled");
                                        }
                                        else
                                        {
                                            room[j][pday1] =  iyearLevel + "A" + counter + courseName;
                                            currList.remove(clum); // remove the curriculum if successfully assigned in a room
                                            counter++;
                                            break;
                                        }
                                    }
                                }        
                            }
                            for(int j=timeArrF;j<=timeArrT;j++)
                            {                               
                                if(room[j][pday2] == null)
                                {
                                    for(int k=0;k<ttlhrc2;k++)
                                    {
                                        if((room[timeArrT][pday2] != null) && (k<ttlhrc))
                                        {
                                            System.out.println("Monday of this day is fully scheduled");
                                        }
                                        else
                                        {
                                            room[j][pday2] =  iyearLevel + "A" + counter + courseName;
                                            currList.remove(clum); // remove the curriculum if successfully assigned in a room
                                            counter++;
                                            break;
                                        }
                                    }
                                }        
                            }
                        }
                    }
                    else if(nday == 3)
                    {
                        hrday1 = clum.getDay1();
                        hrday2 = clum.getDay2();
                        hrday3 = clum.getDay3();
                        dbhr = hrday1/0.5;
                        dbhr2 = hrday2/0.5;
                        dbhr3 = hrday3/0.5;
                    }
                }
            }
            //Logic and formula for assigning the rooms
            /*                         
                c 15 hours available each day
                c get number of sections
                c get total hours
                c get the day the room will be used
                c get Cutofftime
                  get room requirements
                  get the available room
                  
                  get and check semester and school year
                  if(semester and school year is still the same)
                    use the array rooms passed from the session
                  else
                    use the array that is blank (new)
            
                update database
            */
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
