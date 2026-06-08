import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpenses(ArrayList<Expense> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : list) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                double amount = Double.parseDouble(data[0]);
                String category = data[1];
                String type = data[2];
                String date = data[3];

                list.add(new Expense(amount, category, type, date));
            }

        } catch (IOException e) {
            // First time run — ignore
        }

        return list;
    }
}