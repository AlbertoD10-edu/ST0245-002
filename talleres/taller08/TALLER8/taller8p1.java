/**
 * Write a description of class taller8p1 here.
 * 
 * @author (Alberto Andres Diaz Mejia) 
 * @version (25/09/2020)
 */
import java.util.Stack;
public class taller8p1{
    public static int polaca(String string ){
        String[] prefixStr = string.split("");
        Stack <Integer> stack = new Stack<>(); 
        for(int i=0;i<prefixStr.length;i++){
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(prefixStr[i].equals("*")){
                stack.push(stack.pop()*stack.pop());   
            }else if(prefixStr[i].equals("-")){
                stack.push(stack.pop()-stack.pop());
            }else if(prefixStr[i].equals("/")){
                stack.push(stack.pop()/stack.pop());
            }else {
                stack.push(Integer.parseInt(prefixStr[i]));   
            }
        }
        return stack.pop();
    }
    }
