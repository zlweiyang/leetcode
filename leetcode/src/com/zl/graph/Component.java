package com.zl.graph;

/**
 * @author zlCalma
 * @date 2018/12/4 23:06.
 */
public class Component {

    Graph G;
    private boolean[] visited;
    private int ccount;//联通分量个数
    private int[] id;//每个节点对应联通分量标记

    void dfs(int v){
        visited[v] = true;
        id[v] = ccount;

        for(int i:G.adj(v)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public Component(Graph g) {
        G = g;
        visited  =new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for(int i=0;i<G.V();i++){
            visited[i] = false;
            id[i] = -1;
        }
        for(int i=0;i<G.V();i++){
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    int count(){
        return ccount;
    }

    boolean isConnrcted(int v,int w){
        assert v>=0 && v<G.V();
        assert w>=0 && w<G.V();
        return id[v] == id[w];
    }

    public static void main(String[] args) {

    }

}
