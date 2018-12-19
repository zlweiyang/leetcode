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

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39

    public class Solution {
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
         else if(n==1||n==2){
             return 1;
         }else{
             int result = Fibonacci(n-1)+Fibonacci(n-2);
             return result;
         }
        //return 0;
    }
    }

递归最简单实现，不过据说华为面试问过，不准备二刷。

8.跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

    public class Solution {
    public int JumpFloor(int target) {
            if(target==1){
                return 1;
            }else if(target==2){
                return 2;
            }else{
                return JumpFloor(target-1)+JumpFloor(target-2);
            }
         
    }
    }
动态规划简单题，针对常见动态规划问题应该进行总结。

## 9.变态跳台阶 ##

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

    public class Solution {
    public int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else{
            return 1<<(target-1);
        }
    }
    }
进阶动态规划问题。

10.矩形覆盖

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

    public class Solution {
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        else if(target == 1){
            return 1;
        }
        else if(target == 2){
            return 2;
        }else{
            return RectCover(target-1)+ RectCover(target-2);
        }
 
    }
    }

11.二进制中1的个数

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

    public class Solution {
    public int NumberOf1(int n) {
        char [] num = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for(int i = 0;i<num.length;i++){
            if(num[i] == '1'){
                count++;
            }
        }
        return count;
 
    }
    }



12.数值的整数次方

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

    public class Solution {
    public double Power(double base, int exponent) {
        double result = 1;
        if(exponent > 0){
        for(int i = 0;i<exponent;i++){
            result = base *result;
        }
        }else{
            for(int j = 0;j<(-exponent);j++){
                result = base *result;
            }
            result = 1/result;
        }
        return result;
      }
    }


13.调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public class Solution {
    public void reOrderArray(int [] array) {
        for(int i = 0;i<array.length;i++){
            for(int j = array.length-1;j>i;j--){
                if(array[j]%2==1 && array[j-1]%2==0){
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                     
                }
            }
                 
        }
         
    }
    }


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

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。


    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    }
    
    public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);//递归遍历左子树
        TreeNode temp = left;//为最左的结点定义一个副本temp，left可以作为双向链表的头结点
        while(temp !=null && temp.right != null){
            temp = temp.right;
        }
        if(left != null){
            pRootOfTree.left = temp;
            temp.right = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null? pRootOfTree:left;
    }
    }


27 字符串的排列

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    public class Solution {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.Permutation("abc").toString());
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    public void PermutationHelper(char[]cs,int i,List<String> list){
        if(i == cs.length - 1){
            String temp = String.valueOf(cs);
            if(!list.contains(temp)){
                list.add(temp);
            }
        }else{
            for(int j=i;j < cs.length;j++){
                swap(cs,i,j);
                PermutationHelper(cs,i+1,list);
                swap(cs,i,j);
            }
        }
    }
    public void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    }

思路没看太懂！！！！！

28 数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

    import java.util.Map;
    import java.util.HashMap;
    public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            Integer value = map.get(array[i]);
            map.put(array[i],(value == null? 0:value)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
    }

29 最小的K个数

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

    import java.util.*;
    
    public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k > input.length){
            return result;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        
        return result;
    }
    }

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

求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

    public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = 1;i<=n;i++){
            String str = String.valueOf(i);
            char []  ch = str.toCharArray();
            for(int j = 0;j<ch.length;j++){
                if(ch[j] == '1'){
                    count++;
                }
            }
        }
        
        return count;
    
    }
    }

32 把数组排成最小的数

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Comparator;
    
    public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String res = "";
        String[] str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }
        //将str数组中的数字按照一定规律排列，其排列规则为mn<nm则等m，最终得到一个排序列表
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String s1,String s2){
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i=0;i<numbers.length;i++){
            res = res + str[i];
        }
        return res;
    }
    }

33 丑数

把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

    import java.util.ArrayList;
    //import java.lang.Math;
    public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <=0){
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        int r2 = 0,r3 = 0,r5 = 0;
        for(int i=1;i<index;i++){
            res[i] = min(res[r2]*2,res[r3]*3,res[r5]*5);
            if(res[i] == res[r2]*2)r2++;
            if(res[i] == res[r3]*3)r3++;
            if(res[i] == res[r5]*5)r5++;
        }
        return res[index-1];
    }
    private int min(int a,int b,int c){
        int min = a;
        if(b<min){
            min = b;
        }
        if(c<min){
            min = c;
        }
        return min;
    }
    }

