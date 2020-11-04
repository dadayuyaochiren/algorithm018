import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树 前序遍历
 *  迭代 需要理解 前序
 */

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //递归
        //addNode(root,res);
        //建立栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //先出根
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }

        return res;
    }

    // 根 --> 左 --> 右
     void addNode(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        addNode(root.left,res);
        addNode(root.right,res);
    }


}
