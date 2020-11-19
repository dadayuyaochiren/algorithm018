/**
 *  最大子序和
 *      思路 : 贪心
 *          sum >0 继续往后求和
 *          sum <0 不继续往后求和 --- 一直比较 ans 与  sum 不断比较
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums){
            sum = sum > 0 ? sum+num : num;
            ans = Math.max(sum,ans);
        }
        return ans;
    }

}
