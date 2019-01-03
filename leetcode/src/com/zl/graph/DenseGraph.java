package com.zl.graph;

import java.util.Vector;

/**
 * @author zlCalma
 * @date 2018/12/4 21:42.
 */
//稠密图采用邻接矩阵来存储
public class DenseGraph implements Graph {

    private int n;//节点数
    private int m;//边数
    private boolean directed; //是否为有向图
    private boolean [][] g;//图中存储的具体数据

    public DenseGraph(int n, boolean directed) {

        assert n >= 0;//断言。后面表达式为true是程序继续执行，否则抛出AssertionError错误
        this.n = n;
        this.directed = directed;
        g = new boolean[n][n];
    }
    @Override
    //返回节点个数
    public int V() {
        return n;
    }
    @Override
    //返回边数
    public int E() {
        return m;
    }
    @Override
    public void addEdge(int v, int w) {
       assert v>=0 && v < n;
       assert w >=0 && w < n;
       //v和w之间有边
       if(hasEdge(v,w)){
           return;
       }
       g[v][w] = true;
       //当为无向图时，v->w和w->v都是true
       if(!directed){
           g[w][v] = true;
       }
       m++;//增加一条边则加1
    }
    @Override
    //验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >=0 && w < n;
        return g[v][w];
    }
    @Override
    public void show() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }

    }
    //返回一个顶点所有的邻边
    //返回所有邻边使用Vector存储
    @Override
    public Iterable<Integer> adj(int v) {
        assert v>= 0 && v<n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i=0;i<n;i++){
            if(g[v][i]){
                adjV.add(i);
            }
        }
        return adjV;
    }
}
