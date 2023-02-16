package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Program {
	
	public static void main(String[]args) {
		
		List<Person> list = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=0; i<n ; i++) {
			System.out.println("Tax payer #"+(i+1)+" data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new PhysicalPerson(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int working = sc.nextInt();
				list.add(new CompanyPerson(name, anualIncome, working));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(Person p: list) {
			System.out.println(p.getName()+": $ " + String.format("%.2f", p.tax()));
		}
		
		System.out.println();
		double sum = 0.0;
		for(Person p : list) {
			sum += p.tax();
		}
		
		System.out.printf("TOTAL TAXES: $ %.2f",sum);
		
		sc.close();
	}

}
