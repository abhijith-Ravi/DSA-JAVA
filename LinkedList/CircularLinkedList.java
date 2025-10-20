class CircularLinkedList {
    // private Node head;
    static Node tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    

    public static void addFirst(int data){
      Node newNode = new Node(data);
      if(tail == null){
        tail = newNode;
        tail.next = tail;
      }else{
        newNode.next = tail.next;
        tail.next = newNode;
        // tail = newNode;
      }
    }

    public void addLast(int data){
      Node newNode = new Node(data);
      if(tail == null){
        tail = newNode;
        tail.next = tail; 
    }else{
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
      }
    }

    public void addMiddle(int data, int position){
      Node newNode = new Node(data);
      if(tail == null){
        tail = newNode;
        tail.next = tail;
      }else{
        Node current = tail.next;
        for(int i=0; i<position-1; i++){
          current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

      }
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        do{
            current = current.next;
            System.out.print(current.data + " ");
        } while (current != tail);
        System.out.println();
    }

    public void deleteNode(int key){
      Node current = tail;
      Node prev = null;
      if(tail == null){
        System.out.println("List is empty");
        return;
      }
      while(current.data != key){
        if(current.next == tail){
          System.out.println("Node not found");
          return;
        }
        prev = current;
        current = current.next;
      }
      prev.next = current.next;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addFirst(10);
        cll.addFirst(20);
        cll.addFirst(30);
        cll.addLast(10);
        cll.addLast(20);
        cll.addLast(30);
        cll.addMiddle(25, 3);
        cll.display(); // Output: 30 20 10
        cll.deleteNode(25);
        cll.deleteNode(20);


        cll.display();

    }
}