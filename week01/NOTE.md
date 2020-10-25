学习笔记
PriorityQueue 总结
1.通过数组存储的小顶堆实现 (完全二叉树)
2.存入的对象要实现comparator 接口

父子节点的 关系为:
leftNo = parentNo*2 + 1;
rightNo = parentNo*2 + 2;
parentNo = (nodeNo - 1)/2 ;

//add()数据时,如何保持小顶堆
private void siftUp(int k, E x) {
    while (k > 0) {
        //parentNo = (nodeNo-1)/2
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        //调用比较器的比较方法
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}

//remove() 数据时,保持结构
private void siftDown(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        //首先找到左右孩子中较小的那个，记录到c里，并用child记录其下标
        int child = (k << 1) + 1;//leftNo = parentNo*2+1
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;//然后用c取代原来的值
        k = child;
    }
    queue[k] = x;
}



