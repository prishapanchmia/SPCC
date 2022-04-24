import java.util.*;
public class lexicalAnalysis {

    static ArrayList Analyzer(String[] brk, String[] outp,boolean num){
        ArrayList output =  new ArrayList();
        if(!num){
            for( int i =0; i<brk.length;i++){
                for( int j =0; j< outp.length; j++){
                    if(brk[i].equals(outp[j])){
                        output.add(brk[i]);
                        break;
                    }
                }
            }
        }
        else{
            for( int i =0; i<brk.length;i++){
                try {
                    int intValue = Integer.parseInt(brk[i]);
                    output.add(intValue);
                } catch (NumberFormatException e) {
                }
            }
        }
        return output;
    }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Input: ");
    String str = sc.nextLine();
    String[] brk = str.split(" ");
    String[] kw = {"string","int","bool","double","if","else","boolean","break"};
    String[] op = {"+","-","/","*","="};
    String[] dls = {";"};
    String[] cons = {"1","2","3","4","5","6","7","8","9","0"};
    
    System.out.println("Keywords: "+Analyzer(brk, kw,false));
    System.out.println("Operators: "+Analyzer(brk, op,false));
    System.out.println("Delimiters"+Analyzer(brk, dls,false));
    System.out.println("Constants"+Analyzer(brk, cons,true));
}
}