# 《剑指offer》解题分析 #

## 1.二维数组中的查找 ##

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

解法一：双重for循环遍历：

    public class Solution {
    public boolean Find(int target, int [][] array) {
           for(int i=0;i<array.length;i++){
               for(int j=0;j<array[i].length;j++){
                   if(target == array[i][j]){
                       return true;
                   }
               }
           }
        return false;
        }
       }

解法二：剑指offer解法，二刷待续

2.替换空格

请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

    public class Solution {
    public String replaceSpace(StringBuffer str) {
         
        StringBuffer stra = new StringBuffer();
        for(int i=0;i<str.length();i++){
        if(str.charAt(i) == ' '){
            stra.append("%");
            stra.append("2");
            stra.append("0");
        }else{
            stra.append(str.charAt(i));
        }
        }
        return stra.toString();
    }
    }

本解法复杂度为O(n),个人感觉已经满足,不需要二刷。



3.从尾到头打印链表

输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

 `import java.util.ArrayList;`
    public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         
        if(listNode != null){
            this.printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }


    }

题目较简单，递归和非递归都比较简单，不计划二刷。

## 4.重建二叉树 ##

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

## 5.用两个栈实现队列 ##

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

## 6.旋转数组的最小数字 ##

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

    import java.util.ArrayList;
    public class Solution {
    public int minNumberInRotateArray(int [] array) {
          if(array.length==0){
              return 0;
          }else if(array.length==1){
                  return array[0];
              }else{
              for(int i=0;i<array.length-1;i++){
                  if(array[i]>array[i+1]){
                      return array[i+1];
                  }
              }
          }
               
           
       return 0;
    }
    }

7.斐波那契数列

8.跳台阶

9.变态跳台阶

10.矩形覆盖

11.二进制中1的个数

12.数值的整数次方

13.调整数组顺序使奇数位于偶数前面

## 14.链表中倒数第k个结点 ##

输入一个链表，输出该链表中倒数第k个结点。(剑指offer)
第一种解法：

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

## 15.反转链表 ##

输入一个链表，反转链表后，输出新链表的表头（剑指offer）

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

## 16.合并两个排序的链表 ##

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


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

17.树的子结构

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

18.二叉树的镜像

 `public class Solution {`
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

19.顺时针打印矩阵

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

    class Solution {
    public:
    vector<int> printMatrix(vector<vector<int> > matrix) {
        int row = matrix.size();//数组的行数
        int col = matrix[0].size();//数组的列数
        int start = 0;//打印的圈数
        vector<int> res;
        if(row == 0){
            return res;
        }
        while(col > start*2 && row > start*2){
            int endX = col - 1 - start;//最大列index
            int endY = row - 1 - start;//最大行index
            //从左往右打印
            for(int i=start;i<=endX;i++){
                res.push_back(matrix[start][i]);
            }
            //从上往下打印
            if(start < endY){
                for(int i=start+1;i<=endY;i++){
                    res.push_back(matrix[i][endX]);
                }
            }
            //从右往左打印
            if(start < endX && start < endY){
                for(int i=endX-1;i>=start;i--){
                    res.push_back(matrix[endY][i]);
                }
            }
            //从下往上打印
            if(start<endX && start<endY - 1){
                for(int i=endY -1;i>=start+1;i--){
                    res.push_back(matrix[i][start]);
                }
            }
            start++;
        }
        return res;
    }
    };

20.包含min函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。（剑指offer）

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

## 21.栈的压入、弹出序列 ##

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


## 22.从上往下打印二叉树 ##

从上往下打印二叉树(树的层次遍历，一半借用队列来实现)
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

## 23 	二叉搜索树的后序遍历序列 ##

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。


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

## 24 二叉树中和为某一值的路径 ##

输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

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

## 25 复杂链表的复制 ##

26 二叉搜索树与双向链表

27 字符串的排列

28 数组中出现次数超过一半的数字

29 最小的K个数

30 	连续子数组的最大和

HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

    import java.util.Arrays;
    import java.lang.Math;
    public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++){
            int sum = array[i];
            int max = array[i];
            for(int j=i+1;j<array.length;j++){
                sum += array[j];
                max = Math.max(max,sum);
            }
            arr[i] = max;
        }
        Arrays.sort(arr);
        return arr[array.length - 1];
    }
    }

31 整数中1出现的次数（从1到n整数中1出现的次数）

32 把数组排成最小的数

33 丑数

34 第一个只出现一次的字符位置

35 数组中的逆序对

36 两个链表的第一个公共结点

37 数字在排序数组中出现的次数

38 二叉树的深度

输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

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

## 39 平衡二叉树 ##

输入一棵二叉树，判断该二叉树是否是平衡二叉树。

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


40 数组中只出现一次的数字

41 和为S的连续正数序列

42 和为S的两个数字

43 左旋转字符串

44 翻转单词顺序列

45 扑克牌顺子

46 孩子们的游戏(圆圈中最后剩下的数)

47 求1+2+3+...+n

48 不用加减乘除做加法

49 把字符串转换成整数

50 数组中重复的数字

51 构建乘积数组

52 正则表达式匹配

53 表示数值的字符串

54 字符流中第一个不重复的字符

55 链表中环的入口结点

56 删除链表中重复的结点

57 二叉树的下一个结点

58 对称的二叉树

59 按之字形顺序打印二叉树

60 把二叉树打印成多行

## 61.	序列化二叉树 ##

请实现两个函数，分别用来序列化和反序列化二叉树

    /*
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    }
    */
    public class Solution {
    
    public int index = -1;
    //序列化：将一棵二叉树按照前序遍历转化为一个字符串，null用#代替
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();}

    //反序列化：按照序列化的字符串的顺序转化为一棵二叉树
    TreeNode Deserialize(String str) {
        index++;
        if(index >= str.length()){
            return null;
        }
        TreeNode node = null;
        String[] strr = str.split(",");
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
      }
    }

## 62 二叉搜索树的第k个结点 ##

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。


    import java.util.Queue;
    /*
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    }
    */
    public class Solution {
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            TreeNode temp = KthNode(pRoot.left,k);
            if(temp != null){
                return temp;
            }
            count++;
            if(count == k){
                return pRoot;
            }
            TreeNode node = KthNode(pRoot.right,k);
            if(node != null){
                return node;
            }
        }
        return null;
    }
    }


63 数据流中的中位数

64 滑动窗口的最大值

65 矩阵中的路径

66 矩阵中的路径