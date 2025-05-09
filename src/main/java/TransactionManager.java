import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        double income = 0, expenses = 0;
        for (Transaction t : transactions) {
            if (t.type.equalsIgnoreCase("deposito")) income += t.amount;
            else expenses += t.amount;
        }
        return income - expenses;
    }
}