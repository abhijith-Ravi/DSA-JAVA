class LinkedList {
  public static class Node{
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

  public void print(Node heady){
    Node temp = heady;
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

   public static void detectIfLoop(Node head){
        Node slowPtr = head;
        Node fastPtr = head;

        while ( fastPtr != null  && fastPtr.next != null){
          slowPtr = slowPtr.next;
          fastPtr = fastPtr.next.next;

          if(slowPtr == fastPtr){
            System.out.println("Loop detected");
            break;
          }
        }
        Node prev = null;
        slowPtr = head;
        while(slowPtr != fastPtr){
          prev = fastPtr;
          slowPtr = slowPtr.next;
          fastPtr = fastPtr.next;
       } 
      System.out.println(fastPtr.data);
      System.out.println(prev.data); 
        // return false;
   }

  public static Node mergeUsingLL(Node nodey){
    //base
    if(nodey.next == null ){
      return nodey;
    }
    Node mid = findmid(nodey);

    Node first = nodey;
    Node second = mid.next;
    mid.next = null;

    //recur
    Node firsthalf = mergeUsingLL(first);
    Node secondhalf = mergeUsingLL(second);
    return merge(firsthalf, secondhalf);
     
   } 

  public static Node merge(Node first, Node second){
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;

    while(first != null && second != null){
      if(first.data <= second.data){
        temp.next = first;
        first = first.next;
        temp = temp.next;
      }else{
        temp.next = second;
        second = second.next;
        temp = temp.next;
      }
    }

    while(first != null){
      temp.next = first;
      first = first.next;
      temp = temp.next;
    }

    while(second != null){
      temp.next = second;
      second = second.next;
      temp = temp.next;
    }

    return mergedLL.next;
  }

  public static Node findmid(Node nodey){
    Node slow = nodey;
    Node fast = nodey.next;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static Node zigzag(Node head){

    Node mid = findmid(head);
    Node first = head;
    Node second = mid.next;
    mid.next = null;

    Node curr = second;
    Node prev = null;
    Node next = second;

    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr  = next;
    }
    second = prev;


    Node temp = new Node(-1);
    Node all = temp;
    
    while (first != null && second !=null){
      temp.next = first;
      first = first.next;
      temp = temp.next;

      temp.next = second;
      second = second.next;
      temp = temp.next;
    }

    if(first != null){
      temp.next = first;
    }
    if(second != null){
      temp.next = second;
    }

    return all.next;


  }
  // -----------------------------------------------------------------------
  //assignments

  public static void findMergepoint(Node head1, Node head2){
    while(head1 != null){
      Node temp = head2;
      while(temp != null){
        if(head1 == temp){
          System.out.println("Merge point at " + head1.data);
          return;
        }
        temp = temp.next;
      }
      head1 = head1.next;
    }

  }

  public static void deleteNNodesAfterMNodes(Node head, int m, int n){
    Node tempm = head;
    Node tempn = null;
    for(int i=1; i<=m-1; i++){
      if(tempm == null){
        return;
      }
      tempm = tempm.next;
    }
    tempn = tempm;
    for(int j=1; j<=n+1; j++){
      if(tempn == null){
        break;
      }
      tempn = tempn.next;
    }
    tempm.next = tempn;
  }

public static void swapTwoNumbers(int a, int b){
  Node curr1 = head;
  Node prev1 = null;
  Node next1 = head;

  while(curr1.data != a && curr1.next != null){
    prev1 = curr1;
    curr1 = next1;
    next1 = next1.next;
  }
  System.out.println(prev1.data + " " +curr1.data + " " + next1.data);
  Node curr2 = head;
  Node prev2 = null;
  Node next2 = head;

  while(curr2.data != b && curr2.next != null){
    prev2 = curr2;
    curr2 = next2;
    next2 = next2.next;
  }
  System.out.println(prev2.data+" "+ curr2.data+ " " + next2.data);


  if(curr1 == null || curr2 == null){
    return;
  }
  prev1.next = curr2;
  curr1.next = curr2.next;
  prev2.next = curr1;
  curr2.next = next1;

  


}

public static Node sortList(Node l1, Node l2){
  Node merge = new Node(-1);
  Node temp = merge;

  while(l1 != null && l2 != null){
    if(l1.data <= l2.data){
      temp.next = l1;
      l1  = l1.next;
      temp = temp.next;
    }else{
      temp.next = l2;
      l2 = l2.next;
      temp = temp.next;
    }
  }

  if(l1 != null){
    temp.next = l1;
  }
  if(l2 != null){
    temp.next = l2;
  }

  return merge.next;

}


public static Node sortAllList(Node[] arr, int last){
  while(last != 0){
    int i=0;
    int j=last;
    while(i < j){
      arr[i] = sortList(arr[i], arr[j]);

      i++;
      j--;
      if(i >= j){
        last = j;
      }
    }


  }
  return arr[0];
}



   




  public static void main(String[] args) {
    // LinkedList ll = new LinkedList();
    // ll.addFirst(1);
    // ll.addFirst(2);
    // ll.addFirst(1);
    // // ll.addMiddle(2,3);
    // ll.print();
    // // System.out.println(ll.recursiveSearch(3) + "yea");
    // // ll.reverseIterative();
    // // ll.print();
    // if(ll.checkPalimdromefandS()){
    //   System.out.println("Palindrome");
    // }else{
    //   System.out.println("Not a Palindrome");
    // }
    // LinkedList li = new LinkedList();
    // li.addFirst(1);
    // li.addFirst(2);

    // li.addFirst(3);
    // li.addFirst(4);
    // li.addFirst(5);
    // li.addFirst(6);
    // li.addFirst(7);
    // li.addFirst(8);
    // li.print(li.head);

    // // li.addMiddle(2,9);
    // // li.deleteNNodesAfterMNodes(li.head, 2, 2);
    // li.swapTwoNumbers(4, 2);

    // li.print(li.head);
    int k = 3;
    int n = 4;
    Node arr[] = new Node[k];
    arr[0] = new Node(1);
    arr[0].next = new Node(3);
    arr[0].next.next = new Node(5);
    arr[0].next.next.next = new Node(7);

    arr[1] = new Node(2);
    arr[1].next = new Node(4);
    arr[1].next.next = new Node(6);
    arr[1].next.next.next = new Node(8);

    arr[2] = new Node(0);
    arr[2].next = new Node(9);
    arr[2].next.next = new Node(10);
    arr[2].next.next.next = new Node(11);
    Node head = sortAllList(arr, k - 1);
    // Node sort = sortList(arr[0], arr[1]);

    LinkedList li = new LinkedList();
    li.print(head);

    // Node head = new Node(10);
    // head.next = new Node(20);   
    // head.next.next = li.head.next.next; //merge point
    // findMergepoint(head, li.head);
    
        // Node heady = li.mergeUsingLL(li.head);
        // li.print(heady);
        // Node zigzag = li.zigzag(heady);
        // li.print(zigzag);

    // ll.print();
    // System.out.println(ll.size);
    // ll.removeFirst();
    // ll.print();
    // System.out.println(ll.size);
    // ll.removeLast();
    // ll.print();
    // System.out.println(ll.size);

  }
}