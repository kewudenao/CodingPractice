package swordOffer;


//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

public class reverseLeftWords {

    /**
     *
     *  通过native方法 直接在内存中修改变量的位置 时间复杂度相对较低
     *  重点是考虑 拷贝元素前后的边界
     */
     public String methodOne(String s,int n){
        char[] r1=new char[s.length()];
        System.arraycopy(s.toCharArray(),n,r1,0,s.length()-n);
        System.arraycopy(s.toCharArray(),0,r1,s.length()-n,n);
        return  new String(r1);
    }
    // ————————————————————————————待解决
    // 思路是 (i-n+chars.length)%chars.length 将 i 位置的字符串替换为  (x-n+chars.length)%chars.length
    public String methodTwo(String s,int n){
        char[] chars = s.toCharArray();
        int m = chars.length;
         int r = n;
         int temp = 0;
         while (m!=0){
             temp = m%r;
             m = r ;
             r = temp;
         }

         for(int i=0 ; i < m ; i++){
          char res = chars[i];
          chars[i] = chars[(i-n+chars.length)%chars.length];

         }
         return  null;
    }


}
