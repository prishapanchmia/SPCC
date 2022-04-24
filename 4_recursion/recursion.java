import java.util.*;

public class recursion {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the grammar expression");
        String input= sc.next();
        String[] arr = input.split("->", 2);
        String[] arr2 = arr[1].split("/", 2);
        String a= arr2[0];
        if(arr[0].equals(a.charAt(0) + "")){
            System.out.println("Left Recursion Exists.");
            a= a.replace(arr[0], ""); 
            System.out.println("Grammar after left recurrsion is : ");
            System.out.println(arr[0]+" -> "+arr2[1]+arr[0]+"'");
            System.out.println(arr[0]+"' -> "+a+arr[0]+"' / Eps");
        }else{
            System.out.println("No Left Recursion exists.");
        }        
    }
}