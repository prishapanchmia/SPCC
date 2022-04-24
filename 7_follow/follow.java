import java.util.*;
public class follow {
    static HashMap<String,String> fol(HashMap<String,String> first, HashMap<String,String> prod,HashMap<String,String> followList,String nt){
        String ntProd = prod.get(nt);
        String fi = first.get(nt);
            String[] arr = ntProd.split("\\|");
            for(int i = 0; i<arr.length; i++){
               int prodLen = arr[i].length();
                for(int j =0;j<prodLen;j++){
                    if(prod.containsKey(arr[i].charAt(j) + "")){
                        if(j+1<prodLen){
                            if(prod.containsKey(arr[i].charAt(j+1)+"")){
                                checkUpdate(followList,arr[i].charAt(j)+"",first.get(arr[i].charAt(j+1)+""));
                            }else{
                                checkUpdate(followList,arr[i].charAt(j)+"",arr[i].charAt(j+1)+"");
                            }
                        }else{
                            checkUpdate(followList, arr[i].charAt(j)+"", nt);         
                    }
                }  
            }
        }
    return followList;
}
    static HashMap<String, String> checkUpdate(HashMap<String,String> map, String k, String v){
        if(map.containsKey(k)){
           String val = map.get(k);
           map.put(k,val+v);
        }else{
            map.put(k,v);
        }
        return map;
    }
    static HashMap<String,String> replaceNtms(HashMap<String,String> map,String[] ntms){
        for(int i=0;i<ntms.length;i++){
            String fol = map.get(ntms[i]);
            for(int j = 0;j<fol.length();j++){
                if(map.containsKey(fol.charAt(j) + "")){

                    checkUpdate(map, ntms[i] , map.get(fol.charAt(j) + ""));
                }
            }
            
        }
        return map;
    }
    static HashMap<String,String> removeDups(HashMap<String,String> map,String[] ntms){
        for(int i=0;i<ntms.length;i++){
            String fol = map.get(ntms[i]);
            ArrayList un = new ArrayList();
            for(int j=0;j<fol.length();j++){
                if(!un.contains(fol.charAt(j)+"")){
                    un.add(fol.charAt(j)+"");
                }
            }
            String list = String.join("",un);
            map.put(ntms[i],list);
        }
        return map;
    }
    public static void main(String[] args) {
            HashMap<String, String> prod = new HashMap<String, String>();
            HashMap<String, String> first = new HashMap<String, String>();
            HashMap<String, String> followList = new HashMap<String, String>();
            Scanner sc = new Scanner(System.in);
            String[] ntms = {"S","A","B","C","D"};
            String[] prods = {"AB|gDa","ab|c","dC","gC|g","fD|g"};
            String[] firstList={"acg","ac","d","g","fg"};
            for (int i = 0; i < prods.length; i++) {
                prod.put(ntms[i], prods[i]);
                first.put(ntms[i],firstList[i]);
            }
            for (int i = 0; i < ntms.length; i++) {
                followList = fol(first, prod, followList, ntms[i]);
            }
            followList = checkUpdate(followList,ntms[0],"$");
            followList = replaceNtms(followList, ntms);
            followList = removeDups(followList, ntms);
            for(int i =0; i<ntms.length;i++){
               System.out.print("Follow of "+ ntms[i] + ": " ); 
               String fol = followList.get(ntms[i]);
               for(int j=0;j<fol.length();j++){
                if(!followList.containsKey(fol.charAt(j)+"")){
                    System.out.print(fol.charAt(j)+"");
                }
               }
               System.out.print("\n");
            }     
    }
}
