package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee emp;       // declaring an object under test of salariedemployee (fixture)
    private SalariedEmployee emp2;

    @Before
    public void setUp(){
        emp = new SalariedEmployee("Exxon", Date.valueOf("2020-10-10"), 1500.0);
        emp2 = new SalariedEmployee("Exxon", Date.valueOf("2020-10-10"), 1500.0);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameSalary_sameHireDate() {
        emp2.setName("Mike");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2015-10-10"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp.setSalary(3000.0);
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp,emp2);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, emp.payTaxes(), .001 );
    }
}