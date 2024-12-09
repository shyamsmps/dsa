import java.util.ArrayList;
import java.util.List;

public class dummy {


    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        System.out.println(list.remove(list.size()-1));
        System.out.println(list.size());
        System.out.println(list);


        String s = "abcd";
        for (Character c : s.toCharArray()) {
            System.out.println(c);
        }


        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                list.add(c);
            } else {
                if (list.isEmpty() || list.remove(list.size()-1) != c) {
                    return false;
                }
            }
        }
        return true;
    }

}
