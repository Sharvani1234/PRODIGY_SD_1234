package com.prodigyinfotech;

import java.util.Scanner;

public class TemperatureConverter{
	public static double celsiusToFahrenheit(double celsius) {
		return (celsius*9/5)+32;
	}
	
	public static double celsiusToKelvin(double celsius) {
		return celsius+273.15;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit-32)*5/9;
	}
	
	public static double fahrenheitToKelvin(double fahrenheit) {
		return (fahrenheit-32)*5/9+273.15;
	}
	
	public static double KelvinToCelsius(double kelvin) {
		return kelvin-273.15;
	}
	
	public static double KelvinToFahrenheit(double kelvin) {
		return (kelvin-273.15)*9/5+32;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Enter the temperature value:");
		double temperature=scanner.nextDouble();
		
		System.out.print("Enter the original unit of measurement(Celsius,Fahrenheit,or Kelvin):");
		String originalUnit=scanner.next().toLowerCase();
		
		switch(originalUnit) {
		case"celsius":
			double fahrenheit=celsiusToFahrenheit(temperature);
			double kelvin=celsiusToKelvin(temperature);
			System.out.printf("%.2f degrees Celsius is equal to %.2f degrees Fahrenheit and %.2f Kelvin.",temperature,fahrenheit,kelvin);
			break;
		case"fahrenheit":
			double celsius=fahrenheitToCelsius(temperature);
			kelvin=fahrenheitToKelvin(temperature);
			System.out.printf("%.2f degrees Fahrenheit is eaual to %.2f degrees Celsius and %.2f Kelvin.",temperature,celsius,kelvin);
			break;
		case"kelvin":
			celsius=KelvinToCelsius(temperature);
			double fahrenheit1=KelvinToFahrenheit(temperature);
			System.out.printf("%.2f kelvin is equal to %.2f degrees Celsius and %.2f Fahrenheit.",temperature,celsius,fahrenheit1);
			break;
			default:
				System.out.println("Invalid input!Please enter Celsius,Fahrenheit,or Kelvin.");
		}
		
		scanner.close();
	}
}