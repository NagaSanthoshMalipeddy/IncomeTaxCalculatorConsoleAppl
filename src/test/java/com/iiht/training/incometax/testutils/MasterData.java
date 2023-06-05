package com.iiht.training.incometax.testutils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.incometax.model.Deductions;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.model.TaxDetails;

public class MasterData {

	public static Employee getEmployeeData() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Peter");
		employee.setEmail("peter@gmail.com");
		employee.setPAN("BLHPT1010K");
		employee.setAge(23);
		employee.setBasicSalary(300000.00);
		employee.setGrossSalary(750000.00);
		return employee;

	}

	public static List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Peter");
		employee.setEmail("peter@gmail.com");
		employee.setPAN("BLHPT1010K");
		employee.setAge(23);
		employee.setBasicSalary(300000.00);
		employee.setGrossSalary(750000.00);
		employees.add(employee);
		employee = new Employee();
		employee.setId(2L);
		employee.setName("Jason");
		employee.setEmail("jason@gmail.com");
		employee.setPAN("PAHBC1214S");
		employee.setAge(35);
		employee.setBasicSalary(720000.00);
		employee.setGrossSalary(1800000.00);
		employees.add(employee);
		return employees;
	}

	public static Deductions getDeductionsData() {

		Deductions deduction = new Deductions();
		deduction.setPAN("BLHPT1010K");
		deduction.setPf(300000 * .12);
		deduction.setSec80c(130000.00);
		deduction.setHouseRent(40000.00);
		return deduction;
	}

	public static List<Deductions> getDeductionsList() {
		List<Deductions> deductions = new ArrayList<>();
		Deductions deduction = new Deductions();
		deduction.setPAN("BLHPT1010K");
		deduction.setPf(720000 * .12);
		deduction.setSec80c(130000.00);
		deduction.setHouseRent(40000.00);
		deductions.add(deduction);
		deduction = new Deductions();
		deduction.setPAN("PAHBC1214S");
		deduction.setPf(720000 * .12);
		deduction.setSec80c(150000.00);
		deduction.setHouseRent(50000.00);
		deductions.add(deduction);
		return deductions;

	}

	public static TaxDetails getTaxDetaisData() {
		TaxDetails details = new TaxDetails();
		details.setId(1L);
		details.setPAN("BLHPT1010K");
		details.setGrossSalary(750000.0);
		details.setNetSalary(714000.0);
		details.setTotalTax(16900.0);
		return details;
	}

	public static List<TaxDetails> getTaxDetailsList() {
		List<TaxDetails> taxDetails = new ArrayList<>();
		TaxDetails details = new TaxDetails();
		details.setId(1L);
		details.setPAN("BLHPT1010K");
		details.setGrossSalary(750000.0);
		details.setNetSalary(714000.0);
		details.setTotalTax(16900.0);
		taxDetails.add(details);
		details = new TaxDetails();
		details.setId(1L);
		details.setPAN("BLHPT1010K");
		details.setGrossSalary(1800000.0);
		details.setNetSalary(1713600.0);
		details.setTotalTax(266580.0);
		taxDetails.add(details);
		return taxDetails;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
