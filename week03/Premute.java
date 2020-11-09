import java.util.ArrayList;
import java.util.List;

/**
 *
 * 全组合
 *  回溯
 *  result = []
 *  def backtrack(路径, 选择列表):
 *  if 满足结束条件:
 *  result.add(路径)
 *  return

 *  for 选择 in 选择列表:
 *  做选择
 *  backtrack(路径, 选择列表)
 *  撤销选择
 *
 */
public class Premute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Premute premute = new Premute();
        List<List<Integer>> permute = premute.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }
}
