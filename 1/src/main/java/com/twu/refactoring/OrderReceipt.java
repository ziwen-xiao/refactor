package com.twu.refactoring;

public class OrderReceipt {
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
    	String outputHeader = "======Printing Orders======\n";
    	return outputHeader + outputDetails();
	}

	private String outputDetails() {
		StringBuilder output = new StringBuilder();
		double totalSalesTax = 0d;
		double total = 0d;

        output.append(order.getCustomerName())
				.append(order.getCustomerAddress());

		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription()).append('\t')
					.append(lineItem.getPrice()).append('\t')
					.append(lineItem.getQuantity()).append('\t')
					.append(lineItem.totalAmount()).append('\n');

            double salesTax = lineItem.totalAmount() * 0.10;
            totalSalesTax += salesTax;
            total += lineItem.totalAmount() + salesTax;
		}
		output.append("Sales Tax").append('\t')
				.append(totalSalesTax)
				.append("Total Amount").append('\t')
				.append(total);
		return output.toString();
	}
}