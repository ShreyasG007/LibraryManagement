package com.tka.libraryManagement;

import java.util.Scanner;

public class Book implements LibraryItem {

	productInfo[] bookInfo = new productInfo[10];
	Scanner scanner = new Scanner(System.in);
	public int totalBooks;

	@Override
	public void initialItems() {
		System.out.println("How many book you want in BookList : ");
		this.totalBooks = scanner.nextInt();

		for (int i = 0; i < totalBooks; i++) {
			bookInfo[i] = new productInfo();
		}

		System.out.println("Enter book Details");

		for (int i = 0; i < totalBooks; i++) {
			bookInfo[i].acceptDetails();
		}

		System.out.println("\nDisplay Book details");

		for (int i = 0; i < totalBooks; i++) {
			bookInfo[i].displayDetails();
			System.out.println();
		}
	}

	@Override
	public void addItem() {
		System.out.println("\nEnter a new book's details to be added to the list");

		productInfo newBook = new productInfo();
		newBook.acceptDetails();

		if (totalBooks >= bookInfo.length) {
			System.out.println("Book list is full. Cannot add new book.");
			return;
		}

		bookInfo[totalBooks] = newBook;
		totalBooks++;

		System.out.println("\nDisplay Book details after adding new book");

		for (int i = 0; i < totalBooks; i++) {
			bookInfo[i].displayDetails();
			System.out.println();
		}
	}

	@Override
	public void searchItem() {
		System.out.println("\n\nEnter a book id to be searched");
		int id = scanner.nextInt();

		productInfo foundProduct = null;

		for (int i = 0; i < totalBooks; i++) {
			if (bookInfo[i].searchById(id)) {
				foundProduct = bookInfo[i];
				break;
			}
		}

		if (foundProduct != null) {
			System.out.println();
			foundProduct.displayDetails();
		} else {
			System.out.println("Book id not found");
		}

	}

	@Override
	public void removeItem() {
		System.out.println("\nWhich book you want to delete please Enter bookId");
		int delBookId = scanner.nextInt();
		
		for (int i = delBookId-1; i < totalBooks - 1; i++) {
			bookInfo[i] = bookInfo[i + 1];
		}
		
		totalBooks--;
		
		System.out.println("\nDisplay Book details after deleting a book");

		for (int i = 0; i < totalBooks; i++) {
			bookInfo[i].displayDetails();
			System.out.println();
		}
				
				
	}

}
