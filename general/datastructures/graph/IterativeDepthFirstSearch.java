package graph;

import java.util.*;

public class IterativeDepthFirstSearch{
  private boolean[] marked;
  private int count;

  public IterativeDepthFirstSearch(Graph G, int s){
    marked = new boolean[G.V()];
    dfs(G,s);
  }

  private void dfs(Graph G, int v){
    marked[v] = true;
    count++;
    Stack<Integer> s = new Stack<Integer>();
    s.push(v);
    while(!s.empty()){
      int cur = s.pop();
      for(int w : G.adj(cur)){
        if(!marked[w]){
          marked[w] = true;
          s.push(w);
        }
      }
    }
  }

  public boolean marked(int w){
    return marked[w];
  }

  public int count(){
    return count;
  }
}
