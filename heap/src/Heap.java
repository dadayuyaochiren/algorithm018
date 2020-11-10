import javax.management.MXBean;
import java.sql.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 先实现一个 大顶堆
 */
public class Heap {

    private int[] a;     // 数组实现, 为了满足节点之间的计算公式, 从下标1 开始计数.
    private int size;    // 堆的 大小
    private int count;   //堆已经存储的数据个数 ,指针下标

    // 构造器
    public Heap(int capacity) {
        this.a = new int[capacity+1];
        this.size = capacity;
        this.count = 0 ;
    }

    /**
     * 插入堆顶元素
     *  原理: 直接放在最后,与父节点比较,大于父节点进行交换,重复该过程即可
     */
    public boolean add(int data){
        if (count >= size)
            return false;  // 暂时满了 无法再插入
        a[++count] = data;      // 第一步,给数组往后一位赋值
        // 交换 子节点与 父节点
        swapParent(count,count/2, a);
        return true;
    }

    /**
     * 子与父节点交换值   ps: 父节点肯定比之前的子节点大,故交换后,不需要与另一子节点比较
     * @param son    子节点索引
     * @param father        父节点索引
     * @param a        交换时的数组
     */
    private void swapParent(int son, int father, int[] a) {
        // 终止条件
        if (a[father] > a[son] || son ==1 ) return;
        swap(father,son,a);
        // 不断往上堆化
        swapParent(father , father/2,a);
    }


    /**
     * 查看 第一个数
     * @return
     */
    public int peek(){
        if (count==0) return -1;
        return a[1];
    }

    /**
     * 移除 第一个子节点
     *  思路将最后一个子节点,换到a[1],再往下与子节点中较大的 进行交换
     * @return
     */
    public int remove(){
        if (count==0)
           return  -1;
        int res = a[1];
        //给现在头索引赋值
        a[1] = a[count--];
        int father = 1;
        swapChildren(father,2*father,a);
        return  res;
    }

    private void swapChildren(int father, int son, int[] a) {
        if (son > count)  return;
        // 左右两个节点 找一些大一点
        int bigNode = 0;
        if (son == count)  bigNode = a[son];
        if (son < count)   bigNode = Math.max(a[son],a[son+1]);
        if (bigNode < a[father])    return;
        // 子节点索引 重新赋值
        if (bigNode != a[son]) son = son + 1 ;
        //交换父子 节点
        swap(father,son,a);
        swapChildren(son , 2*son,a);
    }

    /**
     * 交换 父子节点
     * @param father
     * @param son
     * @param a
     */
    private void swap(int father, int son, int[] a) {
        int temp = a[father];
        a[father] = a[son];
        a[son] = temp;
    }

    /**
     * 堆是否空
     */
    private boolean isEmpty(){
        return  count == 0;
    }

    private boolean isFull(){
        return count == size;
    }


    public static void main(String[] args) {
        Heap h =new Heap(6);
        h.add(1);
        System.out.println(h.remove());
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(6);
        h.add(6);
        System.out.println(h.peek());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
//        System.out.println(h.remove());
    }
}
