package com.iiht.training.incometax.model;

import java.util.Objects;

public class Employee {

	private Long id;
	private String name;
	private String PAN;
	private int age;
	private String email;
	private double basicSalary;
	private double grossSalary;

	public Employee() {
	}

	public Employee(Long id, String name, String pAN, int age, String email, double basicSalary, double grossSalary) {
		super();
		this.id = id;
		this.name = name;
		PAN = pAN;
		this.age = age;
		this.email = email;
		this.basicSalary = basicSalary;
		this.grossSalary = grossSalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PAN, age, basicSalary, email, grossSalary, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(PAN, other.PAN) && age == other.age
				&& Double.doubleToLongBits(basicSalary) == Double.doubleToLongBits(other.basicSalary)
				&& Objects.equals(email, other.email)
				&& Double.doubleToLongBits(grossSalary) == Double.doubleToLongBits(other.grossSalary)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, PAN=%s, age=%s, email=%s, basicSalary=%s, grossSalary=%s]", id,
				name, PAN, age, email, basicSalary, grossSalary);
	}
	
	

}
