package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    // business object(s) under test
    private Employee emp1;
    private Employee emp2;


    @Before
    public void setUp(){
        emp1 = new SalariedEmployee("Mike", Date.valueOf("2001-05-05"));
        emp2 = new SalariedEmployee("Mike", Date.valueOf("2001-05-05"));
    }

    @Test
    public void equals_shouldReturnsFalse_differentName_sameHireDAte() {
        emp2.setName("annie");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2001-10-10"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);       // does an equals() check for objects
    }
}