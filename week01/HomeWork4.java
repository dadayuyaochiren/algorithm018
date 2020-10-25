/**
 * 旋转数组
 */
public class HomeWork4 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        //记录交换次数
        int count = 0;
        for(int start = 0 ; count < len ; start++) {
            int cur = start;
            int pre = nums[cur] ;
            do {
                // 循环 常用索引计算方法
                int next  = (cur + k) % len;
                int temp = nums[next];
                nums[next] = pre ;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur) ;
        }
    }
}
