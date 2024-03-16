package com.prodigyinfotech;

import java.util.ArrayList;
import java.util.Scanner;

class Contact{
	private String name;
	private String phoneNumber;
	private String email;
	
	public Contact(String name,String phoneNumber,String email) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "Name:"+name+",PhoneNumber:"+phoneNumber+",Email:"+email;
	}
}

class ContactManager{
	private ArrayList<Contact>contacts;
	
	public ContactManager() {
		contacts=new ArrayList<>();
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
		System.out.println("Contact added successfully!");
	}
	
	public void displayContacts() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts to display.");
		}
		else {
			System.out.println("Contact List:");
			for(Contact contact:contacts) {
				System.out.println(contact);
			}
		}
	}
	
	public void editContact(String name,String phoneNumber,String email) {
		for(Contact contact:contacts) {
			if(contact.getName().equals(name)) {
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				System.out.println("Contact updated successfulle!");
				return;
			}
		}
		System.out.println("Contact not found.");
	}
	
	public void deleteContact(String name) {
		for(int i=0;i<contacts.size();i++) {
			if(contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
				System.out.println("Contact deleted successfully!");
				return;
			}
		}
		System.out.println("Contact not found.");
	}
}

public class ContactManagementSystem{
	public static void main(String[] args) {
		ContactManager contactManager=new ContactManager();
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.println("\nContact Management System");
			System.out.println("1.Add Contact");
			System.out.println("2.Display Contacts");
			System.out.println("3.Edit Contact");
			System.out.println("4.Delete Contact");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			int choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Enter name:");
				String name=scanner.nextLine();
				System.out.print("Enter phone number:");
				String phoneNumber=scanner.nextLine();
				System.out.print("Enter email:");
				String email=scanner.nextLine();
				contactManager.addContact(new Contact(name,phoneNumber,email));
				break;
			case 2:
				contactManager.displayContacts();
				break;
			case 3:
				System.out.print("Enter name of the contact to edit:");
				String editName=scanner.nextLine();
				System.out.print("Enter new phone number:");
				String newPhoneNumber=scanner.nextLine();
				System.out.print("Enter new email:");
				String newEmail=scanner.nextLine();
				contactManager.editContact(editName, newPhoneNumber, newEmail);
				break;
			case 4:
				System.out.print("Enter name of the contact to delete:");
				String deleteName=scanner.nextLine();
				contactManager.deleteContact(deleteName);
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
				break;
				default:
					System.out.println("Invalid choice.Please enter a number between 1 and 5.");
			}
		}
	}
}