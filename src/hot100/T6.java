package hot100;

import java.util.ArrayList;
import java.util.List;

public class T6 {
    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        //flag是用于控制层数的增或者减
        //cnt用于记录层数和改变flag
        int flag = -1, cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            list.get(cnt).append(ch[i]);
            if (cnt == 0 || cnt == numRows - 1) {
                flag = -flag;
            }
            cnt += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : list) {
            res.append(builder);
        }
        return res.toString();
    }
}
