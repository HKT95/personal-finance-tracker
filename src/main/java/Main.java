import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();

        List<Transaction> loaded = StorageManager.load();
        for (Transaction t : loaded) manager.addTransaction(t);

        while (true) {
            System.out.println("\n=== Registro de finanzas personal ===");
            System.out.println("1. Añadir deposito");
            System.out.println("2. Añadir gasto");
            System.out.println("3. Ver transacciones");
            System.out.println("4. Ver balance");
            System.out.println("5. Borrar datos guardados");
            System.out.println("6. Guardar datos y salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                case "2":
                    System.out.print("Categoria: ");
                    String category = scanner.nextLine();
                    System.out.print("Monto: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Fecha (DD-MM-AAAA): ");
                    String date = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();

                    Transaction t = new Transaction(
                            option.equals("1") ? "deposito" : "gasto",
                            category, amount, date, description);
                    manager.addTransaction(t);
                    System.out.println("Transacción añadida!");
                    break;

                case "3":
                    // Ver todas las transacciones guardadas
                    System.out.println("\nTodas las transacciones:");
                    for (Transaction trans : manager.getTransactions()) {
                        System.out.println(trans);
                    }
                    break;

                case "4":
                    // Ver balance
                    System.out.printf("\nBalance actual: $%.2f\n", manager.getBalance());
                    break;

                case "5":
                    // Borrar datos guardados
                    System.out.println("Eliminando datos guardados...");
                    StorageManager.clear();
                    manager.getTransactions().clear();
                    System.out.println("Datos guardados eliminados.");
                    break;

                case "6":
                    //Guardar y cerrar el programa
                    StorageManager.save(manager.getTransactions());
                    System.out.println("Datos guardados. Adios!");
                    return;


                default:
                    System.out.println("Opción invalida. Intente nuevamente.");
            }
        }
    }
}