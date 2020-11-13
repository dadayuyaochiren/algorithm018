import java.rmi.activation.ActivationGroupID;

/**
 * 岛屿数量
 *      二维数组
 *  dfs  深度优先遍历
 *     思路 :  找到陆地后 开始dfs
 */

public class NumIslands {

    public static int numIslands(char[][] grid) {
        int res = 0;

        // 二维数组的遍历
        for (int j = 0 ;j < grid.length ; j++){
            for (int i = 0 ; i < grid[j].length ; i++){
                // 传入 此时的值 , 以及 res
                if (grid[j][i] == '1'){
                    dfs(grid,j,i);
                    res++;
                }

            }
        }
        return res ;
    }

    /**
     * 深度优先遍历  将连在一起的岛屿数量置为 0
     *         优化 : 感觉只要往 下和左即可
     * @param grid  二维数组
     * @param j      列位置
     * @param i      行位置
     */
    private  static void dfs(char[][] grid, int j, int i) {
        if ( i<0 || j <0 || j >= grid.length || i>= grid[j].length ||grid[j][i] == '0'){
            return;
        }
        // 清除连在一起的岛屿
        grid[j][i] = '0';
        //深度优先遍历
        dfs(grid,j+1,i);
        dfs(grid,j,i+1);
        dfs(grid,j-1,i);
        dfs(grid,j,i-1);

    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands(grid));

    }

}
