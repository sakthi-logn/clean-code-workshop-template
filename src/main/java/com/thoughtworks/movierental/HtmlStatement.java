package com.thoughtworks.movierental;

public class HtmlStatement implements Statement {
    private final String customerName;
    private final Rentals rentals;

    public HtmlStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    @Override
    public String generate() {
        return htmlStatement();
    }

    public String htmlStatement() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Rental Records</title>\n" +
                "</head>\n" +
                "<body>\n" +
                htmlStatementHeader() + htmlStatementBody() + htmlStatementFooter() +
                "</body>\n" +
                "</html>";
    }

    private String htmlStatementBody() {
        return rentals.transform(rental -> String.format("%s&ensp;%s<br>\n", rental.title(), rental.amount()));
    }

    private String htmlStatementHeader() {
        return String.format("<h1>Rental Record for <b>%s</b></h1>\n", customerName);
    }

    private String htmlStatementFooter() {
        return String.format("Amount owed is <b>%s</b><br>\n", rentals.totalAmount()) +
                String.format("You earned <b>%s</b> frequent renter points<br>\n", rentals.frequentRenterPoints());
    }
}
