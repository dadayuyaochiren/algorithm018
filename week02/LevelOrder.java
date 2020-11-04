import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树的 层序遍历
 */


public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        //队列
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            //定义每一层的 list
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            // 出节点 ,并入队节点所有字节点
            for(int i =0 ; i<size ; i++ ){
                Node cur = deque.removeFirst();
                level.add(cur.val);
                cur.children.forEach(e->{
                    deque.addLast(e);
                });
            }
            res.add(level);
        }
        return res;
    }
}