34 第一个只出现一次的字符位置

在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。

    import java.util.Map;
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.List;
    public class Solution {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            Integer value = map.get(str.charAt(i));
            map.put(str.charAt(i),(value == null? 0:value)+1);
        }
        List<Character> list = new ArrayList<Character>();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        if(list.isEmpty()){
            return -1;
        }
        for(int j=0;j<str.length();j++){
            for(int i=0;i<list.size();i++){
                if(str.charAt(j) == list.get(i)){
                    return j;
                }
            }
        }
        return -1;
    }
    }

35 数组中的逆序对

36 两个链表的第一个公共结点

输入两个链表，找出它们的第一个公共结点。

    public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
    }
    public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp = pHead2;
        if(pHead1==null || pHead2==null){
            return null;
        }
        while(pHead1 != null){
            while(temp != null){
                if(pHead1 == temp){
                    return pHead1;
                }
                temp = temp.next;
            }
            temp = pHead2;
            pHead1 = pHead1.next;
        }
        return null;
    }
    }

37 数字在排序数组中出现的次数

统计一个数字在排序数组中出现的次数。

    public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
       for(int i=0;i<array.length;i++){
           if(k == array[i]){
               count++;
           }
       }
       return count;
    }
    }

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

一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    import java.util.Map;
    import java.util.HashMap;
    public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       //HashSet<Integer> set = new HashSet<Integer>();
       for(int i=0;i<array.length;i++){
           //set.add(array[i]);
           Integer value = map.get(array[i]);
           map.put(array[i],(map.containsKey(array[i]) == true ? value:0)+1);
       }
       int i = 0;
       int[]num = new int[2];
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(entry.getValue() == 1){
               num[i] = entry.getKey();
               i++;
           }
       }
        num1[0] = num[0];
        num2[0] = num[1];
    }
    }

41 和为S的连续正数序列

小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

    import java.util.ArrayList;
    public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       if(sum < 3){
           return res;
       }
       int small = 1,big = 2;
       int s = 0;
       while(small < (sum + 1)/2){
           s = ((small + big)*(big - small + 1))/2;
           if(s < sum){
               big++;
           }
           else if(s > sum){
               small++;
           }else{
               ArrayList<Integer> temp = new ArrayList<Integer>();//不可以用clear函数
               for(int i=small;i<=big;i++){
                   temp.add(i);
               }
               small++;
               res.add(temp);
           }
        
       }
       return res;
    }
    }

42 和为S的两个数字

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

    import java.util.ArrayList;
    public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0,right = array.length-1;
        int cum = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList();
        while(left < right){
            if((array[left]+array[right]) < sum){
                left++;
            }
            else if((array[left]+array[right]) > sum){
               right--; 
            }else{
                if(array[left]*array[right] < cum){
                    cum = array[left]*array[right];
                    res.clear();
                    res.add(array[left]);
                    res.add(array[right]);
                }
                left++;
            }
        }
        return res;
    }
    }

43 左旋转字符串

汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

    public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        char[] arr = new char[len];
        char[] temp = new char[len+n];
       // char[] res = new char[len];
       
        String res = "";
         if(len == 0){
            return res;
        }
        arr = str.toCharArray();
        for(int i=0;i<len;i++){
            temp[i] = arr[i];
        }
        for(int i=0;i<n;i++){
            temp[len+i] = arr[i];
        }
        for(int i=0;i<len;i++){
            res = res + "" + temp[n+i];
        }
        
        return res;
    }
    }

44 翻转单词顺序列

牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

    import java.util.Stack;
    public class Solution {
    public String ReverseSentence(String str) {
        Stack<String> stack = new Stack<String>();
        int begin = 0;
        String temp = "";
        if(str.trim().equals("")){
            return str;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ' ){
                temp = str.substring(begin,i);
                stack.push(temp);
                begin = i+1;
            }
        }
        if(stack.isEmpty()){
            return str;
        }
        stack.push(str.substring(str.lastIndexOf(' '),str.length()));
        String res = "";
        while(!stack.isEmpty()){
            res = res + stack.pop() + " ";
        }
        
        return res.trim();
    }
    }

45 扑克牌顺子

LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

    import java.util.Arrays;
    public class Solution {
    public boolean isContinuous(int [] numbers) {

        if(numbers.length <2){
            return false;
        }
        int zeroCount = 0;
        int gapCount = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 0){
                zeroCount++;
            }
        }
        Arrays.sort(numbers);
        int left = zeroCount;
        int right = left+1;
        while(right < numbers.length){
            if(numbers[left] == numbers[right]){
                return false;
            }
            gapCount  += numbers[right] - numbers[left] - 1; 
            left = right;
            right++;
        }
        
        return zeroCount < gapCount ? false:true;
    }
    }

46 孩子们的游戏(圆圈中最后剩下的数)

每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

    public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(m ==0 || n==0){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        return (LastRemaining_Solution(n-1,m) + m)%n;
    }
    }

47 求1+2+3+...+n

求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

    public class Solution {
       
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1)) > 0);
        return sum;
    }
    }

48 不用加减乘除做加法

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

    public class Solution {
    public int Add(int num1,int num2) {
        do{
           int sum = num1 ^ num2;
           int carry = (num1 & num2) << 1;
            
           num1 = sum;
           num2 = carry;
        }while(num2 != 0);
        return num1;
    }
    }

49 把字符串转换成整数

将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

    public class Solution {
    public int StrToInt(String str) {
        if(str == " "||str.length() == 0){
            return 0;
        }
        char [] arr = str.toCharArray();
        int flag = 0;
        if(arr[0] == '-'){
            flag = 1;
        }
        int sum = 0;
        for(int i=flag;i<str.length();i++){
            if(arr[i] == '+'){
                continue;
            }
            else if(arr[i]<48 || arr[i]>57){
                return 0;
            }else{
                sum = sum*10 + arr[i]-48;
            }
        }
        return flag == 0? sum : sum*(-1);
    }
    }

50 数组中重复的数字

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

    import java.util.Arrays;
    public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
     
        if(length < 2){
            return false;
        }
        for(int i=0;i<length;i++){
            if(numbers[i] < 0 || numbers[i] > length -1){
                return false;
            }
        }
        for(int i=0;i<length;i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
            int temp = numbers[i];
            numbers[i] = numbers[temp];
            numbers[temp] = temp;
            } 
        }
         return false;
    }
       
    }

51 构建乘积数组

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

    import java.util.ArrayList;
    public class Solution {
    public int[] multiply(int[] A) {
        int [] res = new int[A.length];
        res[0] = 1;
        for(int i=1;i<A.length;i++){
            res[i] = res[i-1]*A[i-1];
        }
        int temp = 1;
        for(int i=A.length-2;i>=0;i--){
            temp *= A[i+1];
            res[i] *= temp;
        }
        return res;
    }
    }

52 正则表达式匹配

53 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

    public class Solution {
    public boolean isNumeric(char[] str) {
        if(str.length < 1){
            return false;
        }
        //分别定义符号，是否是e，是否是.的标记，初始化为false，出现一次为true。
        //只有符号可能出现两次，其他都只能出现一次
        boolean sign = false,ise = false,isdot = false;
        for(int i=0;i<str.length;i++){
            if(str[i] == '+' || str[i] == '-'){
                if(i == str.length-1){
                    return false;//符号不能出现在末尾
                }
                if(sign && str[i-1]!='e' && str[i-1]!='E'){
                    return false;//第二次出现符号必须紧跟e或者E
                }
                if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E'){
                    return false;//第一次出现符号且不在首位，也必须紧跟在e或者E后面
                }
                sign = true;
            }
            
            else if(str[i]=='e'||str[i]=='E'){
                if(i == str.length-1){
                    return false;
                }
                if(ise){
                    return false;//e或E不能出现两次
                }
                ise=true;
            }
            else if(str[i] == '.'){
                if(i==str.length-1){
                    return false;
                }
                if(ise || isdot){
                    return false;//e或者E后面不能有.，.不能出现两次
                }
                isdot = true;
            }
            else if(str[i] < '0' || str[i] > '9'){
                return false;
            }
            //return true;
        }
        return true;
    }
    }

54 字符流中第一个不重复的字符

