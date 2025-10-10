class allbacktracking{
  static int count = 0;
  public static void findpermutaion(String str, String permustr){

      //base
      if(str.length() == 0){
          System.out.println(permustr);
          return;
      }


      //recur
      for(int i=0; i<str.length(); i++){
          char curr = str.charAt(i);

          String newStr = str.substring(0,i)+str.substring(i+1);

          findpermutaion(newStr,permustr+curr);
      }
  }

  public static int check(int[][] arr, int row, int col){
      for(int i=0; i<row; i++){
          if(arr[i][col] == 1){
              return 0;
          }
      }
      for(int i=row ,j=col; i>=0 &&j>=0; j--, i--){
          if(arr[i][j] == 1){
              return 0;
          }
      }
      for(int i=row ,j=col; i>=0 &&j<arr[0].length; j++, i--){
          if(arr[i][j] == 1){
              return 0;
          }
      }
      return 1;


  }
  public static void printArr(int[][] arr){

      for (int i=0;i<arr.length ;i++ ) {
          for (int j=0; j<arr[i].length; j++ ) {
              System.out.print(arr[i][j]);
          }
          System.out.println();
      }

  }

        

  public static boolean nQueens(int[][] arr, int row){

      //base
      if(row == arr.length){
          
          printArr(arr);
          return true;
      }


      //recur
      for(int i=0; i<arr[row].length; i++){
          if(check(arr, row, i) == 1){
              arr[row][i] = 1;
              if(nQueens(arr, row+1)){
                  return true;
              }
          }
          arr[row][i] = 0;

      }
      return false;
  }

}