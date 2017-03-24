package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Jainish on 23-03-2017.
 */
public class Graph {
    int V;// number of vertices
    LinkedList<Integer> adj[];
    public Graph(){}
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void BFS( int s ) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while( queue.size() > 0 ) {
            s = queue.poll();
            System.out.println(" " + s);

            Iterator<Integer> i = adj[s].listIterator();
            while( i.hasNext() ) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil( int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v+" ");
            Iterator<Integer> i = adj[v].listIterator();
            while( i.hasNext() ) {
                int n = i.next();
                if( !visited[n] ) {
                    DFSUtil( n, visited );
                }
            }
    }

    void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i=0; i<V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);

        g.DFS();
    }
}
