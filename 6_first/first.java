import java.util.*;

class first {
    static ArrayList fi(String a, HashMap<String, String> prod) {
	ArrayList firstList = new ArrayList();
        String aProds = prod.get(a);
        if (aProds.indexOf("|") != -1) {
            String[] arr = aProds.split("\\|");
            for (int i = 0; i < arr.length; i++) {
                String first = arr[i].charAt(0) + "";
                if (prod.containsKey(first)) {
                    firstList.add(fi(first, prod));
                } else {
                    firstList.add(first);
                }
            }
        } else {
            String first = aProds.charAt(0) + "";
            if (prod.containsKey(first)) {
                firstList.add(fi(first, prod));
            } else {
                firstList.add(first);
            }
        }
        return firstList;
    }

    public static void main(String[] args) {
        HashMap<String, String> prod = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Non Terminals: ");
        int prods = sc.nextInt();
        String[] ntms = new String[prods];
        for (int i = 0; i < prods; i++) {
            System.out.println("Enter Non terminal: ");
            String nt = sc.next();
            ntms[i] = nt;
            System.out.println("Enter productions of " + nt + " :");
            String p = sc.next();
            prod.put(nt, p);
        }
        System.out.println(prod);
        for (int i = 0; i < ntms.length; i++) {
            System.out.println("first of "+ntms[i]+": "+fi(ntms[i], prod));
        }
    }
}
