package com.iiht.training.incometax.model;

import java.util.Objects;

public class Deductions {

	private String PAN;
	private double pf;
	private double sec80c;
	private double houseRent;
	public Deductions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deductions(String pAN, double pf, double sec80c, double houseRent) {
		super();
		PAN = pAN;
		this.pf = pf;
		this.sec80c = sec80c;
		this.houseRent = houseRent;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getSec80c() {
		return sec80c;
	}
	public void setSec80c(double sec80c) {
		this.sec80c = sec80c;
	}
	public double getHouseRent() {
		return houseRent;
	}
	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}
	@Override
	public int hashCode() {
		return Objects.hash(PAN, houseRent, pf, sec80c);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deductions other = (Deductions) obj;
		return Objects.equals(PAN, other.PAN)
				&& Double.doubleToLongBits(houseRent) == Double.doubleToLongBits(other.houseRent)
				&& Double.doubleToLongBits(pf) == Double.doubleToLongBits(other.pf)
				&& Double.doubleToLongBits(sec80c) == Double.doubleToLongBits(other.sec80c);
	}
	@Override
	public String toString() {
		return String.format("Deductions [PAN=%s, pf=%s, sec80c=%s, houseRent=%s]", PAN, pf, sec80c, houseRent);
	}
	
	
	
}
