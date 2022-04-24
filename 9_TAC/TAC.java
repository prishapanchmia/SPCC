import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class TAC {
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the expression: ");
        String exp = br.readLine();
        List<String> symbol = new ArrayList<String>();
        for (int i = 0; i < exp.length(); i++) {
            char s = exp.charAt(i);
            if (s == '+' || s == '-') {
                // System.out.println(s);
                String a = s + "";
                symbol.add(a);
            }
        }
        // System.out.println(symbol);
        String splitExp[] = exp.split("[-+=]");
        String varN = splitExp[0];
        String res[] = new String[splitExp.length];
        for (int i = 1; i < splitExp.length; i++) {
            res[i] = splitExp[i];
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != null) {
                System.out.println("t" + i + " = " + res[i]);
            }
        }
        String op = "";
        for (int i = 0; i < symbol.size(); i++) {
            op += "t" + (i + 1) + " " + symbol.get(i) + " ";
        }
        op += "t" + (symbol.size() + 1);
        System.out.println("t" + res.length + " = " + op);
        System.out.println(varN + " = " + "t" + res.length);
    }
}