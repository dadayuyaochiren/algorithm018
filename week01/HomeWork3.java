/**
 *  删除排序数组中的重复项
 */
public class HomeWork3 {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 1 ;i < nums.length; i++){
            if(nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

}
