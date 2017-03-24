package com.graph;

import java.util.Iterator;

/**
 * Created by Jainish on 24-03-2017.
 */
public class DetectCycleInDirectedGraph extends Graph {
    boolean CyclicU(int v, boolean visited[], boolean rec[])
    {
        Integer n;
        if(visited[v]==false)
        {
            visited[v]=true;
            rec[v]=true;

        }
        Iterator<Integer> i=adj[v].listIterator();
        while(i.hasNext())
        {
            n=i.next();
            if(!visited[n] && CyclicU(n, visited, rec))
            {
                return true;
            }
            else if(rec[n])
            {
                return true;
            }

        }
        rec[v]=false;
        return false;
    }

    boolean Cyclic()
    {
        boolean visit[]=new boolean [V];
        boolean rec[]=new boolean[V];
        for(int i = 0; i < V; i++)
        {
            visit[i] = false;
            rec[i] = false;
        }

// Call the recursive helper function to detect cycle in different
// DFS trees
        for(int i = 0; i < V; i++)
            if (CyclicU(i, visit, rec))
                return true;

        return false;
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

        System.out.println("Detech loop" +  new DetectCycleInDirectedGraph().Cyclic() );
    }
}
