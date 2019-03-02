package com.system.model;

import java.io.Serializable;
/**
 *
 * @author CalvinGabriel
 */
public class Curriculum implements Serializable{
    private static final long serialVersionUID = 1L;
    private String strCourseCode;
    private String strCourseName;
    private int iCourseStudUnits;
    private int iCourseLecUnits;
    private int iNumDays;
    private String strPairingDays;
    private float dblDay1;
    private float dblDay2;
    private float dblDay3;
    
    public Curriculum(String strCourseCode, String strCourseName, int iCourseStudUnits, int iCourseLecUnits, int iNumDays, String strPairingDays, float dblDay1, float dblDay2, float dblDay3)
    {
        this.strCourseCode = strCourseCode;
        this.strCourseName = strCourseName;
        this.iCourseStudUnits = iCourseStudUnits;
        this.iCourseLecUnits = iCourseLecUnits;
        this.iNumDays = iNumDays;
        this.strPairingDays = strPairingDays;
        this.dblDay1 = dblDay1;
        this.dblDay2 = dblDay2;
        this.dblDay3 = dblDay3;
    }
    public String getCourseCode()
    {
        return strCourseCode;
    }
    public void setCourseCode(String strCourseCode)
    {
        this.strCourseCode = strCourseCode;
    }
    public String getCourseName()
    {
        return strCourseName;
    }
    public void setCourseName(String strCourseName)
    {
        this.strCourseName = strCourseName;
    }
    public int getStudioUnits()
    {
        return iCourseStudUnits;
    }
    public void setStudioUnits(int iCourseStudUnits)
    {
        this.iCourseStudUnits = iCourseStudUnits;
    }
    public int getLectureUnits()
    {
        return iCourseLecUnits;
    }
    public void setLectureUnits(int iCourseLecUnits)
    {
        this.iCourseLecUnits = iCourseLecUnits;
    }
    public int getNumDays()
    {
        return iNumDays;
    }
    public void setNumDays(int iNumDays)
    {
        this.iNumDays = iNumDays;
    }
    public String getPairingDays()
    {
        return strPairingDays;
    }
    public void setPairingDays(String strPairingDays)
    {
        this.strPairingDays = strPairingDays;
    }
    public float getDay1()
    {
        return dblDay1;
    }
    public void setDay1(float dblDay1)
    {
        this.dblDay1 = dblDay1;
    }
    public float getDay2()
    {
        return dblDay2;
    }
    public void setDay2(float dblDay2)
    {
        this.dblDay2 = dblDay2;
    }
    public float getDay3()
    {
        return dblDay3;
    }
    public void setDay3(float dblDay3)
    {
        this.dblDay3 = dblDay3;
    }
    @Override
    public String toString()
    {
        return "Course Code: " + getCourseCode() + "Course Name: " + getCourseName() + "Studio Units: " + getStudioUnits() + "Lecture Units:" + getLectureUnits() 
                + "Number of Days: " + getNumDays() + "Pairing Days: " + getPairingDays() + "Day1: " + getDay1() + "Day2: " + getDay2() + "Day3: " + getDay3();
    }     
}
