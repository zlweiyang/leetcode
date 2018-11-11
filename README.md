# leetcode
#leetcode
#剑指offer
#各大公司笔试题

坚持每天两道题，按照标签来


本仓库主要用笔试刷题，主要用于提升自身的编程能力。在自己思考的基础之上融入高手们的编程思想，做好详细记录。


This repository mainly uses brush test questions, mainly used to improve its programming ability. Incorporate the programming ideas of the masters on the basis of their own thinking, and make detailed records.


增加一个文件夹leetcode，用于记录数据结构与算法相关的完成代码。主要分为Array，链表，栈，队列，二叉树，图，排序，递归，贪心，分治，动态规划，回溯。

# 数组 #
数组是一种线性表数据结构，用一组**连续的内存空间**来存储一组具有**相同类型**的数据。其最大特点是支持随机访问，但删除，插入操作低效。
数组在定义时需要预先指定大小，因为需要分配连续的内存空间。
Java中的ArrayList支持动态扩容，当存储空间不够时，其空间自动扩容为1.5倍大小。
## 数组的基本操作 ##
- Insert--在指定索引插入一个元素
- Get--返回指定索引的元素
- Delete--删除指定索引位置的元素
- Size--数组所有元素的数量
## 数组常见问题 ##
- 寻找数组中的第二小的元素
- 找到数组中第一个不重复出现的整数
- 合并两个有序数组
- 重新排列数组中的正值和负值
- 连续子数组的和
- 顺时针打印矩阵

# 链表 #
链表包括单链表、双向链表以及循环链表
## 链表的基本操作 ##
- InsertAtEnd 在链表的尾部插入指定元素
- InsertAtHead 在链表的头部插入指定元素
- Delete 从链表删除指定元素
- DeleteAtHead 删除链表的第一个元素
- Search 从链表中返回指定元素
- isEmpty 如果链表为空，则返回true
## 链表常见问题 ##
- **1.反转链表**

**输入一个链表，反转链表后，输出新链表的表头（剑指offer）
**

    class Solution {
    public:
    ListNode* ReverseList(ListNode* pHead) {
        ListNode* root = NULL;//设定新的表头
        ListNode* nextnode;//保存下一个反转的结点
        if(pHead == NULL || pHead->next == NULL){
            return pHead;//临界值判断
        }
        while(pHead != NULL){//遍历链表
            nextnode = pHead->next;//保存下一个结点
            pHead->next = root;//将指针反向
            root = pHead;//将反转后的结点作为新的表头赋值给root，root变为新的表头
            pHead = nextnode;//开始新的结点反转
        }
        return root;
    }
    };
    
-** 2.检查链表中的循环**
**给定一个链表，判断链表中是否有环**
总体思路就是快指针总能超过慢指针
    public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast,slow;
        fast = head;
        slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    }

- **3.返回链表中倒数第N个节点**

**输入一个链表，输出该链表中倒数第k个结点。(剑指offer)
第一种解法：**

    import java.util.*;
    public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        
        Stack<ListNode> stack = new Stack<ListNode>();
        if(head == null || k < 1){
            return null;
        }
    
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        if(stack.isEmpty()){
            return null;
        }
      return stack.pop();
    }
    }
第二种解法：效率高

    class Solution {
    public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
    
    ListNode* temp = pListHead;
    int count = 0;
    if(pListHead == NULL){
    return NULL;
    }
    while(temp != NULL){
    count++;
    temp = temp->next;
    }
    if(count < k){
    return NULL;
    }
    ListNode* res = pListHead;
    for(int i=0;i<count - k;i++){
    res = res->next;
    }
    return res;
       
    }
    };
第三种解法：按道理说第三种解法效果应该最好，但是实际运行却不是
    public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
    
    ListNode temp = head;
    if(head == null || k < 1){
    return null;
    }
    for(int i=0;i<k-1;i++){
    if(temp == null){
    return null;
    }
    temp = temp.next;
    }
    if(temp == null){
    return null;
    }
       
    while(temp.next != null){
    temp = temp.next;
    head = head.next;
    }
    return head;
    }
    }

