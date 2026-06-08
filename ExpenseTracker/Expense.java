public class Expense {
    private double amount;
    private String category;
    private String type;
    private String date;

    public Expense(double amount, String category, String type, String date) {
        this.amount = amount;
        this.category = category;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    // Save format
    public String toFileString() {
        return amount + "," + category + "," + type + "," + date;
    }
}
