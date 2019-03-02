package com.system.model;

import java.util.*;
import java.io.Serializable;
/**
 *
 * @author CalvinGabriel
 */
public class CurriculumList implements Serializable{

    private static final long serialVersionUID = 1L;

    public List addCurriculum(String strCourseCode, String strCourseName, int iCourseStudUnits, int iCourseLecUnits, int iNumDays, String strPairingDays, float dblDay1, float dblDay2, float dblDay3)
    {
        List <Curriculum> curriculumList = new ArrayList <>();
        
        curriculumList.add(new Curriculum(strCourseCode, strCourseName, iCourseStudUnits, iCourseLecUnits, iNumDays, strPairingDays, dblDay1, dblDay2, dblDay3));
        
        return (curriculumList);
    }
    public int totalStudUnits(List currList)
    {
        int iStudUnitsTotal = 0;
        Iterator it = currList.iterator();
        while(it.hasNext())
        {
            Curriculum curr = (Curriculum)it.next();
            iStudUnitsTotal += curr.getStudioUnits();
        }
        return(iStudUnitsTotal);
    }
    public int totalLecUnits(List currList)
    {
        int iLecUnitsTotal = 0;
        Iterator it = currList.iterator();
        while(it.hasNext())
        {
            Curriculum curr = (Curriculum)it.next();
            iLecUnitsTotal += curr.getLectureUnits();
        }
        return(iLecUnitsTotal);
    }
}
