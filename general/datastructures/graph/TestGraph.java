package graph; 
import java.io.*;
import java.util.*;
import bag.Bag;
public class TestGraph{
  public static void main(String[] args) throws IOException{
    Graph g = new Graph(new Scanner(new File(args[0])));
    System.out.println("Number of vertices : " + g.V());
    System.out.println("Number of edges : " + g.E());

    DepthFirstSearch dfs = new DepthFirstSearch(g,1);
    for(int v = 0 ; v < g.V() ; v++){
      if(dfs.marked(v)){
        System.out.print(v + " ");
      }
    }

    System.out.println();

    IterativeDepthFirstSearch dfs1 = new IterativeDepthFirstSearch(g,9);
    System.out.println("Iterative Depth First Search: ");
    for(int v = 0 ; v < g.V() ; v++){
      if(dfs1.marked(v)){
        System.out.print(v + " ");
      }
    }
    
    System.out.println("");

    DepthFirstPaths paths = new DepthFirstPaths(g,1);
    Stack<Integer> path = (Stack<Integer>)( paths.pathTo(3));
    while( !path.isEmpty() ){
      int node = path.pop();
      if(node == 1)
        System.out.print("Path: " + node);
      else
        System.out.print("-"+ node);
    }
    System.out.println("");

    BreadthFirstPaths paths1 = new BreadthFirstPaths(g,1);
    Stack<Integer> path1 = (Stack<Integer>)( paths1.pathTo(3));
    while( !path1.isEmpty() ){
      int node = path1.pop();
      if(node == 1)
        System.out.print("Path: " + node);
      else
        System.out.print("-"+ node);
    }
    System.out.println("");

    CC cc = new CC(g);
    int M = cc.count();
    
    System.out.println(M + " components");

    Bag<Integer>[] components;
    components = (Bag<Integer>[]) new Bag[M];

    for(int i = 0 ; i < M ; i++){
      components[i] = new Bag<Integer>();
    }

    for(int v = 0 ; v < g.V(); v++){
      components[cc.id(v)].add(v);
    }

    for(int i = 0 ; i < M ; i++){
      for(int v : components[i]){
        System.out.print(v + " ");
      } 
      System.out.println();
    }

    Cycle cycle = new Cycle(g);
    if(cycle.hasCycle()){
      System.out.println("The graph has a cycle");
    }
    else{
      System.out.println("The graph does not have a cycle");
    }

  }
}