- **4.删除链表中的重复项**

-**5合并两个排序的链表**

**输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。**


    public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list3 = null;//新建一个结点用于保存合并的链表
        //递归停止条件
        if(list1 == null || list2 == null){
            if(list1 == null){
                return list2;
            }
            else if(list2 == null){
                return list1;
            }else{
                return null;
            }
        }
        if(list1.val < list2.val){
            list3 = list1;//依次保存较小的结点
            list3.next = Merge(list1.next,list2);递归遍历链表
        }else{
            list3 = list2;//依次保存较小的结点
            list3.next = Merge(list1,list2.next);
        }
        return list3;        
    }
    }

# 栈 #
LIFO(后进先出)
## 栈的基本操作 ##
- Push 在栈顶插入一个元素
- Pop 返回并移除栈顶元素
- isEmpty 若栈为空，则返回true
- Top 返回顶部元素，但并不移除
## 栈常见问题 ##
- 1.使用栈计算后缀表达式
- 2.对栈元素进行排序
- 3.判断表达式是否括号平衡
- **4.包含min函数的栈**

**定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。（剑指offer）**

    import java.util.Stack;
    
    public class Solution {
    
    Stack<Integer> stack = new Stack<Integer>();//先将元素存入栈中
    Stack<Integer> stack2 = new Stack<Integer>();//在将stack中的元素一次pop出进行比较后，存入stack2，然后再将stack2的元素存入stack
    public void push(int node) {
        stack.push(node);
    }
    
    public void pop() {
        if(!stack.empty()){
           stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        int min = Integer.MAX_VALUE;//默认最小值
        while(!stack.empty()){
            int temp = stack.pop();
            if(temp<min){
                min = temp;//始终保存最小值
            }
            stack2.push(temp);//将pop出的值存入stack2
        }
        while(!stack2.empty())
        {
            stack.push(stack2.pop());//将所有的元素重新存入stack
        }        
        return min;
    }


    }
**-5 栈的压入和弹出**

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

    import java.util.ArrayList;
    import java.util.Stack;
    public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length){
            //判断边界条件
            return false;
        }
      Stack<Integer> stack = new Stack<Integer>();//建立一个辅助栈用于压入pushA，以及操作pushA的pop
      int pushindex = 0;
      int popindex = 0;  
      stack.push(pushA[pushindex]);//将第一个元素压入栈
      while(popindex < popA.length){
          while(stack.peek()!= popA[popindex]){//判断栈顶元素是否等于序列当前元素
              if(pushindex == pushA.length-1){//，如果不等先判断是否所有元素已经压入stack中，如果压入则返回false
                  return false;
              }
              stack.push(pushA[++pushindex]);//否则继续向栈中压入元素
          }
          stack.pop();//；如果栈顶元素与popA序列当前位置元素相等则弹出该元素
          popindex++;//popA序列继续向后移动
      }
        return stack.empty();//
    }
    }

# 队列 #
FIFO(先进先出)
## 队列的基本操作 ##
- Enqueue 在队列尾部插入元素
- Dequeue 在移除队列头部的元素
- isEmpty 如果队列为空则返回true
- Top 返回队列第一个元素
## 队列常见问题 ##
- 1.使用队列表示栈
- 2.对队列的前K个元素倒序
- 3.使用队列生成1~n的二进制数
- **4.用两个栈实现队列**

**用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。**

    import java.util.Stack;

    public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    //基本思想是stack1始终存储倒序队列，stack2则通过栈的pop进行反转
    public void push(int node) {
         //在stack1入栈时，必须将stack2中的元素全部返回stack1，保证所有元素倒序存储在stack1中
         while(!stack2.empty()){
           stack1.push(stack2.pop());
        }
        stack1.push(node);//stack1新元素入栈
        //stack2.push(stack1.pop());
    }
    
    public int pop() {
        //将stack1中所有元素反转存入Stack2中，那么stack2中的元素就是正序的
        while(!stack1.empty()){
        stack2.push(stack1.pop());
        }
        //返回stack2的栈顶元素即为队列的队头
       return stack2.pop()；
    }
    }

    
