import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 需要 思考
 *  1. 每次 递归的约束条件
 *  2. 如何 剪枝 优化效率
 */
public class Combine {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if ( k<0 ||n < k) return  res;
        List<Integer> list = new ArrayList<>();
        backStack(res, list, n, k, 1);
        return res;
    }

    private void backStack(List<List<Integer>> res, List<Integer> list, int n, int k,int begin) {
        // 结束条件
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        // 边界 这里 进行 剪枝(这里 关注...)  k-list.size() 还需要几个值
        for (int i =begin ; i <= n - (k-list.size()) +1  ; i++){
            list.add(i);
            // 下次 begin 从 i +1 开始
            backStack(res, list, n, k,i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
