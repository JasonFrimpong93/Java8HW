package com.NewHw.MavenJ8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MavJ8 {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private String gender;
	private String dept;
	private int yearOfJoining;
	private int salary;

	public static void main(String[] args) {
		List<MavJ8> empList = new ArrayList<MavJ8>();

		empList.add(new MavJ8(111, "Loel", 24, "Male", "CS", 2010, 123456));
		empList.add(new MavJ8(123, "Jason", 25, "Male", "BA", 2016, 55000));
		empList.add(new MavJ8(123, "Yackson", 24, "Male", "CS", 2014, 60000));
		empList.add(new MavJ8(123, "Katie", 23, "Female", "Cs", 2013, 70000));

		// collectors translates filterstream to a list

		// the e is a lambda and is filtering from MavJ8
		// e stands for one MavJ8 but we are filtering everyMavJ8
		// declare an int
		int numberMales = empList.stream().filter(e -> e.getGender().equals("Male")).collect(Collectors.toList())
				.size();
		int numberFemales = empList.stream().filter(e -> e.getGender().equals("Female")).collect(Collectors.toList())
				.size();

		System.out.println(numberMales);
		System.out.println(numberFemales);
		System.out.println("end of Question 1 ------------------------------------------");

		List<MavJ8> avgFemaleAgeTotal = empList.stream().filter(e -> e.getGender().equals("Female"))
				.collect(Collectors.toList());
		int femaleTotalAge = 0;
		for (MavJ8 e : avgFemaleAgeTotal) {
			femaleTotalAge += e.getAge();
		}
		int femaleAgeAverage = femaleTotalAge / numberFemales;
		System.out.println("Average Female Age " + femaleAgeAverage);

		List<MavJ8> avgMaleAgeTotal = empList.stream().filter(e -> e.getGender().equals("Male"))
				.collect(Collectors.toList());
		int maleTotalAge = 0;
		for (MavJ8 e : avgMaleAgeTotal) {
			maleTotalAge += e.getAge();
		}
		int maleAgeAverage = maleTotalAge / numberMales;
		System.out.println("Average male Age " + maleAgeAverage);

		System.out.println("end of Question 2 ------------------------------------------");

		Comparator<MavJ8> joining = Comparator.comparing(MavJ8::getSalary);
		MavJ8 topSalary = empList.stream().max(joining).get();

		System.out.println("Top Salary" + topSalary.getName());
		System.out.println("Salary is " + topSalary.getSalary());

		System.out.println("end of Question 3------------------------------------------");

	}

	
	public MavJ8(int id, String name, int age, String gender, String dept, int yearOfJoining, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
}