# 树 #
树形结构是一种层次式的数据结构，由顶点和边组成，但不存在回路

## 树形结构的主要类型包括 ##
- N元树
- 平衡树

**-平衡二叉树**

**输入一棵二叉树，判断该二叉树是否是平衡二叉树。**

    public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
       if(root == null){
           return true;
       }
       if(Math.abs(CalTreeDepth(root.left) - CalTreeDepth(root.right))>1){
           return false;
       }
       return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        
    }
    public int CalTreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(CalTreeDepth(root.left),CalTreeDepth(root.right)) + 1;
        
    }
    }




高度差小于1

- 二叉树
- 二叉搜索树
- 
**二叉搜索树的后序遍历**
**输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。**


//二叉搜索树即左子树的结点总小于根节点，右子树的结点总大于根节点

    public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return IsBST(sequence,0,sequence.length-1);
    }
    //基本思想有点类似分治，数组最后一位元素是根节点，将左边的数或者右边的数与根节点进行比较
    public boolean IsBST(int[] sequence,int start,int end){
        //当左右分段中有遍历结束时，递归结束，返回true
        if(start >= end){
            return true;
        }
        //从起始点开始查找比根节点大的元素
        int i = start;
        while(sequence[i]<sequence[end]){
            i++;
        }
        //由于右子树都应该比根节点大，所以如果出现小于的根节点的数那么就不是二叉搜索树。
        for(int j=i;j<end;j++){
            if(sequence[j] < sequence[end]){
                return false;
            }
        }
        //递归遍历所有数据分左右两边进行分治，树的递归一般是二分递归。
        return  IsBST(sequence,start,i-1)&&IsBST(sequence,i,end-1);
        
    }
    }

左小右大。

- AVL树
- 红黑树
- 2-3树
- 哈夫曼树

特点：1.没有度为1的结点，2.n个叶子结点的哈夫曼树共有2*n-1个结点。3.左右子树交换后依然是哈夫曼树。WPL相同的两可树为同构哈夫曼树。

## 树常见问题 ##
-** 1.求二叉树的深度**
**输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。**

    public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftdepth = TreeDepth(root.left) ;//遍历左子树得到左子树的深度
        int rightdepth = TreeDepth(root.right) ;//遍历右子树得到右子树
        
        return Math.max(leftdepth,rightdepth)+1;
    }
    }

**- 2.树的子结构**

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

    public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //如果root1为空，root2为空时无子结构
        if(root2 == null || root1 == null){
            return false;
        }
        //设置标记，初始为false
        boolean res = false;
        //遍历root1指导root1.val==root2.val
        //当root1.val==root2.val时继续遍历子树
        if(root1.val == root2.val){
            res = isSubTree(root1,root2);
        }
        //如果之前相结点不相等的，继续递归遍历root1的左右子树
        if(!res){
            res = HasSubtree(root1.left,root2);
            if(!res){
                res = HasSubtree(root1.right,root2);
            }
        }
        return res;
    }
  //判断当找到root1.val == root2.val时，判断子树结点是否一一相等，知道root2为空
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        
        if(root2==null){
            return true;
        }
        if(root1==null && root2!=null){
            return false;
        }
        //递归遍历
        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }else{
            return false;
        }
    }
    }
**-3.镜像二叉树**
    public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }
         TreeNode temp;
         temp = root.left;
         root.left = root.right;
         root.right = temp;
         if(root.left != null){
             Mirror(root.left);
         }
         if(root.right != null){
             Mirror(root.right);
         }
    }
    }
    
- 在二叉搜索树中查找第k个最大值
- 查找与根节点距离K的节点
- 在二叉树中查找给定节点的祖先节点
- 
**- 5.重建二叉树**

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

