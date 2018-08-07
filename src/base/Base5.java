package base;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Base5 {
   public String longestCommonPrefix (String[] strs){
      if(strs==null||strs.length==0) {
          return  "";
      }
      StringBuffer res = new StringBuffer();
       Arrays.sort(strs);
       String s1 = strs[0];
       String s2 = strs[strs.length-1];
       for (int i=0;i<s1.length();i++){
           if(s2.length()>i&&s2.charAt(i)==s1.charAt(i)){
               res.append(s1.charAt(i));
           }else{
               return  res.toString();
           }
       }
       return  res.toString();

   }
}
