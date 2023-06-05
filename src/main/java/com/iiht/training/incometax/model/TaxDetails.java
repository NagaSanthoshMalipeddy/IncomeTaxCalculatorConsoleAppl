package com.iiht.training.incometax.model;

public class TaxDetails {

	private Long id;
	private String PAN;
	private double grossSalary;
	private double netSalary;
	private double totalTax;

	public TaxDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxDetails(Long id, String pAN, double grossSalary, double netSalary, double totalTax) {
		super();
		this.id = id;
		PAN = pAN;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.totalTax = totalTax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public String toString() {
		return String.format("TaxDetails [id=%s, PAN=%s, grossSalary=%s, netSalary=%s, totalTax=%s]", id, PAN,
				grossSalary, netSalary, totalTax);
	}

}
