package com.iiht.training.incometax.boundary;

import static com.iiht.training.incometax.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.incometax.testutils.TestUtils.currentTest;
import static com.iiht.training.incometax.testutils.TestUtils.testReport;
import static com.iiht.training.incometax.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.incometax.calculator.TaxCalculator;
import com.iiht.training.incometax.exception.InvalidPANException;
import com.iiht.training.incometax.exception.PANAlreadyExistsException;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.testutils.MasterData;

public class BoundaryTest {

	static TaxCalculator calculator = null;

	@BeforeAll
	public static void setUp() {
		calculator = new TaxCalculator();
		calculator.employees = MasterData.getEmployeeList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPANCardIsUnique() throws Exception {
		Employee employee = MasterData.getEmployeeData();
		try {
			calculator.addEmployee(employee);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (PANAlreadyExistsException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}

	@Test
	public void testPANNumberShouldBeTenCharacters() throws Exception {
		Employee employee = MasterData.getEmployeeData();
		employee.setPAN("ABNPK123A");
		try {
			calculator.addEmployee(employee);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (InvalidPANException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}


}
