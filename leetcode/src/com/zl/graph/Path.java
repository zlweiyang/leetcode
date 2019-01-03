package com.zl.graph;

import java.util.Stack;
import java.util.Vector;

/**
 * @author zlCalma
 * @date 2018/12/6 22:24.
 */
public class Path {

    private Graph G;//图的引用
    private int s;//起始点
    private boolean[] visited;//记录dfs的过程中节点是否被访问
    private int[] from; //记录路径，from[i]表示查找的路径上i的上一个节点

    //图的深度优先遍历
    private void dfs(int v){
        visited[v] = true;
        for(int i : G.adj(v)){
            from[i] = v;
            dfs(i);
        }
    }

    public Path(Graph graph,int s){
        //算法初始化
        G  = graph;
        assert s>=0 && s < G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for(int i=0;i<G.V();i++){
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }
    Vector<Integer> path(int w){
        assert hasPath(w);
        Stack<Integer> s = new Stack<Integer>();

        int p=w;
        while (p != -1){
            s.push(p);
            p = from[p];
        }

        Vector<Integer> res = new Vector<Integer>();
        while(! s.empty()){
            res.add(s.pop());
        }
        return res;
    }

    void showPath(int w){
        assert hasPath(w);

        Vector<Integer> vec = path(w);
        for(int i=0;i<vec.size();i++){
            System.out.println(vec.elementAt(i));
            if(i == vec.size()-1){
                System.out.println();
            }else{
                System.out.println("->");
            }
        }
    }

    public static void main(String[] args) {
        String filename = "F:\\leetcode\\src\\com\\zl\\graph\\testG";
        SparseGraph g= new SparseGraph(7,false);
        ReadGraph readGraph = new ReadGraph(g,filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6:");
        path.showPath(6);
    }

}
