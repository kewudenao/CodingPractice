package swordOffer;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
        public int methodOne(String s) {
            Map<Character, Integer> dic = new HashMap<>();
            int res = 0, tmp = 0, len = s.length();
            for(int j = 0; j < len; j++) {
                int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
                dic.put(s.charAt(j), j); // 更新哈希表
                tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
                res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
            }
            return res;
        }

//        public int lengthOfLongestSubstring(String s) {
//            if(s==null||s.isEmpty()) return 0;
//            int max = 0;
//            HashMap<Character,Integer> map = new HashMap();
//            for(int i=0;i<s.length();i++){
//
//                if(map.containsKey(s.charAt(i))){
//                    int temp = i-map.get(s.charAt(i));
//                    max = temp>max?temp:max;
//                    map.put(s.charAt(i),i);
//                    continue;
//                }
//                int temp = i-map.getOrDefault(s.charAt(i),-1);
//                map.put(s.charAt(i),i);
//                max = temp>max?temp:max;
//            }
//            return max;
//        }
//    } 有问题



}
