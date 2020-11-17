import java.util.*;

/**
 * 单词接龙
 *  双向 bfs 广度优先遍历
 *      优化 双向广度优先遍历
 *
 */
public class LadderLength {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先将wordlist 放到hash表中 便于取
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return 0;
        wordSet.remove(beginWord);

        // 核心 图的 广度优先遍历 1.(通用)使用队列暂存一层的数据 2.visited 已访问标志
        Queue<String> queue = new LinkedList<>();
        // 为了 迭代 先加上根元素
        queue.add(beginWord);
        // 建立visited
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        // 开始广度优先遍历
        while (!queue.isEmpty()){
            int curSize = queue.size();
            for (int i = 0 ; i < curSize ; i++ ) {
                //出队
                String curword = queue.poll();
                //入队子路径 ,已经入队的 放到visited中 无需入队
                if(changeOneWordMatch(curword,endWord,queue,visited,wordSet))
                    return step+1;
            }
            step++;
        }
        return 0;
    }


    /**
     *  图的bfs
     * @param curword
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private  static boolean changeOneWordMatch(String curword, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        // 每个字符分成 26组  桶思想
        char[] chars = curword.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            //先保存被转换的字符
            char origin  = chars[i];
            for (char k = 'a'; k <= 'z' ; k++ ){
                if (k == origin) continue;
                // 修改值
                chars[i] = k;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)){
                    // 等于结果 直接返回正确,无需入队
                    if (nextWord.equals(endWord) )
                        return true;
                    // 已经访问的不需要再入队
                    if (!visited.contains(nextWord)) {
                        // 入队
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            //恢复
            chars[i] = origin;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit", "cog", list));
    }
}
