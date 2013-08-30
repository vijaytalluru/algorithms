package tree;

public class TestTree{

  public static void main(String[] args){
    BST<String,Integer> btree = new BST<String,Integer>();

    String s = "SEARCHEXAMPLE";
    for(int i = 0 ; i < s.length() ; i++){
      btree.put(s.substring(i,i+1),i);      
    }

    System.out.println("Size of the tree: " + btree.size()); 
    System.out.println("Minimum value: " + btree.min());
    
    btree.inorder();
    btree.iterativeinorder();
    btree.iterativeinorder();
    btree.postorder();
    btree.iterativepostorder();
    btree.iterativepostorder1();

    btree.deleteMin();

    btree.delete("S");

    
  }


}
