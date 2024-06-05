package com.tka.libraryManagement;

import java.util.Scanner;

public class productInfo {
	Scanner scanner = new Scanner(System.in);

	public int productId;
	public String productName;

	public void acceptDetails() {
		System.out.println("Enter product id:");
		this.productId = scanner.nextInt();

		System.out.println("Enter product Name : ");
		this.productName = scanner.next();

	}

	public void displayDetails() {
		System.out.println("Enter product id : "+productId);
		System.out.println("Enter product Name : "+productName);

	}
	
	public boolean searchById(int id) {
		return id==productId;
	}
}
