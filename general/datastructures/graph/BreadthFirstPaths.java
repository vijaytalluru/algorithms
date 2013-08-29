package graph;

import java.util.*;

public class BreadthFirstPaths{
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public BreadthFirstPaths(Graph G, int s){
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G,s);
  }

  private void bfs(Graph G, int s){
    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    marked[s] = true;
    q.add(s);
    while(!q.isEmpty()){
      int v = q.remove();
      for(int w : G.adj(v)){
        if(!marked[w]){
          edgeTo[w] = v;
          marked[w] = true;
          q.add(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v){
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v){
    if(!hasPathTo(v))
      return (new Stack<Integer>());
    Stack<Integer> path = new Stack<Integer>();
    for(int x = v ; x != s ; x = edgeTo[x]){
      path.push(x);
    }
    path.push(s);
    return path;
    
  }
  
}

