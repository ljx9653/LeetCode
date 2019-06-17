package hard;

import java.util.Arrays;

/**
 * 4.寻找两个有序数组的中位数
 */
public class FindMediumSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] reArray=combineArrays(nums1,nums2);
		double re;
		int length=reArray.length;
		if(length%2==1){
			re=reArray[length/2];
		}else{
			re=reArray[length/2]+reArray[length/2-1];
			re=re/2.0;
		}
		return re;
	}
	
	public int[]  combineArrays(int[] array1, int[] array2){
		if(array1==null){
			return array2;
		}
		if(array2==null){
			return array1;
		}
		int[] joinedArray = new int[array1.length + array2.length];
		System.arraycopy(array1,0,joinedArray,0,array1.length);
		System.arraycopy(array2,0,joinedArray,array1.length,array2.length);
		Arrays.sort(joinedArray);
		return joinedArray;
	}

	public void showArray(int[] ll){
		for(int v:ll){
			System.out.println(v);
		}
	}
	
	public static void main(String[] args) {
		FindMediumSortedArrays o=new FindMediumSortedArrays();
		int []nums1 = {1,2};
		int []nums2 = {3,4};
		int[] ll=o.combineArrays(nums2, nums1);
		System.out.println("长度："+ll.length);
		o.showArray(ll);
		System.out.println(o.findMedianSortedArrays(nums1, nums2));
	}

}
