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

        emp1 = getEmployee();
        emp2 = getEmployee();
    }

    // ****************** ANONYMOUS SUBCLASS ************       ( CREATING A NEW SUBCLASS OF EMPLOYEE ) NOT INSTANTIATING A NEW EMPLOYEE
    private Employee getEmployee() {
        return new Employee("Mike", Date.valueOf("2001-05-05")) {
            public double pay() {
                return 0;
            }

            public double payTaxes() {
                return 0;
            }
        };
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

    // MEMBER LEVEL NAMED INNER CLASSES

    private class DummyEmployee extends Employee {


        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }


}