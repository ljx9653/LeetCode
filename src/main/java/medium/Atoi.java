package medium;


/**
 * @author ash
 *未完成，最后一次错误是"-+1"
 * 8.字符串转换整数 (atoi)
 */
@SuppressWarnings({"unused","unchecked"})
public class Atoi {
	public int myAtoi(String str) {
		str = str.trim();
		if ("".equals(str)) {
			return 0;
		}
		char tmp = str.charAt(0);
		int size = str.length();

		if (tmp == '+' || tmp == '-' || tmp <= '9' || tmp >= '0') {
		} else {
			return 0;
		}
		
		if (size > 1) {
			if (tmp == '-') {
				return -Integer.parseInt(getLongestStr(str));
			} else if (tmp == '+') {
				return Integer.parseInt(getLongestStr(str));
			} else {
				return Integer.parseInt(tmp + getLongestStr(str));
			}
		} else {
			if (tmp == '+' || tmp == '-') {
				return 0;
			} else {
				return Integer.parseInt(tmp + "");
			}
		}
	}

	public String getLongestStr(String str) {
		StringBuffer re = new StringBuffer("");
		char tmp;
		for (int i = 1; i < str.length(); i++) {
			tmp = str.charAt(i);
			if (tmp <= '9' && tmp >= '0') {
				re.append(tmp);
			} else {
				return re.toString();
			}
		}
		return re.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(new Atoi().myAtoi("1"));
//		char c='1';
//		System.out.println(c > '9' || c < '0');
	}
}
