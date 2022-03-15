package swordOffer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class firstUniqChar {
    // 主要特征是 唯一 ， 且第一次出现，容易想到使用LinkedHashMap 或 TreeHashMap 但是并没有明白TreeHash的比较方式，待解决
    public char methodOne(String s){
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();
        for (int i=0 ; i < s.length() ;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),false);
            }else {
                map.put(s.charAt(i),true);
            }
        }
        for(Map.Entry<Character,Boolean> m : map.entrySet()){
            if(m.getValue())return m.getKey();
        }

        return  ' ' ;
    }
    public char methodTwo(String s){
        TreeMap<Character,Boolean> map = new TreeMap<>(
            (o1,o2)-> {
                return 1;
            }
        );
        for (int i=0 ; i < s.length() ;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),false);
            }else {
                map.put(s.charAt(i),true);
            }
        }
        for(Map.Entry<Character,Boolean> m : map.entrySet()){
            if(m.getValue())return m.getKey();
        }

        return  ' ' ;
    }
}
