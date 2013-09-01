package stringops;
import java.util.*;

public class TrieST<Value>{
  private static int R = 256; 
  private Node root ;

  private static class Node{
    private Object val;
    private Node[] next = new Node[R];
  }

  public Value get(String key){
    Node x = get(root, key , 0);
    if(x == null) return null;
    return (Value)x.val;
  }

  private Node get(Node x, String key , int d){
    if(x == null) return null;
    if(d == key.length()) return x;
    char c = key.charAt(d);
    return get(x.next[c],key,d+1);
  }

  public void put(String key, Value val){
    root = put(root, key,val,0);
  }

  private Node put(Node x, String key, Value val, int d){
    if(x == null) x = new Node();
    if(d == key.length()) { x.val = val; return x;}
    char c = key.charAt(d);
    x.next[c] = put(x.next[c],key,val,d+1);
    return x;
  }


  public Iterable<String> keys(){
    return keysWithPrefix("");
  }


  public Iterable<String> keysWithPrefix(String pre){
    ArrayDeque<String> q = new ArrayDeque<String>();
    collect(get(root,pre,0),pre,q);
    return q;
  }

  private void collect(Node x, String pre, Queue<String> q){
    if(x == null) return;
    if(x.val != null) q.add(pre);
    for(char c = 0 ; c < R ; c++){
      collect(x.next[c],pre+c,q); 
    }
  }

  public Iterable<String> keysThatMatch(String pat){
    ArrayDeque<String> q = new ArrayDeque<String>();
    collect(root,"",pat,q);
    return q;
  }

  private void collect(Node x, String pre, String pat, Queue<String> q){
    int d = pre.length();
    if(x == null) return;
    if(d == pat.length()){ 
      if( x.val != null)
        q.add(pre); 
      return;
    }
    char next = pat.charAt(d);

    for(char r = 0 ; r < R ; r++){
      if(next == '.' || next == r){
        collect(x.next[r], pre + r, pat,q);
      }
    }
  }


  public String longestPrefixOf(String s){
    int length = search(root,s, 0,0);
    return s.substring(0,length);
  }

  private int search(Node x, String s, int d , int length){
    if(x == null) return length;
    if (x.val != null) length = d;
    if( d == s.length()) return length;
    char c = s.charAt(d);
    return search(x.next[c],s,d+1,length);
  }


  public void delete(String key){
    root = delete(root, key, 0);
  }

  private Node delete(Node x, String key , int d){
    if(x == null) return null;
    if(d == key.length()) x.val = null;

    else{
      char c = key.charAt(d);
      x.next[c] = delete(x.next[c],key,d+1);
    }

    if(x.val != null) return x;

    for(int r = 0 ; r < R ; r++){
      if(x.next[r] != null) return x; 
    }
    return null;
  }


}