请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

    public class Solution {
    //Insert one char from stringstream
    int[] arr = new int[256];
    String str = "";
    public void Insert(char ch)
    {
        str += ch;
        arr[ch]++;
    }

  //return the first appearence once char in current stringstream

    public char FirstAppearingOnce()
    {
        for(int i=0;i<str.length();i++){
            if(arr[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '#';
    }
    }

55 链表中环的入口结点

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。


    public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    }
    
    public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode temp = MeetNode(pHead);
        if(temp == null){
            return null;
        }
        int count = 1;
        ListNode p1 = temp.next;
        while(p1 != temp){
            count++;
            p1 = p1.next;
        }
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        int step = 0;
        while(step < count){
            node2 = node2.next;
            step++;
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    
    public ListNode MeetNode(ListNode pHead){
       
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead;
        while(fast != null && slow != null){
            if(fast == slow){
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
    }

56 删除链表中重复的结点

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5


    public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    }
    public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;//增加哨兵节点指向原head
        
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int value = cur.val;
                while(cur != null && cur.val == value){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
         return newHead.next;

    }
    }

57 二叉树的下一个结点

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

    public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
    }
    public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        //pNode右子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //若pNode无右子树，需要找到pNode下一个节点的左孩子，并判断是否等于当前节点
        //如果相等就返回pNode的下一个节点。
        while(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
    }

58 对称的二叉树

请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    }
    public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
        
    }
    
    boolean isSymmetrical(TreeNode p1,TreeNode p2){
        if(p1 == null && p2 == null){
            return true;
        }
        else if(p1 == null || p2 == null){
            return false;
        }
        else if(p1.val != p2.val){
            return false;
        }
        
        return isSymmetrical(p1.left,p2.right)&&isSymmetrical(p1.right,p2.left);
    }
    }


59 按之字形顺序打印二叉树

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

    import java.util.ArrayList;
    import java.util.Stack;
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    }
    public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        
        //ArrayList<Integer> temp = new ArrayList<Integer>();
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();//保存奇数层节点
        Stack<TreeNode> stack2 = new Stack<TreeNode>();//保存偶数节点
        if(pRoot == null){
            return res;
        }
        stack1.push(pRoot);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if(node.left != null){
                    stack2.push(node.left);
                }
                if(node.right != null){
                    stack2.push(node.right);
                }
            }
            if(!temp.isEmpty()){
                res.add(temp);
            }
            //temp.clear();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                tmp.add(node.val);
                if(node.right!=null){
                    stack1.push(node.right);
                }
                if(node.left!=null){
                    stack1.push(node.left);
                }
            }
            if(!tmp.isEmpty()){
             res.add(tmp);
            }
        }
        
        return res;

    }
    }

60 把二叉树打印成多行

从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

    import java.util.ArrayList;
    import java.util.Queue;
    import java.util.LinkedList;
    
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    }
    public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        //Queue<TreeNode>queue2 = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(pRoot == null){
            return res;
        }
        queue.offer(pRoot);
        int num = 1,next = 0;
        while(!queue.isEmpty()){
            //ArrayList<Integer> list = new ArrayList<Integer>();
            TreeNode temp = queue.poll();
            list.add(temp.val);
            num--;
            if(temp.left != null){
                queue.offer(temp.left);
                next++;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                next++;
            }
            if(num == 0){
                res.add(new ArrayList<Integer>(list));
                list.clear();
                num = next;
                next = 0;
            }
        }
        return res;
        
    } 
    }

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

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

    import java.util.ArrayList;
    public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(size > num.length || size == 0){
            return res;
        }
        for(int i=0;i<num.length-size+1;i++){
            int max = num[i];
            for(int j=i;j<(size+i);j++){
                if(num[j] > max){
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;
    }
    }

65 矩阵中的路径

66 机器人的运动范围


    public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows < 1 ||cols < 1){
            return 0;
        }
        boolean[] visited = new boolean[rows*cols];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        //返回格子数
        return getmovingCount(threshold,rows,cols,0,0,visited);
    }
    
    public int getmovingCount(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count = 0;
        //对于凡是可以访问的格子数进行累加
        if(isCanVisited(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col] = true;
            count = 1+getmovingCount(threshold,rows,cols,row-1,col,visited)//上
                +getmovingCount(threshold,rows,cols,row,col-1,visited)//左
                +getmovingCount(threshold,rows,cols,row+1,col,visited)//下
                +getmovingCount(threshold,rows,cols,row,col+1,visited);//右
        }
        
        return count;
    }
    //判断能否访问
    public boolean isCanVisited(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        return (rows>row && row>=0 && col>=0 && cols>col  && !visited[row*cols+col] &&(getNum(row) + getNum(col) <= threshold));
    }
    //计算数值
    public int getNum(int num){
        int sum = 0;
        while(num != 0){
            sum += (num%10);
            num = num/10;
        }
        return sum;
    }


    }