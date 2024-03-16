package com.prodigyinfotech;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		int secretNumber=random.nextInt(100)+1;
		int attempts=0;
		int guess=0;
		
		System.out.println("Welcome to the Guessing Game!");
		
		while(guess!=secretNumber) {
			System.out.print("Enter your guess(between 1 and 100):");
			guess=scanner.nextInt();
			attempts++;
			
			if(guess<secretNumber) {
				System.out.println("Too low!Try again.");
			}
			else if(guess>secretNumber) {
				System.out.println("Too high!Try again.");
			}
		}
		
		System.out.println("Congratulations!You guessed the number "+secretNumber+" correctly!");
		System.out.println("It took you "+attempts+" attempts.");
		scanner.close();
	}
}