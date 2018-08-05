package base;

import sun.security.util.Length;

import java.util.*;

public class Base4 {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character , Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        int len = s.length(), result = m.get(s.charAt(len - 1));
        for (int i = len-2; i >=0; i--) {
            if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1)))
                result += m.get(s.charAt(i));
            else
                result -= m.get(s.charAt(i));
        }
        return result;
    }
}
