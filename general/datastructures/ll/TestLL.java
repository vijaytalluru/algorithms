package ll;

public class TestLL{
  public static void main(String[] args){
    linkedlist<String> list1 = new linkedlist<String>();
    linkedlist<String> list2 = new linkedlist<String>();

    String s = "ABCDEFGH";
    for(int i = 0 ; i < s.length() ; i++){ 
      list1.add(s.substring(i,i+1));
    }

    list1.print();
    
    list1.reverse();

    list1.print();

    list1.reverse();


    System.out.println("Reversing the abcdefgh:");
    list1.reverseiterative();
    list1.print();


    list1.reverse();


    System.out.println("Reversing groups of K");
    list1.reverseGroupsOfK(0);
    list1.print();
    
    String s1 = "a";
    for(int i = 0 ; i < s1.length() ; i++){ 
      list2.add(s1.substring(i,i+1));
    }

    list2.print();
    list2.reverse();
    list2.print();


  }
}
