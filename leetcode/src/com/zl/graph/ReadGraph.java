package com.zl.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author zlCalma
 * @date 2018/12/4 22:21.
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph,String filename){
        readFile(filename);
        try {
            int V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be nonegative");
            }
            assert V == graph.V();
            int E = scanner.nextInt();
            if(E < 0){
                throw new IllegalArgumentException("numbers of edges in a Graph must be nonegative");
            }
            for(int i=0;i<E;i++){
                int v  =scanner.nextInt();
                int w = scanner.nextInt();
                assert v>=0 && v < V;
                assert w>=0 && w < V;
                graph.addEdge(v,w);
            }
        }catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream,but the next token is \"" + token + "\"");
        }catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from input stream,but there are no more tokens available");
        }
    }

    public void readFile(String filename){
        assert filename != null;
        try{
            File file = new File(filename);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else{
                throw new IllegalArgumentException(filename + " dosen't exist.");
            }
        }catch (IOException ioe){
            throw new IllegalArgumentException("Could not open" + filename,ioe);
        }
    }

    public static void main(String[] args) {
        String filename = "F:\\leetcode\\src\\com\\zl\\graph\\testG1";
        SparseGraph g1 = new SparseGraph(13,false);
        ReadGraph readGraph = new ReadGraph(g1,filename);
        System.out.println("testG1 in Sparse Graph");
        g1.show();

        DenseGraph g2 = new DenseGraph(13,false);
        ReadGraph readGraph2 = new ReadGraph(g2,filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();
        System.out.println();

        filename = "F:\\leetcode\\src\\com\\zl\\graph\\testG2";
        DenseGraph g4 = new DenseGraph(6,false);
        ReadGraph readGraph4 = new ReadGraph(g4,filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();
    }


}
