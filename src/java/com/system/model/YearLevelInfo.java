package com.system.model;

/**
 *
 * @author CalvinGabriel
 */
public class YearLevelInfo {
    
    private int yearLevel;
    private int cutoffTimeFrom;
    private int cutoffTimeTo;
    private int numOfSection;
    private int sem;
    private int syFrom;
    private int syTo;
    private int numOfCourse;
         
    public YearLevelInfo(int yearLevel, int cutoffTimeFrom, int cutoffTimeTo, int numOfSection, int sem, int syFrom, int syTo, int numOfCourse)
    {
        this.yearLevel = yearLevel;
        this.cutoffTimeFrom = cutoffTimeFrom;
        this.cutoffTimeTo = cutoffTimeTo;
        this.numOfSection = numOfSection;
        this.sem = sem;
        this.syFrom = syFrom;
        this.syTo = syTo;
        this.numOfCourse = numOfCourse;
    }
    public int getYearLevel()
    {
        return yearLevel;
    }
    public void setYearLevel(int yearLevel)
    {
        this.yearLevel = yearLevel;
    }
    public int getCutoffTimeF()
    {
        return cutoffTimeFrom;
    }
    public void setCutoffTimeF(int cutoffTimeFrom)
    {
        this.cutoffTimeFrom = cutoffTimeFrom;
    }
    public int getCutoffTimeT()
    {
        return cutoffTimeTo;
    }
    public void setCutoffTimeT(int cutoffTimeTo)
    {
        this.cutoffTimeTo = cutoffTimeTo;
    }
    public int getNumofSec()
    {
        return numOfSection;
    }
    public void setNumofSec(int numOfSection)
    {
        this.numOfSection = numOfSection;
    }
    public int getSem()
    {
        return sem;
    }
    public void setSem(int sem)
    {
        this.sem = sem;
    }
    public int getSYF()
    {
        return syFrom;
    }
    public void setSYF(int syFrom)
    {
        this.syFrom = syFrom;
    }
    public int getSYT()
    {
        return syTo;
    }
    public void setSYT(int syTo)
    {
        this.syTo = syTo;
    }
    public int getNumofCourse()
    {
        return numOfCourse;
    }
    public void setNumofCourse(int numOfCourse)
    {
        this.numOfCourse = numOfCourse;
    }
    public String generateYearID(String yearLevel, String sem, String syFrom, String syTo)
    {        
        String yearID = yearLevel + "-" + sem + "-" + syFrom + "-" + syTo;
        
        return yearID;
    }        
}
