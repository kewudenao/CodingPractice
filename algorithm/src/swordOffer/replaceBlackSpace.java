package swordOffer;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

public class replaceBlackSpace {

      public String replaceSpace(String s){
        StringBuffer returnString = new StringBuffer();
        for(int i = 0 ; i< s.length();i++){
            if(s.charAt(i)==' '){
                returnString.append("%20");
                continue;
            }
            returnString.append(s.charAt(i));
        }
        return returnString.toString();
    }
}
