import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 */
public class HomeWork7 {
    public int[] twoSum(int[] nums, int target) {
        // map临时存储
        Map<Integer,Integer> hashs = new HashMap<>();
        hashs.put(nums[0],0);
        for(int i =1 ;i<nums.length ; i++){
            //特色: map中将 数组的值 作为 key 索引做为 value ,利用 containsKey()来命中
            if(hashs.containsKey(target-nums[i])){
                return new int[]{hashs.get(target-nums[i]),i};
            }
            hashs.put(nums[i],i);
        }
        return null;
    }
}
