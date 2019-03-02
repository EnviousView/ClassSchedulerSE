package com.system.model;

import java.util.*;
import java.sql.*;
/**
 *
 * @author CalvinGabriel
 */
public class HashMapPlotting {
    private Connection con = null;
    private PreparedStatement pdstmt = null;
    private ResultSet rs = null;
    private HashMap<String, RoomModel> hmap = new HashMap<String, RoomModel>();
    private String roomAvlbl, roomToBeUsed, roomTypeAvlbl;
    private String[][] room = new String[28][6];
    public HashMap HashMapPlotting(int nStudRoom, int nLecRoom, int nHybridRoom, int nCompRoom) throws ClassNotFoundException, SQLException
    {
        try
        {
            DBConnectionManager dbcon = new DBConnectionManager();
            con = dbcon.getConnection();
            String roomStud = "Studio Room";
            String roomLec = "Lecture Room";
            String roomHybrd = "Hybrid Room";
            String roomComp = "Computer Room";
            String queryRoom = "SELECT Room_No FROM Room WHERE Room_Type = ? AND Status = A;";

            if(nStudRoom > 0)
            {
                pdstmt = con.prepareStatement(queryRoom);
                pdstmt.setString(1, roomStud);
                rs = pdstmt.executeQuery();
                while(rs.next())
                {
                   roomAvlbl = rs.getString("Room_No");
                   roomTypeAvlbl = rs.getString("Room_Type");
                   hmap.put(roomAvlbl, new RoomModel(roomAvlbl, roomTypeAvlbl, room));
                }    
            }
            if(nLecRoom > 0)
            {
                pdstmt = con.prepareStatement(queryRoom);
                pdstmt.setString(1, roomLec);
                rs = pdstmt.executeQuery();
                while(rs.next())
                {
                   roomAvlbl = rs.getString("Room_No");
                   roomTypeAvlbl = rs.getString("Room_Type");
                   hmap.put(roomAvlbl, new RoomModel(roomAvlbl, roomTypeAvlbl, room));
                }    
            }
            if(nHybridRoom > 0)
            {
                pdstmt = con.prepareStatement(queryRoom);
                pdstmt.setString(1, roomHybrd);
                rs = pdstmt.executeQuery();
                while(rs.next())
                {
                   roomAvlbl = rs.getString("Room_No");
                   roomTypeAvlbl = rs.getString("Room_Type");
                   hmap.put(roomAvlbl, new RoomModel(roomAvlbl, roomTypeAvlbl, room));
                }    
            }
            if(nCompRoom > 0)
            {
                pdstmt = con.prepareStatement(queryRoom);
                pdstmt.setString(1, roomComp);
                rs = pdstmt.executeQuery();
                while(rs.next())
                {
                   roomAvlbl = rs.getString("Room_No");
                   roomTypeAvlbl = rs.getString("Room_Type");
                   hmap.put(roomAvlbl, new RoomModel(roomAvlbl, roomTypeAvlbl, room));
                }    
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
            if(pdstmt != null)
            {
                try
                {
                    System.out.println("PREPARED STATEMENT IS CLOSED");
                    pdstmt.close();
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
        return (hmap);
    }
}
