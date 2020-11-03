import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Preorder {
    public List<Integer> preorder(Node root) {
        //定义返回的集合
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //双段队列更通用
        Stack<Node> stack = new Stack<>();
        // 先将root 入队
        stack.push(root);
        while(!stack.isEmpty()){
            // 根 -- >  左  -- > 右
            Node cur = stack.pop();
            // 结果集
            res.add(cur.val);
            // 子节点 栈 节点进入的顺序
            int size = cur.children.size();
            for( int i = size-1 ; i >=  0 ; i-- ) {
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}