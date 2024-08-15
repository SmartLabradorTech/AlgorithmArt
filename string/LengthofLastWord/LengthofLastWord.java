package string.LengthofLastWord;

// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ') {
                if (length > 0) {
                    return length;
                }
            } else {
                length++;
            }

        }

        return length;
    }

    public static void main(String[] args) {

        LengthofLastWord ll = new LengthofLastWord();

        System.out.println(ll.lengthOfLastWord("123 1 "));
    }
}
