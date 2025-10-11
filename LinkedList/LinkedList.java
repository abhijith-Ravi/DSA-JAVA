class LinkedList {
  public class Node{
    int data;
    Node next;
    Node (int data){
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  public Node addFirst(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return head;
    }
    newNode.next = head;
    head = newNode;
    return head;
  }

  public Node addLast (int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return head;
    }
    tail.next = newNode;
    tail = newNode;
    return head;
  }

  public void print(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public Node addMiddle(int idx, int data){
    Node newNode = new Node(data);
    size++;
    if(idx == 0){
      return addFirst(data);
    }
    Node temp = head;
    int count = 0;
    while(count < idx - 1){
      temp = temp.next;
      count++;
    }
    newNode.next =temp.next ;
    temp.next = newNode;
    return head;
  }

  public int removeFirst(){
     if(size == 0){
      System.out.println("LinkedList is empty");
      return Integer.MIN_VALUE;
     }else if( size == 1){
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
     }
     int val = head.data;
     head = head.next;
     size--;
     return val;

  }

  public int removeLast(){
    if(size == 0){
      System.out.println("LinkedList is empty");
      return Integer.MIN_VALUE;
    }else if(size == 1){
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;
    }
    Node temp = head;
    while(temp.next != tail){
      temp = temp.next;
    }
    int val = tail.data;
    tail = temp;
    tail.next = null;
    size--;
    return val;
    
  }

  public int iterativeSearch(int key){
    Node temp = head;
    int idx = 0;
    while(temp != null){
      if(temp.data == key){
        return idx;
      }
      temp = temp.next;
      idx++;
    }
    return -1;
  }

  static int idx = 0;


  public int recursiveSearch(int key){
    Node temp = head;
    return actualRecursiveSearch(temp, key);
  }
  public int actualRecursiveSearch(Node temp, int key){
    if(temp == null){
      return -1;
    }
    if(temp.data == key){
      return idx;
    }
    idx++;
    return actualRecursiveSearch(temp.next, key);
  }


  public Node reverseIterative(){
    Node prev = null;
    Node curr = tail = head;
    Node takeCare = null;
    while(curr != null){
      takeCare = curr.next;
      curr.next = prev;
      
      prev = curr;
      curr = takeCare;
    }
    head = prev;
    return head;
  }


  public int removeNthFromLast(int n){
    int m = size - n;
    if(m == 0){
      return removeFirst();
    }
    if(m == size - 1){
      return removeLast();
    }

    Node temp = head; 
    int count = 0;
    while(count < m - 1){
      temp = temp.next;
      count++;
    }
    int val = temp.next.data;
    temp.next = temp.next.next;
    return val;
  }

  public boolean checkPalimdrome(){

    Node temp = head;
    Node tempStay = head;
    int m = size/2;
    int count = 0;
    while (count < m - 1) {
      temp = temp.next;
      count++;
    }
    Node secondHead = temp.next;
    temp.next = null;
    Node prev = null;
    Node curr = secondHead;
    Node takeCare = null;

    while(curr != null){
      takeCare = curr.next;
      curr.next = prev;
      prev = curr;
      curr = takeCare;
    }
    secondHead = prev;
    count = 0;
    while(count < m){
      if(tempStay.data != secondHead.data){
        return false;
      }
      System.out.println("" + tempStay.data + " " + secondHead.data);
      tempStay = tempStay.next;
      secondHead = secondHead.next;
      count++;
    }
    return true;

  }

  
  //fast - slow pointers
  public Node findMid(){
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }


  public boolean checkPalimdromefandS(){
    if(head == null || head.next == null){
      return true;
    }
    //find mid
    Node midNode = findMid();

    //reverse 2nd half
    Node prev = null;
    Node curr = midNode;
    Node takeCare = null;

    while(curr != null){
      takeCare = curr.next;
      curr.next = prev;
      prev = curr;
      curr = takeCare;
    }
    Node secondHead = prev;

    //check palindrome
    Node firstHead = head;
    while(secondHead != null){
      if(firstHead.data != secondHead.data){
        return false;
      }
      firstHead = firstHead.next;
      secondHead = secondHead.next;
    }

    return true;
  }




  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(1);
    // ll.addMiddle(2,3);
    ll.print();
    // System.out.println(ll.recursiveSearch(3) + "yea");
    // ll.reverseIterative();
    // ll.print();
    if(ll.checkPalimdromefandS()){
      System.out.println("Palindrome");
    }else{
      System.out.println("Not a Palindrome");
    }
    ll.print();
    // System.out.println(ll.size);
    // ll.removeFirst();
    // ll.print();
    // System.out.println(ll.size);
    // ll.removeLast();
    // ll.print();
    // System.out.println(ll.size);

  }
}