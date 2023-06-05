package com.iiht.training.incometax.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.iiht.training.incometax.exception.InvalidPANException;
import com.iiht.training.incometax.exception.PANDetailsNotProvidedException;
import com.iiht.training.incometax.exception.PANDoesNotExistsException;
import com.iiht.training.incometax.model.Deductions;
import com.iiht.training.incometax.model.Employee;
import com.iiht.training.incometax.model.TaxDetails;

public class TaxCalculator {

	public List<Employee> employees = new ArrayList<>();
	public List<Deductions> deductions = new ArrayList<>();
	public List<TaxDetails> taxDetails = new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	private void addDeductionsForAnEmployee(String pan) {
		Deductions d=new Deductions();
		d.setPAN(pan);
		d.setPf(Double.parseDouble(sc.nextLine()));
		d.setSec80c(Double.parseDouble(sc.nextLine()));
		d.setHouseRent(Double.parseDouble(sc.nextLine()));
		deductions.add(d);
	}

	public boolean addEmployee(Employee e) {
		
		e.setId(Long.parseLong(sc.nextLine()));
		e.setName(sc.nextLine());
		String pan=sc.nextLine();
		boolean b;
		if(pan.length()==0) {
			throw new PANDetailsNotProvidedException("PAN Details not provided");
		}
		else if(b=Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]").matcher("as").matches()) {
			e.setPAN(pan);
		}
		else {
			throw new InvalidPANException("PAN is not in VALID format"); 
		}
		e.setAge(Integer.parseInt(sc.nextLine()));
		e.setEmail(sc.nextLine());
		e.setBasicSalary(Double.parseDouble(sc.nextLine()));
		e.setGrossSalary(Double.parseDouble(sc.nextLine()));
		addDeductionsForAnEmployee(e.getPAN());
		return true;
	}

	public Double getTotalDeductions(String PAN, double sec80c, double houseRent) {
		// total deductions = pf + sec80c + houseRent
		// pf = basic_salary * 12%
			Employee e=getEmployee(PAN);
			if(e==null) {
				return 0.0;
			}
			return e.getBasicSalary()*(12.0/100)+sec80c+houseRent;

	}

	public Double showTaxableSalary(String PAN) {
		// Taxable salary = gross salary - total deductions
		Employee e=getEmployee(PAN);
		Deductions d=getDeductionForEmployee(PAN);
		if(d==null) {
			return 0.0;
		}
		return e.getGrossSalary()-getTotalDeductions(PAN, d.getSec80c(), d.getHouseRent());
	}

	public double calculateTotalTax(String PAN) {
		// calculate total tax and add to TaxDetails List
		double d=showTaxableSalary(PAN);
		TaxDetails t=null;
		if(d>=0 && d<=250000) {
			t.setTotalTax( 0.0);
		}
		else if(d>250000 && d<=500000) {
			t.setTotalTax(  d*(5.0/100));
		}
		else if(d>500000 && d<=750000) {
			t.setTotalTax(  12500+(10.0/100)*(d-500000));
		}
		else if(d>750000 && d<=1000000) {
			t.setTotalTax(  37500+(15.0/100)*(d-750000));
		}
		else if(d>1000000 && d<=1250000) {
			t.setTotalTax(  75000+(20.0/100)*(d-1000000));
		}
		else if(d>1250000 && d<=1500000) {
			t.setTotalTax(  125000+(25.0/100)*(d-1250000));
		}
		else {
			t.setTotalTax(  187500+(30.0/100)*(d-1500000));
		}
		Employee e=getEmployee(PAN);
		Deductions ded=getDeductionForEmployee(PAN);
		t.setGrossSalary(e.getGrossSalary());
		t.setId(e.getId());
		t.setPAN(PAN);
		t.setNetSalary(e.getGrossSalary()-getTotalDeductions(PAN, ded.getSec80c(), ded.getHouseRent())-t.getTotalTax());
		taxDetails.add(t);
		return t.getTotalTax();
	}

	public List<TaxDetails> getTaxDetails() {
		return taxDetails;
	}

	private Deductions getDeductionForEmployee(String PAN) {
		for (Deductions deduction : deductions) {
			if (deduction.getPAN().equalsIgnoreCase(PAN)) {
				return deduction;
			}
		}
		return null;
	}
	
	

	private Employee getEmployee(String PAN) {
		for (Employee emp : employees) {
			if (emp.getPAN().equalsIgnoreCase(PAN)) {
				return emp;
			}
		}
		throw new PANDoesNotExistsException("PAN Does not Exists");
	}

	private boolean panExists(String pan) {
		for (Employee emp : employees) {
			if (emp.getPAN().equalsIgnoreCase(pan)) {
				return true;
			}
		}
		return false;
	}

}
