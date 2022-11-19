import java.util.*;

// The code checks for correctness of 3 parentheses ( [ {
// The code will present the element of a string, where mistake takes place, or "Success", if everything is fine
// The code asks line input
// for example:
// ([](){([])})     (answer: Success)
// (slkj{lk[lsj]}   (answer: 1)
// ((({[]})         (answer: 2)

public class CheckParantheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] lineChar = scanner.nextLine().toCharArray();
        List<Character> opening = Arrays.asList('{', '[', '(');
        List<Character> closing = Arrays.asList('}', ']', ')');

        String answer = Patenthneses.check(opening, closing, lineChar);
        System.out.println("The answer is:");
        System.out.println(answer);
    }
}

class Patenthneses {
    private Character character;
    private int index;
    private Patenthneses(Character c, Integer i) {
        this.character = c;
        this.index = i;
    }

    public Character getC() {
        return this.character;
    }

    public int getIndex() {
        return this.index;
    }

    public static String check(List<Character> opening, List<Character> closing, char[] lineChar) {
        Stack<Patenthneses> stack = new Stack<>();
        int index = 0;
        try {
            for (Character x : lineChar) {
                index++;
                if (opening.contains(x)) {
                    stack.push(new Patenthneses(x, index));
                } else if (closing.contains((x))) {
                    if (stack.empty()) return Integer.toString(index);
                    else if (x == '}' && stack.peek().getC() != '{') return Integer.toString(index);
                    else if (x == ')' && stack.peek().getC() != '(') return Integer.toString(index);
                    else if (x == ']' && stack.peek().getC() != '[') return Integer.toString(index);
                    else {
                        stack.pop();
                    }
                }
            }
        } catch (Exception e) {
        }
        return stack.empty() ? "Success" : Integer.toString(stack.peek().getIndex());
    }


}