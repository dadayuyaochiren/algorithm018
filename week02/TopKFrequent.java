import java.util.*;

/**
 * 前k个高频元素
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // 放入map中 key --> 具体的数
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        // 优先队列 重写比较器
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();  // 降序
            }
        });
        //全部放入
        entries.forEach(e->{
            pq.add(e);
        });
        //输出 前k个
        for (int i =0 ;i < k; i ++){
            res[i] = pq.remove().getKey();
        }
        return res;
    }

}
