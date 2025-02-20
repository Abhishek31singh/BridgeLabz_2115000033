import java.util.*;
public class Rotate {
    public static void main(String[] args) {
        List<Integer> st=Arrays.asList(10,20,30,40,50);
        int rotate=2;
        List<Integer> rotated=rotatation(st,rotate);
        System.out.println(rotated);
    }
    public static List<Integer> rotatation(List<Integer> list,int pos){
        if(list==null || list.size()==0 || pos==0){
            return list;
        }
        pos=pos%list.size();
        List<Integer> rotated=new ArrayList<>();
        rotated.addAll(list.subList(pos,list.size()));
        rotated.addAll(list.subList(0,pos));
        return rotated;
    }

}