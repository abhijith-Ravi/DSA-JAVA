
class StackUsingLinkedList
{
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  static class Stack {
    static Node top = null;

    public boolean isEmpty(){
      return top == null;
    }

    public void push(int data) {
      Node newNode = new Node(data);
      if(top == null){
        top = newNode;
      }else{
        newNode.next = top;
        top = newNode;
      }
    }
    public int pop() {
      if(isEmpty()){
        System.out.println("Stack is empty");
        return -1;
      }
      int popped = top.data;
      top = top.next;
      return popped;
    }

    public int peek() {
      if(isEmpty()) {
        System.out.println("Stack is empty");
        return -1;
      } else {
        return top.data;
      }
    }


    
    

  }
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    } 
  }
}