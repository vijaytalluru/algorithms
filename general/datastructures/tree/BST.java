package tree;

import java.util.*;

public class BST<Key extends Comparable<Key>,Value>{
  private Node root;

  private class Node{
    private Key key;
    private Value val;
    private Node left, right;
    private int N;
    private boolean visited;

    public Node(Key key, Value val, int N){
      this.key = key ;
      this.val = val;
      this.N = N;
      this.visited = false;
    }
  }

  public int size(){
    return size(root);
  }

  private int size(Node x){
    if ( x == null) return 0;
    return x.N;
  }

  public Value get(Key key){
    return get(root,key);
 }

  public Value get(Node x, Key key){
    if(x == null) return null;
    int cmp = key.compareTo(x.key);
    if( cmp < 0 ) return get(x.left, key);
    else if (cmp > 0) return get(x.right, key);
    else return x.val;
  }

  public void put( Key key, Value val){
    root = put(root, key, val);
  }

  public Node put(Node x, Key key, Value val){
     if( x == null) return new Node(key,val,1);

     int cmp = key.compareTo(x.key);
     if( cmp < 0) x.left = put(x.left,key,val);
     else if (cmp > 0) x.right = put(x.right,key,val);
     else x.val = val;
     x.N = size(x.left) + size(x.right) + 1;
     return x;
  }

  public Key min(){
    return min(root).key;
  }

  private Node min(Node x){
    if(x == null) return null;
    if(x.left == null) return x;
    return min(x.left);
  }

  public Key floor(Key key){
    Node x = floor(root, key);
    if ( x == null) return null;
    return x.key;
  }

  public Node floor(Node x , Key key){
    if(x == null) return null;
    int cmp = key.compareTo(x.key);

    if( cmp == 0) return x;
    if( cmp < 0 ) return floor(x.left,key);

    Node t = floor(x.right,key);
     
    if(t == null) return x;
    else return t;
  }

  public Key ceiling(Key key){
    Node x= ceiling(root,key);
    if(x == null) return null;
    return x. key;
  }

  public Node ceiling (Node x, Key key){
    if(x == null) return null;
    int cmp = key.compareTo(x.key);

    if(cmp == 0 ) return x;
    if( cmp > 0) return ceiling(x.right,key);

    Node t = ceiling(x.left,key);
    if( t == null ) return x;
    else return t;
  }

  private void clear(){
    clear(root);
  }

  private void clear(Node x){
    if( x == null ) return;
    x.visited = false;
    clear(x.left);
    clear(x.right);
  }

  public void inorder(){
    inorder(root); 
    System.out.println();
  }

  private void inorder(Node x){
    if(x == null) return;
    inorder(x.left);
    System.out.print(x.key + " " );
    inorder(x.right);
  }

  public void iterativeinorder(){
    iterativeinorder(root); 
    System.out.println();
    clear();
  }

  private void iterativeinorder(Node root){
    Stack<Node> s = new Stack<Node>();
    
    s.push(root);

    while( ! s.empty() ){
      Node cur = s.peek();
      if(cur.left != null && cur.left.visited == false){
        s.push(cur.left);
      }
      else{
        s.pop();
        System.out.print(cur.key + " ");
        cur.visited = true;
        if(cur.right != null){
          s.push(cur.right);
        }
      }
         
    }
    
  }



  public void postorder(){
    postorder(root);
    System.out.println();
  }

  private void postorder(Node x){
    if(x == null) return;
    postorder(x.left);
    postorder(x.right);
    System.out.print(x.key + " ");
  }

  public void iterativepostorder(){
    iterativepostorder(root);
    System.out.println();
    clear();
  }

  public void iterativepostorder(Node x){
    Stack<Node> s = new Stack<Node>();
    s.push(x);
    while(!s.empty()){
      Node cur = s.peek();

      if( (cur.left == null || cur.left.visited ) && (cur.right == null || cur.right.visited)){
        s.pop();
        cur.visited = true;
        System.out.print(cur.key + " ");
      }
      else{
        if(cur.right != null){
          s.push(cur.right);
        }
        if(cur.left != null){
          s.push(cur.left);
        }
      }
    }
  }


  public void iterativepostorder1(){
    iterativepostorder(root);
    System.out.println();
  }

  private void iterativepostorder1(Node x){
    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();

    if(x == null) return;

    s1.push(x);

    while( !s1.empty()){
      Node cur = s1.pop();
      s2.push(cur);

      if(cur.left != null){
        s1.push(cur.right);
      }
      if(cur.right != null){
        s1.push(cur.left);
      }

    }

    while(!s2.empty()){
      System.out.print(s2.pop() + " ");
    }

  }

  public Key select(int k){
    return select(root,k).key;
  }

  private Node select(Node x, int k){
    if( x == null ) return null;
    int  t = size(x.left);
    if ( t > k ) return select(x.left, k);
    else if (t < k) return select(x.right,k-t-1);
    else return x;
  }

  public int rank(Key key){
    return rank(root, key);
  }

  private int rank(Node x, Key key){
    if(x == null) return 0;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) return rank(x.left,key);
    else if( cmp > 0) return  1 + size(x.left) + rank( x.right, key);
    else return size(x.left);
  }

  public void deleteMin(){
    root = deleteMin(root);
  }

  private Node deleteMin(Node x){
    if(x.left == null){
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void delete(Key key){
    root = delete(root,key);
  }

  private Node delete(Node x, Key key){
    if( x == null ) return null;

    int cmp = key.compareTo(x.key);

    if(cmp < 0) x.left = delete(x.left,key);
    else if(cmp > 0) x.right = delete(x.right,key);
    else{
      if(x.right == null) return x.left;
      if(x.left == null) return x.right;
      System.out.println("x: " + x.key);
      Node t = x; 
      x = min(t.right);
      x.left = t.left;
      System.out.println("x.left: " + x.left.key);
      x.right = deleteMin(t.right);
      System.out.println("x.right: " + x.right.key);
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

}
