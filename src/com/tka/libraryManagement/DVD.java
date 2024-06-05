package com.tka.libraryManagement;

import java.util.Scanner;

public class DVD implements LibraryItem {

	productInfo[] dvdInfo = new productInfo[10];
	Scanner scanner = new Scanner(System.in);
	public int totalDVD;

	@Override
	public void initialItems() {
		System.out.println("How many DVD you want in BookList : ");
		this.totalDVD = scanner.nextInt();

		for (int i = 0; i < totalDVD; i++) {
			dvdInfo[i] = new productInfo();
		}

		System.out.println("Enter DVD Details");

		for (int i = 0; i < totalDVD; i++) {
			dvdInfo[i].acceptDetails();
		}

		System.out.println("\nDisplay DVD details");

		for (int i = 0; i < totalDVD; i++) {
			dvdInfo[i].displayDetails();
			System.out.println();
		}
	}

	@Override
	public void addItem() {
		System.out.println("\nEnter a new DVD's details to be added to the list");

		productInfo newDVD = new productInfo();
		newDVD.acceptDetails();

		if (totalDVD >= dvdInfo.length) {
			System.out.println("DVD list is full. Cannot add new DVD.");
			return;
		}

		dvdInfo[totalDVD] = newDVD;
		totalDVD++;

		System.out.println("\nDisplay DVD details after adding new Dvd");

		for (int i = 0; i < totalDVD; i++) {
			dvdInfo[i].displayDetails();
			System.out.println();
		}
	}

	@Override
	public void searchItem() {
		System.out.println("\n\nEnter a DVD id to be searched");
		int id = scanner.nextInt();

		productInfo foundProduct = null;

		for (int i = 0; i < totalDVD; i++) {
			if (dvdInfo[i].searchById(id)) {
				foundProduct = dvdInfo[i];
				break;
			}
		}

		if (foundProduct != null) {
			System.out.println();
			foundProduct.displayDetails();
		} else {
			System.out.println("DVD id not found");
		}

	}

	@Override
	public void removeItem() {
		System.out.println("\nWhich DVD you want to delete please Enter DVD Id");
		int delBookId = scanner.nextInt();

		for (int i = delBookId - 1; i < totalDVD - 1; i++) {
			dvdInfo[i] = dvdInfo[i + 1];
		}

		totalDVD--;

		System.out.println("\nDisplay DVD details after deleting a Dvd");

		for (int i = 0; i < totalDVD; i++) {
			dvdInfo[i].displayDetails();
			System.out.println();
		}

	}

}
