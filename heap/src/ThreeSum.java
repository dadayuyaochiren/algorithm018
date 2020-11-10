import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        // 排序
        Arrays.sort(nums);
        //一层循环 加 双指针下标
        for( int i=0 ; i < len ; i++ ) {
            if (nums[i] > 0) break; // 排完序之后, 第一个数大于零,三数之和大于零
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = len -1;
            while ( left < right) {
                int sum =nums[i] + nums[right] + nums[left];
                while(left < right && nums[left] == nums[left+1]) left++;  //去重
                while(left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }
        }
        return ans;
    }

}
