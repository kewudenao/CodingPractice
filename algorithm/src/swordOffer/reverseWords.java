package swordOffer;

public class reverseWords {
    public String methodOne(String s) {
        s =s.trim();
        int j = s.length()-1,i=j;
        StringBuffer sb = new StringBuffer();
        while(i>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i>=0&&s.charAt(i)==' ') i--;
            j=i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        new reverseWords().methodOne("the sky is blue");
    }
}
