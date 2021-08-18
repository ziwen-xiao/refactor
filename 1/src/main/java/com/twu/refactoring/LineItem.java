package com.twu.refactoring;

public class LineItem {
	private final String description;
	private final double price;
	private final int quantities;

	public LineItem(String description, double price, int quantities) {
		this.description = description;
		this.price = price;
		this.quantities = quantities;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantities;
	}

    double totalAmount() {
        return price * quantities;
    }
}