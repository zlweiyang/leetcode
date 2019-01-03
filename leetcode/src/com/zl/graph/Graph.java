package com.zl.graph;

/**
 * @author zlCalma
 * @date 2018/12/4 21:36.
 */
//图的接口
public interface Graph {

    public int V();//顶点
    public int E();//边

    public void addEdge(int v,int w);//增加边
    boolean hasEdge(int v,int w);//判断v,w两点之间是否有边
    void show();
    public Iterable<Integer>adj(int v);//遍历顶点
}
