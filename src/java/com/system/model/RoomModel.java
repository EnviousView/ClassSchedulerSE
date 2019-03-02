package com.system.model;

import java.io.Serializable;

/**
 *
 * @author CalvinGabriel
 */
public class RoomModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private String roomNo, roomType;    
    private String[][] room;
    public RoomModel(String roomNo, String roomType, String [][] room)
    {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }
    
    public String getRoomNo()
    {
        return roomNo;
    }
    public void setRoomNo(String roomNo)
    {
        this.roomNo = roomNo;
    }
    public String getRoomType()
    {
        return roomType;
    }
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }
    public String[][] getRoom()
    {
        return room;
    }        
}
