import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SymbolTable {
    public static Map<String, String> build(String filePath, String language) throws IOException {
        Map<String, String> table = new LinkedHashMap<>();
        String regex = "\\b(int|float|double|char|long|short|boolean)\\s+([^;]+);";
        Pattern pattern = Pattern.compile(regex);

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String vars = matcher.group(2);
                String[] varList = vars.split(",");
                for (String var : varList) {
                    var = var.split("=")[0].trim();
                    table.put(var, type);
                }
            }
        }
        br.close();
        return table;
    }

    public static void print(Map<String, String> table) {
        System.out.println("Variable Name" + "    |    " + "Type");
        System.out.println("----------------+------------");
        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.printf(entry.getKey() + "        " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter language (C, C++, Java): ");
        String lang = sc.nextLine();
        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        sc.close();
        Map<String, String> table = build(path, lang);
        print(table);
    }
}
