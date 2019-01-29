package com.leetcode.dfs;

/**
 * @author zlCalma
 * @date 2019/1/27 20:30.
 */
public class WordSearch79 {
    int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    int m,n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board.length <= 0){
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(searchWord(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean inArea(int x,int y){
        return x>=0 && x<m && y>=0 && y<n;
    }

    boolean searchWord(char[][]board,String word,int index,int startx,int starty){
        if(index == word.length()-1){
            return board[startx][starty] == word.charAt(index);//等于最后一个查找字符
        }

        if(board[startx][starty] == word.charAt(index)){
            visited[startx][starty] = true;
            //表示从当前位置startx,starty出发，朝四个方向寻找
            for(int i=0;i<4;i++){
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if(inArea(newx,newy) && !visited[newx][newy] && searchWord(board,word,index+1,newx,newy)){
                    return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }
}
