import java.util.Arrays;

/**
 * 分发饼干
*  思路贪心  注意 每个孩子 只能给一个~
 *          尽量 大饼干 满足 大孩子
 */
public class FindContentChildren {


    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        // 双指针 下标
        int i = g.length-1 , j = s.length-1;
        while (i >= 0 &&  j >= 0 ){
           if (s[j] >= g[i--]) {
               res++;
               j--;
           }
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1,1}));
    }

}
