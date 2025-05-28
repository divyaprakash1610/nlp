import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SymbolTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sample.java"));
        List<String[]> table = new ArrayList<>();
        String types = "int|float|double|char|long|short|boolean|String";
        Pattern p = Pattern.compile("\\b(" + types + ")\\s+([^;]+);");

        String line;
        while ((line = br.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                for (String v : m.group(2).split(",")) {
                    String varName = v.trim().split("=")[0].trim();
                    table.add(new String[] { varName, m.group(1) });
                }
            }
        }

        System.out.printf("%-15s %-10s\n", "Variable Name", "Type");
        System.out.println("-------------------------------");
        for (String[] row : table)
            System.out.printf("%-15s %-10s\n", row[0], row[1]);
        br.close();
    }
}
