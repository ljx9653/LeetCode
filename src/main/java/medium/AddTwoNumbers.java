package medium;

/**
 * 2.两数相加
 */
public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int s1 = getSize(l1);
		int s2 = getSize(l2);
		int sum = 0;
        //是否进位，0不进位
		int ten = 0;
        //两链表长度相等
		if (s1 == s2) {
		    //记录头部，便于返回
			ListNode tmp = l2;
			while (l2 != null) {
				sum = l1.val + l2.val + ten;
				//使用完进位数后重置
				if (ten == 1) {
					ten = 0;
				}
				if (sum >= 10) {
					l2.val = sum % 10;
					ten = 1;
				} else {
					l2.val = sum % 10;
				}
				if (l2.next != null) {
					l1 = l1.next;
					l2 = l2.next;
					//链表被加完后还有进位，就再加一个链表
				} else if (ten != 0) {
					l2.next =  new ListNode(1);
					return tmp;
				} else {
                    break;
                }
			}
			return tmp;
		} else {
		    //两链表长度不相等
			ListNode longNode;
			ListNode shortNode;
			//长链表的长度
			int size = 0;
			if (s1 > s2) {
				longNode = l1;
				shortNode = l2;
				size = s1;
			} else {
				longNode = l2;
				shortNode = l1;
				size = s2;
			}
            //记录头部，便于返回
			ListNode tmp = longNode;
			while (longNode != null && shortNode != null) {
				sum = shortNode.val + longNode.val + ten;
                //使用完进位数后重置
				if (ten == 1) {
					ten = 0;
				}
				if (sum >= 10) {
					longNode.val = sum % 10;
					ten = 1;
				} else {
					longNode.val = sum % 10;
				}

				if (shortNode.next != null) {
					shortNode = shortNode.next;
					longNode = longNode.next;
					size--;
                    //短链表被加完了，但还有进位
				} else if (ten != 0) {
					sum = longNode.next.val + 1;
                    //加上之后仍然有进位
					if (sum >= 10) {
						while (longNode.next != null) {
                            //再加上之后是否还有进位
							if ((sum = longNode.next.val + 1) >= 10) {
								longNode = longNode.next;
								size--;
								longNode.val = sum % 10;
							} else {
							    //没有进位了
								longNode.next.val += 1;
								break;
							}
						}
						if (size==1) {
						    //长链表被加完后还有进位，就再加一个链表
							longNode.next = new ListNode(1);
							return tmp;
						}
					} else {
					    //没有进位了
						longNode.next.val += 1;
					}
					return tmp;
				} else {
                    break;
                }
			}
			return tmp;
		}
	}

	public int getSize(ListNode l1) {
		int i = 0;
		while (l1 != null) {
			l1 = l1.next;
			i++;
		}
		return i;
	}

	public void show(ListNode n) {
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode o1 = new ListNode(9);
		ListNode o2 = new ListNode(8);
		ListNode o3 = new ListNode(7);
		ListNode o4 = new ListNode(9);
		l1.next = o1;
		o1.next = o2;
		o2.next = o3;
		o3.next = o4;
		// ListNode l2 = new ListNode(5);
		// ListNode m1 = new ListNode(6);
		// ListNode m2 = new ListNode(4);
		// l2.next = m1;
		// m1.next = m2;
		//ListNode t1 = new ListNode(5);
		ListNode t2 = new ListNode(9);
		AddTwoNumbers o = new AddTwoNumbers();
		ListNode re = o.addTwoNumbers(l1, t2);
		System.out.println(re);
		o.show(re);
	}
}
