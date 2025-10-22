import java.util.Stack;

class StackProblems {

  public static void pushAtBottom(Stack<Integer> st, int data) {
    if(st.isEmpty()) {
      st.push(data);
      return;
    }
    int top = st.pop();
    pushAtBottom(st, data);
    st.push(top);
  }

  // public static void reverseString(String str, Stack<Character> st) {
  //   if(str.length() == 0) {
  //     return;
  //   }
  //   st.push(str.charAt(0));
  //   reverseString(str.substring(1), st);
    


  // }
  public static String reverseString(String str){
    Stack<Character> st = new Stack<>();
    for(int i=0; i<str.length(); i++){
      st.push(str.charAt(i) );
    }
    StringBuilder sb = new StringBuilder("");
    while(!st.isEmpty()){
      sb.append(st.pop());
    }
    return sb.toString();
  }

  public static void reverseStack(Stack<Integer> st) {
    if(st.isEmpty()) {
      return;
    }else{
      int top = st.pop();
      reverseStack(st);
      pushAtBottom(st, top);
    }
  }


  public static void stockSpan(int[] prices){
    int n = prices.length;
    int[] span = new int[n];
    
    Stack<Integer> st = new Stack<>();
    span[0] = 1;
    st.push(0);
    for(int i=1; i<n; i++){
      while(!st.isEmpty() && prices[i] >= prices[st.peek()]){
        st.pop();
      }
      span[i] = st.isEmpty() ? i+1 : i - st.peek();
      st.push(i);
    }
    for(int i=0; i<n; i++){
      System.out.print(span[i] + " ");
    }
  }

  public static void nextGreaterRight(int[] arr){
    int n = arr.length;
    int[] res = new int[n];
    Stack<Integer> st = new Stack<>();
    for(int i=n-1; i>=0; i--){
      while(!st.isEmpty() && st.peek() <= arr[i]){
        st.pop();
      }
      res[i] = st.isEmpty() ? -1 : st.peek();
      st.push(arr[i]);
    }
    for(int i=0; i<n; i++){
      System.out.print(res[i] + " ");
    }
  }

  public static void main(String[] args) {
      // Stack<Integer> st = new Stack<>();
      // st.push(1);
      // st.push(2);
      // st.push(3);

      // reverseStack(st);

      // while(!st.isEmpty()) {
      //   System.out.println(st.pop());
      // }

      // System.out.println(reverseString("hello"));

      // int[] prices = {100, 80, 60, 70, 60, 75, 85, 100};
      // stockSpan(prices);

      int[] arr = {2, 1, 5, 3, 4};
      nextGreaterRight(arr);
  }
}