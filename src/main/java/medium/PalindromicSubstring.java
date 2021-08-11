package medium;

/**
 * 	5.最长回文子串
 *
 * 	TODO
 */
public class PalindromicSubstring {

	public boolean idPalindromic(String s) {
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public String longestPalindrome(String s) {
		if(s.length()==1){
			return s;
		}
		String re=null;
		for (int num = s.length(); num >= 2; num--) {
			for (int j = 0; j + num <= s.length(); j++) {
				re=s.substring(j, j + num);
				if(idPalindromic(re)){
					return re;
				}
			}
		}
		re=s.charAt(0)+"";
		return re;
	}

	public static void main(String[] args) {
		PalindromicSubstring o = new PalindromicSubstring();
		//System.out.println(o.idPalindromic("cbbbbc"));
		// System.out.println("abba".charAt());
		System.out.println(o.longestPalindrome("cbbbbca"));
	}

}
