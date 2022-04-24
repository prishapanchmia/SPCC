import java.util.*;
import java.io.*;

public class fir{
    static ArrayList f(String a, HashMap<String, String> prod){
    ArrayList firstList = new ArrayList();
    
            String prods = prod.get(a);
                String[] arr = prods.split("\\|");
                for(int i =0; i<arr.length; i++ ){
                    String first = arr[i].charAt(0) + "";
                    if(prod.containsKey(first)){
                        firstList.add(f(first,prod));
                    } else{
                        firstList.add(first);
                    }
                } 
            
        return firstList;
    }

public static void main(String[] args) {
    HashMap<String, String> prod = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);
    System.out.println("no. of non-terminals: ");
    int num = sc.nextInt();
    String[] nonTer = new String[num];
    for (int i=0;i<num;i++){
        System.out.println("Non terminal:");
        String nt = sc.next();
        nonTer[i] = nt;
        System.out.println("prods of " + nt + ": ");
        String p = sc.next();
        prod.put(nt,p);
    }
    System.out.println(prod);
    System.out.println("First is:");
    for (int i = 0; i < nonTer.length; i++) {
        System.out.println(nonTer[i]+": "+f(nonTer[i], prod));
    }
}

}