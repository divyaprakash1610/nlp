import java.util.*;

public class Dfa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Regular Expression: ");
        String rg = sc.next(), ip1, ip2;
        System.out.print("Start state: ");
        ip1 = sc.next();
        System.out.print("End state: ");
        ip2 = sc.next();

        int i = rg.indexOf('*') + 1;
        List<String> arr = new ArrayList<>();
        for (; i < rg.length(); i++)
            arr.add(rg.charAt(i) + "");

        List<Integer> ar2 = new ArrayList<>();
        ar2.add(0);
        for (int j = 1; j < arr.size(); j++) {
            String ip = arr.get(j).equals(ip1) ? ip2 : ip1;
            int k = j - 1;
            while (k >= 0 && !arr.get(k).equals(ip))
                k--;
            ar2.add(k + 1);
        }

        String lastIp = arr.get(arr.size() - 1).equals(ip1) ? ip2 : ip1;
        boolean flag = lastIp.equals(ip1);
        int k = arr.size() - 2;
        while (k >= 0 && !arr.get(k).equals(lastIp))
            k--;
        ar2.add(k + 1);

        System.out.println("State\t" + ip1 + "\t" + ip2 + "\n-------------------------");
        for (int j = 0; j < arr.size(); j++) {
            System.out.print(j + "\t");
            System.out.println(arr.get(j).equals(ip1) ? (j + 1 + "\t" + ar2.get(j)) : (ar2.get(j) + "\t" + (j + 1)));
        }
        System.out.println(
                arr.size() + "\t" + (flag ? ar2.get(ar2.size() - 1) + "\t0" : "0\t" + ar2.get(ar2.size() - 1)));
    }

}
