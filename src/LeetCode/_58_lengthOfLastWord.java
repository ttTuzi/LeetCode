package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月16日 2:43 PM
 */
public class _58_lengthOfLastWord {
    public static void main(String[] args) {

    }


    public static int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length()-1; i >=0 ; i--) {

            if (s.charAt(i)!=' '){
                res++;
            }else if(res!=0){
                break;
            }
        }
        return res;
    }
}
