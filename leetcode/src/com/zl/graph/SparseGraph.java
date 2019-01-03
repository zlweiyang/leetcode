package com.zl.graph;

import java.util.Vector;

/**
 * @author zlCalma
 * @date 2018/12/4 22:05.
 */
public class SparseGraph implements Graph {
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {

        assert n>0;
        this.n = n;
        this.m = m;
        this.directed = directed;
        g = (Vector<Integer>[])new Vector[n];
        for(int i=0;i<n;i++){
            g[i] = new Vector<Integer>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        g[v].add(w);
        if(v != w && !directed){
            g[w].add(v);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for(int i=0;i<n;i++){
            System.out.print("vertex " + i + ";\t");
            for(int j=0;i<g[i].size();j++){
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >=0 && v<n;
        return g[v];
    }
}
