import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class codeop {
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of lines");
        int size = sc.nextInt();
        String optimized[] = new String[size];
        String varN[] = new String[size];
        String temp;
        for (int i = 0; i < size; i++) {
            temp = br.readLine();
            String arr[] = temp.split("=");
            String res = arr[1];
            if (!inArr(optimized, res)  ) {
                // || !inArr(varN,arr[0])
                optimized[i] = res;
                varN[i] = arr[0];
            }
        }
        System.out.println("\nOUTPUT:");
        for (int i = 0; i < size; i++) {
            if (varN[i] != null) {
                System.out.println(varN[i] + " = " + optimized[i]);
            }

        }
    }

    public static Boolean inArr(String arr[], String text) {
        Boolean inArr = false;
        if (Arrays.asList(arr).contains(text)) {
            inArr = true;
        }
        return inArr;
    }
}