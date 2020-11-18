import java.util.HashSet;
import java.util.Set;

/**
 * 行走的机器人
 *  思路 方向 --> 转为数字
 *       行走 --> 转为二维数组
 *       障碍物 --> 一步一步走校验
 */
public class RobotSim {


    public int robotSim(int[] commands, int[][] obstacles) {
        // 行走指令   北  东  西 南
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        // 初始化 坐标位置
        int x = 0 , y = 0;
        // 初始化 方向
        int dir_index = 0;
        int res = 0;
        // 将障碍物整合为String  Set集合中
        Set<String> barriers = new HashSet<>();
        for (int i = 0; i<obstacles.length; i++) {
            barriers.add(obstacles[i][0]+","+obstacles[i][1]);
        }
        //根据一连串的指令开始 行走
        for (int i = 0; i < commands.length ; i++){
            if (commands[i] == -1)
                dir_index = (dir_index+1)%4;
            if (commands[i] == -2)
                dir_index = (dir_index+3)%4;
            if (commands[i] > 0) {
                //一步一步来走
                for (int j = 1 ; j <= commands[i] ; j++) {
                    // 下一步的位置
                    int next_x = x + dir[dir_index][0];
                    int next_y = y + dir[dir_index][1];
                    // 校验 障碍物
                    if (barriers.contains(next_x+","+next_y))
                        break;
                    x = next_x;
                    y = next_y;
                    res = Math.max(res,x*x+y*y);
                }
            }
        }
        return res;
    }
}
