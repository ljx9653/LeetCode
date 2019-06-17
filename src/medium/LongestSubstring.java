package medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ljx
 * 3. 无重复字符的最长子串
 * TODO
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		String ss = s.trim();
		if (!containsSameChar(ss)) {
			return ss.length();
		}
		if (ss.length() == 0) {
			return 0;
		}
		int resultNum = 1;
		for (int num = 2; num <= ss.length(); num++) {
			for (int j = 0; j + num <= ss.length(); j++) {
				if (!containsSameChar(ss.substring(j, j + num)) && num > resultNum) {
					resultNum = num;
				}
			}
		}
		return resultNum;
	}

	public boolean containsSameChar(String s) {

		Set<Character> m = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (m.contains(s.charAt(i))) {
				return true;
			}
			m.add(s.charAt(i));
		}
		return false;
	}

	public static void main(String[] args) {
		LongestSubstring l=new LongestSubstring();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
	}

}
