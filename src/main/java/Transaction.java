public class Transaction {
    String type; // "income" or "expense"
    String category;
    double amount;
    String date;
    String description;

    public Transaction(String type, String category, double amount, String date, String description) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String toString() {
        return String.format("%s | %s | $%.2f | %s | %s", type.toUpperCase(), category, amount, date, description);
    }
}