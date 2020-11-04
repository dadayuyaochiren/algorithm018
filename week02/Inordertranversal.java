import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

/**
 * 二叉树的中序遍历
 */

public class Inordertranversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 定义返回的 链表
        List<Integer> res = new ArrayList<>();
        // 递归
        //addNode(root,res);
        // 利用栈  来进行迭代
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()){
            // 左节点一直压栈
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            // 弹栈并检查右节点
            res.add(stack.pop().val);
            root = root.right;
        }
        return res;
    }


    //递归: 左 --> 根  --> 右
    void addNode(TreeNode node, List<Integer> res) {
        if (node == null) return;
        addNode(node.left,res);
        res.add(node.val);
        addNode(node.right,res);
    }

}
