

/**
 *  买卖股票的最佳时机 II
 *  1. 回溯   思想: 列出所有的可能, 比较拿到所有可能下的最大值
 *  2. 动态规划   思想 : 不论是股票还是现金都是收益,比较每一天在不同选择后的收益, 一直迭代下去,最后输出
 *  3. 贪心算法  (利益最大化 ~~ 贪心是一种思想 )
 * 对于 「今天的股价 - 昨天的股价」，得到的结果有 3 种可能：① 正数，② 00，③负数。贪心算法的决策是： 正数买入,负数卖出
 *  每天的 股票价格
 *  [7,1,5,3,6,4]
 */
public class MaxProfit {

    private int res;

    public int maxProfit(int[] prices) {
        if ( prices.length < 2) {
            return 0;
        }
        //回溯
//        dfs(prices,0,0,0);

        int res =  0;
        //动态规划
        // 定义二维数组 存储每天不同选择的后果
        int[][] dp = new int[prices.length][2];
        //初始化   0 -卖出  1 -买出
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1 ; i < prices.length; i++){
            dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] =Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
        //贪心
//        for (int i = 1 ; i < prices.length; i++){
//            // 很有想象力的写法
//            res += Math.max(prices[i] - prices[i-1],0);
//        }
        //return res;

    }









    /**
     * 回溯算法
     * @param prices   每天的 股价
     * @param index      天数,从 0开始
     * @param status    是否持有股票 0 - 未持有   1- 持有
     * @param profit      当前收益
     */
    private void dfs(int[] prices, int index, int status, int profit) {
        // 需要全部跑一遍 故需要比较每次的 收益
        if (index == prices.length){
            // 最大的 收益
            this.res = Math.max(this.res,profit);
            return;
        }
        //剪枝
        dfs(prices,index+1,status, profit);
        // 细节 若0--> 1 买入  收益减少  1--->0 卖出  获得收益
        if (status==0)
            dfs(prices,index+1,1,profit-prices[index]);
        if (status==1)
            dfs(prices,index+1,0,profit+ prices[index]);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));


    }
}
