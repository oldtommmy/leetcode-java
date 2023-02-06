package FirstExercise.stackandqueue;

import java.util.ArrayDeque;


/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 输入："abbaca"
 * 输出："ca"
 */
@SuppressWarnings({"all"})
public class T1074 {

    //使用双指针
    public String removeDuplicates(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < c.length) {

           c[left] = c[right];
           if (left > 0 && c[left] == c[left - 1]) {
               left--;
           } else {
               left++;
           }
           right++;
        }
        return new String(c,0,left);
    }
//    使用栈
//    public String removeDuplicates(String s) {
//
//        ArrayDeque<Character> deque = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (deque.isEmpty() || deque.peek() != c) {
//                deque.push(c);
//            }else {
//                deque.pop();
//            }
//        }
//
//        String res = "";
//        while (!deque.isEmpty()) {
//            res = deque.pop() + res;
//        }
//        return res;
//    }
}
