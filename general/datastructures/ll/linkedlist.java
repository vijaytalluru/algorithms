package ll;

public class linkedlist<Data>{
  Node first;

  private class Node{
    Data data;
    Node next;
    public Node(Data data){
      this.data = data;      
    }
  }


  public void print(){
    print(first);
    System.out.println();
  }

  private void print(Node x){
    if (x == null ) return;
    System.out.print(x.data + " " );
    print(x.next);
  }

  public void add(Data data){
    first = add(first, data);
  }

  private Node add(Node x, Data data){
    if( x == null) return new Node(data); 
    else
      x.next = add(x.next, data);
    return x;
  }

  private Node last(Node x){
    if( x == null ) return null;
    while(x.next != null){
      x = x.next;
    }
    return x;
  }

  public void reverse(){
    first =  reverse(first);
  }

  private Node reverse(Node x){
    if(x == null) return null;
    if(x.next == null) return x;
    Node result = reverse(x.next);
    x.next.next = x;
    x.next = null;
    return result ;
  }


  public void reverseiterative(){
    first = reverseiterative(first);
  }


  private Node reverseiterative(Node x){
    if(x == null) return null;

    Node cur = x;
    Node nex = x.next; 
    while(nex != null){
      Node temp = nex.next;  
      nex.next = cur;
      cur = nex;
      nex = temp;
    }
    
    x.next = null;
    return cur;
  }

  public void reverseGroupsOfK(int k){
    first = reverseGroupsOfK(first,k); 
  }


  private Node reverseGroupsOfK(Node x, int k){
    Node cur = x;
    Node result = cur;
    Node prev = null;
    while(cur != null){
      Node c = cur;
      
      Node nex = cur.next;
      for(int i = 1 ; nex!= null && i < k ; i++){
        Node temp = nex.next;
        nex.next = cur;
        cur = nex;
        nex = temp;
      }
       
      if(prev == null) {
        result = cur; 
      }
      else {
        prev.next = cur;
      }
       
      prev = c;
      cur = nex;

    }
    if(prev != null)
      prev.next = null;

    return result;
    
  }

}