根据先序遍历的顺序查找中序遍历的元素，将树分治为左右子树，逐步递归。

    public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode helper(int [] pre,int prestart ,int preend,int [] in,int instart,int inend){
        
        if(prestart > preend || instart > inend){
            return null;//递归结束条件
        }
        TreeNode root = new TreeNode(pre[prestart]);
        for(int i=instart;i<=inend;i++){
            if(in[i] == pre[prestart]){
            root.left = helper(pre,prestart+1,prestart+i-instart,in,instart,i-1);//左子树递归
            root.right = helper(pre,prestart+i-instart+1,preend,in,i+1,inend);//右子树递归
            }
        }
        return root;
    }
    }
-** 6从上往下打印二叉树(树的层次遍历，一半借用队列来实现)**
**从上往下打印出二叉树的每个节点，同层节点从左至右打印。**

    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;
    public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
       ArrayList<Integer> res = new ArrayList<Integer>();
       //树的层次遍历一般借助队列来实现，队列一般来存储上一层的结点，并以二分的形式实现树的遍历，其主要是队列中的结点即为下一层结点的root
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       if(root == null){
           return res;
       }
       queue.offer(root);//保存第一层的root
       while(!queue.isEmpty()){
           TreeNode temp = queue.poll();//将本层的结点一一出队
           res.add(temp.val);//打印按序出队的结点值
           //以二分的形式遍历子树，因为由于队列的出队操作，使得根节点在不断变化，所以可以一直访问不同root的左右孩子，这种思想类似递归的思想
           递归一般需要一个停止条件，但是这个题目中没有递归停止条件，认为的通过判断队列是否为空来判断，这种思想类似树的前序、中序、后序遍历的非递归实现方式。
           if(temp.left != null){
               queue.offer(temp.left);
           }
           if(temp.right != null){
               queue.offer(temp.right);
           }
       }
       return res;
    }
    }

**-7.二叉树的和为某一值的路**

**输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)**

    public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> temp = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return res;
        }
        temp.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(temp));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        temp.remove(temp.size()-1);
        return res;
    }
    }

## 堆 ##
堆也称为优先队列，堆必须是完全二叉树。
## 最大堆常见操作 ##
- MaxheapCreate 创建一个空的最大堆
- IsFull 判断最大堆是否已满
- Insert 将元素item插入最大堆
- IsEmpty 判断最大堆H是否为空
- DeleteMax 返回最大元素

## 字典树 ##
字典树，也称为前缀树，对于解决字符串问题非常有效。
## 字典树常见问题 ##
- 计算字典树中的总单词树
- 打印存储在字典树中的所有单词
- 使用字典树对数组的元素进行排序
- 使用字典树从字典中形成单词
- 构建T9字典（字典树 + DFS）

# 图 #
图是一组以网络形式相互连接的节点。节点也称为顶点，顶点之间的线称为边。
包含有向图和无向图

## 图的表示方式 ##
- 邻接表
- 邻接矩阵

## 常见图遍历算法 ##
- 广度优先搜索(BFS)

类似于树的层次遍历，使用队列来存储遍历过的顶点，判断弹出的顶点的每个顶点是否被遍历，如果没有遍历，则遍历后存入队列。

时间复杂度与深度优先遍历相同。

- 深度优先搜索(DFS)

类似于于树的先序遍历

定义一个标记数组，判断邻接点是否被遍历？分别判断与当前邻接点相连的接点是否被遍历。

N个顶点，E条边的时间复杂度：1.用邻接表存储图，有O(N+E)2.邻接矩阵存储图O(N^2)。

## 图常见问题 ##
- 实现广度和深度优先搜索
- 检查图是否为树
- 计算图的边数
- 找到两个顶点之间的最短路径

# 哈希表 #
对象以键值对形式存储，存在唯一索引
哈希表通常使用数组实现

## 哈希表常见问题 ##
- 在数组中查找对称键值对
- 追踪遍历完整路径
- 查找数组是否是另一个数组的子集
- 检查给定数组是否相交

