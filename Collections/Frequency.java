import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        List<String> st=Arrays.asList("apple", "banana"
                ,"orange","apple");
        Map<String,Integer> freq=count(st);
        System.out.println(freq);
    }
    public static Map<String,Integer> count(List<String> st){
        Map<String,Integer> map=new HashMap<>();
        for(String str:st){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }
        return map;
    }
}