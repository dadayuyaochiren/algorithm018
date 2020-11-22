/**
 * 搜索二维数组
 *      二分法  查找效率较高
 *      思路 将二维数组 转化为 一维数组 来取数字
 */
public class SearchMatrix {


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 二维 转 一维
        int left = 0 ;
        int right = m * n -1 ;

        // 二分法
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (target == midValue) {
                return true;
            }else{
                if (target < midValue)
                    right = mid -1;
                else
                    left = mid +1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));

    }



}