# 排序算法 #
知识点来源《算法》、《数据结构与算法之美--极客时间王争》

常见排序算法：
时间复杂度(O(n^2)):冒泡排序、插入排序、选择排序;

时间复杂度(O(nlogn):希尔排序、归并排序、快速排序;

时间复杂度(O(n)):计数排序、基数排序、桶排序。不进行比较。

**问题1：插入排序与冒泡排序时间复杂度相同，为什么更倾向于插入排序。**

代码实现时，冒泡数据移动需要3k时间单位，插入只需要K时间单位，插入排序时间更少。

分析一个排序算法的三个方面：

1.算法执行效率(时间复杂度、时间复杂度的系数，常数，比较次数)。

2.内存消耗(空间复杂度，前三种为原地排序算法)。

3.排序算法的稳定性(相同数字排序前后位置不变，为稳定)。

## 1.冒泡排序 ##

冒泡排序只涉及相邻数据的交换操作，是一个原地操作，不改变两个相同元素的位置，所以是**稳定算法**。时间复杂度：最好为一次冒泡O(n)，最坏为倒序O(n^2)。

    public static void BubbleSort(int [] arr){
         boolean flag = false;//优化冒泡排序算法，如果不发生交换则停止冒泡
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    Sort.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if(!flag){
                break;//已排好序，提前退出
            }
        }
    }

## 2.插入排序 ##

插入排序的核心思想，去未排序区间的元素，在已经排序的区间找到合适位置将其插入。
插入排序是原地算法，可以保持**稳定性**，时间复杂度：最好(O(n)),最坏O(n^2),平均时间复杂度O(n^2)。

  public static void InsertSort(int[] arr){

        //初始的第一个元素已经排序，所以从下标为元素开始
        for(int i=1;i<arr.length;i++){
            int value = arr[i];//取每一个未排序元素并用value保存
            int j = i-1;
            for(;j>=0;j--){//从已排序的最后一个元素开始比较
                if(value < arr[j]){
                    arr[j+1] = arr[j];//向后移动数据
                }else{
                    break;//找到插入位置，跳出循环
                }
            }
            arr[j+1] = value;
        }
    }

## 3.选择排序 ##

选择排序也分为已排序区间和为排序区间，但选择排序每次会从未排序找到最小元素，将其排序放在已排序最后。不稳定。

 public static void SelectSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int minindex = i;//每趟遍历之前最小值下标记性保存
            int j = i+1;//在后面未排序中查找最小的
            for(;j<arr.length;j++){
                if(arr[j] < arr[minindex]){
                    minindex = j;//记录最小值下标
                }
            }
            Sort.swap(arr,i,j);
        }
    }

## 4.希尔排序 ##

希尔排序是插入排序的优化，第一批冲出时间复杂度为O(n^2)的排序算法，最好时间复杂度为O(n),平均和最坏时间复杂度为O(nlogn)。

   public static void ShellSort(int[] arr){

        int i,j,gap;
        for (gap = arr.length/2;gap>0;gap/=2){
            for(i=gap;i<arr.length;i++){
                for(j = i-gap;j>=0 && arr[j] > arr[j+gap];j -= gap){
                    Test.swap(arr,j,j+gap);
                }
            }
        }
    }

归并排序和快速排序都借助了分治的思想。

**问题2：如何在O(n)时间复杂度找出无序数组中第K大元素？**

## 5.归并排序 ##
归并排序的核心思想就是在数组从中间分成前后两部分，然后再将前后两部分进行分别排序，最后将两部分合并，即分而治之。将一个大问题分解为小问题，先解决小问题，那么大问题就是解决了。分治是一种思想，而递归是一种编程技巧，分治就是通过递归来实现的。

写递归代码的技巧就是，分析得出递推公式，找到终止条件，最后将递推公式翻译成代码。

归并排序**是稳定的**，时间复杂度是最好、最坏、平均都是O(nlogn),由于在合并时，需要临时数组，所以归并排序**不是原地排序算法**，空间复杂度为O(n)。


