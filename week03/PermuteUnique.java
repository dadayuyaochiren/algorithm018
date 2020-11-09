import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 2
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        // 这里必须排序
        Arrays.sort(nums);
        backStack(res,list,nums,new boolean[nums.length]);
        return res;
    }

    private void backStack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        // 选择列表
        for (int i = 0 ; i < nums.length ; i++){
            // 剪枝
            // 1. 同一个索引只用一次
            if (used[i]) continue;
            // 2. 连续两个值相同 跳过
            if ( i>0 && used[i-1] && nums[i] == nums[i-1]) break;
            //做出选择
            list.add(nums[i]);
            used[i] = true;
            backStack(res,list,nums,used);
            list.remove(list.size()-1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        PermuteUnique premute = new PermuteUnique();
        List<List<Integer>> permute = premute.permuteUnique(new int[]{1, 1, 3});
        System.out.println(permute);
    }

}
