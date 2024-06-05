package com.tka.libraryManagement;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Book Details");

		LibraryItem bookItem = new Book();

		bookItem.initialItems();
		bookItem.addItem();
		bookItem.searchItem();
		bookItem.removeItem();

		System.out.println("Dvd details");

		LibraryItem dvdItem = new DVD();

		dvdItem.initialItems();
		dvdItem.addItem();
		dvdItem.searchItem();
		dvdItem.removeItem();

	}
}
