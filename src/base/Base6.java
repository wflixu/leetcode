package base;

import java.util.Stack;

public class Base6 {
    public  boolean isValid(String str){
        if(str.length()==0||str.length()%2==1){
            return  false;
        }
        Stack<Character>stack = new Stack<Character>();
        for(int i=0;i<str.length();i++) {
            Character c = str.charAt(i);
            if (c != '(' && c != ')' && c != '[' && c != ']' && c != '{' && c != '}') {
                return false;
            }
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(c==')'){
                    if(stack.peek()!='('){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else if(c==']'){
                    if(stack.peek()!='['){
                        return  false;
                    }else{
                        stack.pop();
                    }
                }else if(c=='}'){
                    if(stack.peek()!='{'){
                        return  false;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        if(!stack.isEmpty()){
          return  false;
        }else{
            return true;
        }

    }
}
