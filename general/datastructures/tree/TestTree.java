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
    System.out.println("Printing the second iterative postorder");
    btree.iterativepostorder1();
    /* Printing the left view of the tree */
    for(String r : btree.leftview()){
      System.out.print(r + " " );
    }
    System.out.println();

    /* Printing the left view of the tree */
    for(String r : btree.leftviewiterative()){
      System.out.print(r + " " );
    }
    System.out.println();



    btree.deleteMin();

    btree.delete("S");

    btree.inorder();

    for(String r : btree.keys("E","R")){
      System.out.print(r +  " ");
    }
    System.out.println();


    System.out.print("Level Order Traversal : " );
    for(String r : btree.levelorder()){
      System.out.print(r +  " ");
    }
    System.out.println();

    System.out.print("Reverse level Order Traversal : " );
    for(String r : btree.reverselevelorder()){
      System.out.print(r +  " ");
    }
    System.out.println();
    
  }


}
