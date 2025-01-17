package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeatingCharacters(s));
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s){
        int l=0;
        int r=0;
        int max=0;
        int bound = s.length();
        Map<Character,Integer> hmap = new HashMap<>();
        while(l<bound && r<bound){
            if(hmap.containsKey(s.charAt(r)) && hmap.get(s.charAt(r))!=0){
                hmap.put(s.charAt(l),0);
                l++;
            }else {
                hmap.put(s.charAt(r),1);
                r++;
            }
            max= Math.max(max,r-l);
        }
        return max;
    }
}
