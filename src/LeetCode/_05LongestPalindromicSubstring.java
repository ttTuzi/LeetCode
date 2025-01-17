package LeetCode;

public class _05LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s=  "a";
        System.out.println(longestPalindrome(s));
    }


    /*
    挑选一个点,从两边扩散
    有两种case:
    一点扩散,长度始终是odd
    两点扩散,长度始终是even
    这样就包含了所以case
    example:babbad,   选index 3
    odd:  b<=a=>b, bab
    选index 3,4
    even: a<=bb=>a, abba
     */
    public static String longestPalindrome(String s) {
        String max = s.substring(0,1);
        for (int i = 0; i < s.length()-1; i++) {
            String oddCase = expandAroundCenter(s, i, i);
            String evenCase = expandAroundCenter(s, i, i + 1);
            if(oddCase.length()>=max.length()){
                max=oddCase;
            }
            if(evenCase.length()>=max.length()){
                max=evenCase;
            }
        }
        return max;
    }

    public static String expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //left+1, because if update before last check pass,
        //right don't need, because it is [)
        return s.substring(l+1,r);
    }
}
