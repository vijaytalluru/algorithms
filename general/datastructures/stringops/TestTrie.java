package stringops;

import java.util.*;

public class TestTrie{
  public static void main(String[] args){
    TrieST<Integer> trie = new TrieST<Integer>();

    String[] keys = {"she","sells","sea","shells","by","the","sea","shore"};
    
    for(int i = 0 ; i < keys.length;i++){
      trie.put(keys[i],i);
    }
    

    for( String w : trie.keys()){
      System.out.println(w + " - " + trie.get(w));
    }

    System.out.println("Keys that match s.. ");
    for(String w : trie.keysThatMatch("s..")){
      System.out.println(w + " ");
    }


    System.out.println("Longest Prefix of shellsort is :");
    
    System.out.println( trie.longestPrefixOf("shellsort"));

    trie.delete("shells");

    for( String w : trie.keys()){
      System.out.println(w + " - " + trie.get(w));
    }

  }
}
