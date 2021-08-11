package main.java.easy;

/**
 * 7. 整数反转
 */
public class ReverseInteger {
	public int reverse(int x) {
		long xx=x;
		StringBuilder s = new StringBuilder();
		if (xx >= 0) {
			if (xx % 10 == 0) {
				s.append(xx / 10);
			} else {
				s.append(xx);
			}
			return (int) Long.parseLong(s.reverse().toString());
		} else {
			xx=-xx;
			if (xx % 10 == 0) {
				s.append(xx / 10);
			} else {
				s.append(xx);
			}
			return (int) -Long.parseLong(s.reverse().toString());
		}
	}

	public static void main(String[] args) {
		ReverseInteger n = new ReverseInteger();
		System.out.println(n.reverse(-123001));
	}

}
