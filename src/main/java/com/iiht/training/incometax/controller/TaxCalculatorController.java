package com.iiht.training.incometax.controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.iiht.training.incometax.calculator.TaxCalculator;
import com.iiht.training.incometax.exception.InvalidPANException;
import com.iiht.training.incometax.model.Employee;
public class TaxCalculatorController {

	public static void main(String[] args) {
		TaxCalculator calculator = new TaxCalculator();
		Scanner sc=new Scanner(System.in);
		int k=0;
		while(true) {
			try {
				System.out.println("Enter number of employee details to be collected(n) : ");
				String n=sc.nextLine();
				k=Integer.parseInt(n);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}
		}
		for(int i=0;i<k;i++) {
			Employee e=new Employee();
			System.out.print("Enter id of employee - "+(i+1)+": ");
			calculator.addEmployee(e);
		}
	
	}

}
