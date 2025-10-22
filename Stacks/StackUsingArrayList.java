import java.util.ArrayList;

class StackUsingArrayList 
{
  static class Stack {
    ArrayList<Integer> list = new ArrayList<>();

    public void push(int data) {
      list.add(data);
    }
    public boolean isEmpty(){
      return list.size() == 0;
    }

    public int pop(){
      if(isEmpty()){
        System.out.println("Stack is empty");
        return -1;
      }
      int top = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return top;
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