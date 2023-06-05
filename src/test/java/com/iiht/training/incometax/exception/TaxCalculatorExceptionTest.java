package com.iiht.training.incometax.exception;

import static com.iiht.training.incometax.testutils.TestUtils.currentTest;
import static com.iiht.training.incometax.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.incometax.testutils.TestUtils.testReport;
import static com.iiht.training.incometax.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.incometax.calculator.TaxCalculator;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.testutils.MasterData;

class TaxCalculatorExceptionTest {

	static TaxCalculator calculator = null;

	@BeforeAll
	public static void setUp() {
		calculator = new TaxCalculator();
		calculator.employees = MasterData.getEmployeeList();
		calculator.deductions = MasterData.getDeductionsList();
		calculator.taxDetails = MasterData.getTaxDetailsList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPANCardAlreadyExistsException() throws IOException {
		Employee employee = calculator.employees.get(0);
		String result ="";
		employee.setPAN("BLHPT1010K");
		try{
			calculator.addEmployee(employee);
		}catch(PANAlreadyExistsException ex){
           result = ex.getMessage();
		}
		String message = "PAN Details Already Exists";
		yakshaAssert(currentTest(), message.contentEquals(result) ? true : false, exceptionTestFile);

	}

	@Test
	public void testPANDoesNotExistsException() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		employee.setPAN("BLBAK2312C");
		String result = "";
		try{
			calculator.showTaxableSalary(employee.getPAN());
		}catch(PANDoesNotExistsException ex){
           result = ex.getMessage();
		}
		String message = "PAN Does not Exists";
		yakshaAssert(currentTest(), message.contentEquals(result) ? true : false, exceptionTestFile);

	}

	@Test
	public void testPANDetailsNotProvidedException() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		String result = "";
		employee.setPAN("");
		try{
			calculator.addEmployee(employee);
		}catch(PANDoesNotExistsException ex){
           result = ex.getMessage();
		}
		String message = "PAN Details are not provided";
		yakshaAssert(currentTest(), message.contentEquals(result) ? true : false, exceptionTestFile);

	}
}
