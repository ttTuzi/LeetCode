package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月25日 2:34 PM
 */
public class _20_ValidParentheses {
    public static void main(String[] args) {

    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
            }else if (!stack.isEmpty() && stack.peek()==map.get(chars[i])){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