<div align="center"> <img src="mergesort.jpg" width="450"/> </div><br>

合并图解

<div align="center"> <img src="merge.jpg" width="450"/> </div><br>
/*********************************************************************/

    //归并算法start
    public static void mergeSort(int[] arr){
        //调用一个递归辅助函数
        mergeSorthelper(arr,0,arr.length-1);
    }

    //递归分而辅助函数
    public static void mergeSorthelper(int[] arr,int left,int right){
        //首先指定递归终止条件
        if (left >= right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSorthelper(arr,left,mid);
        mergeSorthelper(arr,mid+1,right);

        merge(arr,left,mid,right);
    }
    //定义治之合并函数
    public static void merge(int[]arr,int left,int mid,int right){
        int i = left;//左半部起点
        int j = mid+1;//右半部起点
        int k = 0;//初始变量用于临时数组下标
        int[] temp = new int[right-left+1];
        //将两部分元素进行比较
        while(i<=mid && j<=right){
            //等号保证稳定性
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        //退出while循环，查看那部分还有剩余元素，假定左半部分有
        int start = i;
        int end = mid;
        //如果是右半部分有则更新起止元素
        if(j <= right){
            start = j;
            end = right;
        }

        //将剩余元素放入临时数组等号不可忽略
        while (start <= end){
            temp[k++] = arr[start++];
        }
        //将临时数组中的元素返回给原数组arr，因为初始right = arr.length-1，所以必须加入等号
        for(i=0;i<=right - left;i++){
            //这里犯了一个小错误,必须为left+i，因为随着递归的进行右半部分并不全是是从0开始
            arr[left + i] = temp[i];
        }
    }

    //归并算法end
   /************************************************************************************/

## 6.快速排序 ##

核心思想：确定一个基准(第一个和最后一个最常用，我这里采用最后一个最为基准pivot)。找到基准之后进行分片，前半部分小于这个基准，后半部分大于这个基准，然后按照这个思想继续递归。递归终止条件为数据无法继续分片，找基准点需要通过设置前后哨兵来进行。

快速排序是一种原地(原本需要两个临时数组，但是经过巧妙设计分区点则可以是原地排序)，**不稳定的排序算法**，时间复杂度：最好是O(nlogn),平均为O(nlogn),极端情况下会退化为O(n^2)。



**归并排序和快速排序的区别**

<div align="center"> <img src="diff_mergequick.jpg" width="450"/> </div><br>

归并排序的空间时间复杂度是O(n),且不是原地排序算法，且快速排序时间复杂度退化为O(n^2)。所以常用快速排序。

//快速排序start
   /**********************************************************/

    public static void quickSort(int[] arr){
       quickSorthelper(arr,0,arr.length-1);
     }

 

    public static void quickSorthelper(int[]arr,int left,int right){
       if(left >= right){
           return;
       }
        int p = partition(arr,left,right);//得到分区点
        quickSorthelper(arr,left,p-1);//左半部分递归
        quickSorthelper(arr,p+1,right);
    }
    //定义分片函数partiiton
    public static int partition(int[]arr,int left,int right){
        int i = left ;//左哨兵
        int j = right;//右哨兵
        int pvoit = arr[right];//选择最后的元素为基准

        //这种找分片点的方法不太好
        for(int j = left;j<right;j++){
           if(arr[j] < pvoit) {
             Sort.swap(arr, i, j);
                i++;
           }
       }
        Sort.swap(arr,i,right);
      return i;
        //这样更加容易看懂
        while (i != j){
            if(arr[i] < pvoit){
                i++;
            }
            else if(arr[j] > pvoit){
                j--;
            }else {
                 Sort.swap(arr,i,j);
                 i++;
            }
        }
        Sort.swap(arr,i,right);
        return i;
    }

   /**************************************************************/

7.桶排序

8.计数排序

9.基数排序

# 字符串 #
# 动态规划 #
# 分治 #
# 贪心 #
# 递归 #
# 海量数据案例 #