import java.util.Deque;
import java.util.LinkedList;

/**
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
public class HomeWork1 {

    public static void main(String[] args) {
        // 这个 既可以作为 栈 也可以作为 队列
        /*
            栈:
               旧api                新api
            push(e)     -->     addFirst(e)
            pop()       -->     removeFirst()
            peek()      -->     peekFirst()
         */
        /*
            队列:
             add(e)     -->     addLast(e)
             offer(e)   -->     offerLast(e)
             remove()   -->     removeFirst()
             poll()     -->     pollFirst()
             element()  -->     getFirst()
             peek()     -->     peekFirst()
         */

        System.out.println((-1 % 8));

        Deque<String> deque = new LinkedList<String>();
        //原api
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size()>0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
        System.out.println("***********");
        // 新api
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

}
