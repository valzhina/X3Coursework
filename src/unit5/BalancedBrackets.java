import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
//        System.out.println(balancedBrackets("[2(3){1*+<9>]-}")); //--> false
        System.out.println(balancedBrackets("{3<({6})>8}")); //--> true
//        System.out.println(balancedParentheses("((3)")); //--> false
    }


// Option 1
    public static boolean balancedBrackets(String s) {

        Stack<Character> charStack = new Stack<Character>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        charMap.put('>', '<');

        for(char c : s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                case '<':
                    charStack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                case '>':
                    if(charStack.isEmpty() || charStack.pop().charValue() != charMap.get(c)){
                        return false;
                    }
                    break;
            }
        }
        if(!charStack.isEmpty()) {
            return true;
        }
        return true;
    }


// Option 2(similar but through if statement)
//    public static boolean balancedBrackets(String s) {
//        Stack<Character> stack = new Stack<Character>();
//
//        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
//        bracketPairs.put(')', '(');
//        bracketPairs.put(']', '[');
//        bracketPairs.put('}', '{');
//        bracketPairs.put('>', '<');
//
//        for (int i = 0; i < s.length(); i += 1) {
//
//            // If character is opening bracket '(' 0r '<' ...
//            if (bracketPairs.containsValue(s.charAt(i))) {
//                stack.push(s.charAt(i));
//            }
//            // Else, if character is closing bracket ')' or '>' ...
//            else if (bracketPairs.containsKey(s.charAt(i))) {
//                //then check the Stack
//
//                // Closing bracket without matching opening bracket
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                // Check that most recent bracket on stack matches
//                Character mostRecentBracket = stack.pop();
//                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
//                    return false;
//                }
//            }
//        }
////return True
//        return stack.isEmpty();
//    }


//Option w/ balancedParentheses
//    public static boolean balancedParentheses(String s) {
//        int numUnclosedOpenParens = 0;
//        for (int i = 0; i < s.length(); i += 1) {
//            if (s.charAt(i) == '(') {
//                numUnclosedOpenParens += 1;
//            }
//            else if (s.charAt(i) == ')') {
//                numUnclosedOpenParens -= 1;
//            }
//
//            if (numUnclosedOpenParens < 0) {
//                return false;
//            }
//        }
//        return numUnclosedOpenParens == 0;
//    }
}
