class diagonalSum{
  public static void diagonalSum(int arr[][]){
    // O(1)
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-1-i){
                sum+=arr[i][arr.length-1-i];
            }

        }
        System.out.println(sum);

    }
}