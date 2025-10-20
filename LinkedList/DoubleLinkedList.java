class DoubleLinkedList {
    class Node{
      int data;
      Node next;
      Node prev;

      Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
      }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;


  public Node addFirst(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return head;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
    newNode.prev = null;
    return head;
  }

  public static Node reverseLL(Node head){
    Node curr = head;
    Node prev = null;
    Node next;

    while(curr != null){
      next = curr.next;
      curr.next = prev;
      curr.prev =next;
      prev = curr;
      curr = next;
    }
    return prev;

    

  }

  public static void print(Node heady){
    Node temp = heady;
    while(temp != null){
      System.out.print(temp.data + "<->");
      temp = temp.next;
    }
    System.out.println("null");

  }

  public static void main(String[] args) {
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.addFirst(10);
    dll.addFirst(20);
    dll.addFirst(30);
    dll.addFirst(40);
    dll.print(dll.head);
    Node revHead = reverseLL(dll.head);
    dll.print(revHead);
    // Further testing can be done here
  }


    // Methods to add, remove, and display nodes can be added here
}