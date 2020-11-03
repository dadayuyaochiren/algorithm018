import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *   map~
 *   特色: map中将 数组的值 作为 key 索引做为 value ,利用 containsKey()来命中
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 定义一个 map <数值,下标>
        Map<Integer,Integer> map = new HashMap<>();
        // 将第一个数放进去
        map.put(nums[0],0);
        for(int i = 1 ; i < nums.length ; i++){
            //map中将 数组的值 作为 key 索引做为 value ,利用 containsKey()来命中
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
