package swordOffer;

import java.util.HashMap;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11
 * 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 *
 *  思路是用动态规划
 *  dp[n] = dp[n-1]+dp[n-2]
 *
 *  虽然想到了转移方程，但是用例提交一直失败，看题解之后发现以下问题：
 *  1.变量的使用问题：
 *      在解题过程中没有考虑变量声明是否为必要(自己的思路是用ArrayList装dp[n-1]、dp[n-2]，
 *      但实际有意义的其实只有最后两个，即可以用常量的空间。
 *  2.转移方程的范围问题：
 *      虽然确定了转移方程，但实际上转移方程的使用其实是有条件的
 *      当 tmp<=25&&tmp>=10 才可以用 dp[n] = dp[n-1]+dp[n-2]
 *      其他情况其实是： dp[n] = dp[n-1] 这个方程
 *
 */
public class translateNum {
    public int methodOne(int num) {
        int n1 = 1, n2 =1,x,y=num%10;
        while(num>0){
            num/=10;
            x = num%10;
            int tmp = x*10+y;
            int n0 = (tmp<=25&&tmp>=10)?n1+n2:n1;
            n2 = n1;
            n1 = n0;
            y=x;
            String a;
            char s = 's';
            String.valueOf(s);
        }
        return n1;
    }
}
