import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StorageManager {
    private static final String FILE_NAME = "transactions.json";
    private static final Gson gson = new Gson();

    // Guarda la lista de transacciones en un archivo Json
    public static void save(List<Transaction> transactions) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(transactions, writer);  // Convert list to JSON and write it
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    // Carga la lista de transacciones del archivo Json
    public static List<Transaction> load() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<Transaction>>(){}.getType();  // Define the correct type for deserialization
            return gson.fromJson(reader, listType);  // Read and parse the JSON into a list of transactions
        } catch (IOException e) {
            return new ArrayList<>();  // If file doesn't exist or there is an error, return an empty list
        }
    }

    // Borra la lista de transacciones guardadas
    public static void clear() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado con exito.");
            } else {
                System.out.println("Error al eliminar el archivo.");
            }
        } else {
            System.out.println("No se encontro ningun archivo.");
        }
    }
}