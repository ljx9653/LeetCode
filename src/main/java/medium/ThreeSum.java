package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author lijx
 * @date 2018/9/27 - 17:25
 * 15. 三数之和
 * TODO
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3)
            return new ArrayList(1);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] < 0 && nums[j] < 0 && nums[k] < 0) {
                        continue;
                    }
                    if (nums[i] > 0 && nums[j] > 0 && nums[k] > 0) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tmpList = new ArrayList<Integer>(3);
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[k]);
                        if (!isRepeat(resultList, tmpList))
                            resultList.add(tmpList);
                    }
                }
            }
        }

        return resultList;
    }

    private boolean isRepeat(List<List<Integer>> mianList, List<Integer> compareList) {
        for (int i = 0; i < mianList.size(); i++) {
            List<Integer> tmp = mianList.get(i);
            int[] tmpArr={mianList.get(i).get(0),mianList.get(i).get(1),mianList.get(i).get(2)};
            List<int[]> ints = Arrays.asList(tmpArr);
            int count = 0;
            k:for (int j = 0; j < 3; j++) {
                if (ints.contains(compareList.get(j))) {
                    count++;
                    ints.remove(compareList.get(j));
                } else {
                    break k;
                }
            }
            if (count==3)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
