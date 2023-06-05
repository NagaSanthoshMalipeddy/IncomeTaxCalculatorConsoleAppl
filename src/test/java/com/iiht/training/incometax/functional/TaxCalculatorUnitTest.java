package com.iiht.training.incometax.functional;

import static com.iiht.training.incometax.testutils.TestUtils.businessTestFile;
import static com.iiht.training.incometax.testutils.TestUtils.currentTest;
import static com.iiht.training.incometax.testutils.TestUtils.testReport;
import static com.iiht.training.incometax.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.incometax.calculator.TaxCalculator;
import com.iiht.training.incometax.model.Deductions;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.model.TaxDetails;
import com.iiht.training.incometax.testutils.MasterData;

class TaxCalculatorUnitTest {

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
	public void testSaveEmployee() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		employee.setPAN("ALBRK3412S");
		yakshaAssert(currentTest(), calculator.addEmployee(employee) ? true : false, businessTestFile);
	}

	@Test
	public void testGetTotalDeductions() throws IOException {
		Deductions deductions = MasterData.getDeductionsData();
		double totalDeductions = deductions.getPf() + deductions.getSec80c() + deductions.getHouseRent();
		yakshaAssert(currentTest(),
				calculator.getTotalDeductions(deductions.getPAN(), deductions.getSec80c(), deductions.getHouseRent())
						.equals(totalDeductions) ? true : false,
				businessTestFile);
	}

	@Test
	public void testShowTaxableSalary() throws IOException {
		Employee employee = calculator.employees.get(0);
		Deductions deduction = calculator.deductions.get(0);
		double taxableSalary = employee.getGrossSalary()
				- calculator.getTotalDeductions(employee.getPAN(), deduction.getSec80c(), deduction.getHouseRent());

		yakshaAssert(currentTest(),
				calculator.showTaxableSalary(deduction.getPAN()).equals(taxableSalary) ? true : false,
				businessTestFile);
	}

	@Test
	public void testCalculateTotalTax() throws IOException {
		Employee employee = MasterData.getEmployeeData();
		double expectedTax = MasterData.getTaxDetaisData().getTotalTax();
		yakshaAssert(currentTest(), calculator.calculateTotalTax(employee.getPAN()) == expectedTax ? true : false,
				businessTestFile);
	}

	@Test
	public void testGetTaxDetails() throws IOException {
		List<TaxDetails> taxDetails = calculator.taxDetails;
		yakshaAssert(currentTest(), calculator.getTaxDetails().size() == taxDetails.size() ? true : false,
				businessTestFile);
	}
}
