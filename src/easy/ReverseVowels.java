package easy;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author lijx
 * @date 2019/1/16 - 16:37
 * 345.	反转字符串中的元音字母
 */
public class ReverseVowels {
    private String vowels = "aeiouAEIOU";

    public String reverseVowels(String s) {
        if (s == null || "".endsWith(s)) {
            return "";
        }
        char[] chars = s.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++) {
            if (isVowels(chars[i])) {
                for (; j > i; j--) {
                    if (isVowels(chars[j])) {
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                        j--;
                        break;
                    }
                }
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char s) {
        return vowels.indexOf(s) != -1;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("leetcode"));
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.get(new Random().nextInt(objects.size()));
        objects.remove(Integer.valueOf(1));
        System.out.println(objects.size());
    }
}
