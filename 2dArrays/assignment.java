class assignment{
  public static int sevenCount(int arr[][]){
        int count=0;

        for (int i=0;i<arr.length ;i++ ) {
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==7){
                    count++;
                }
            }
            
        }
        return count;
    }

    public static void transpose(int arr[][]){
        int newarr[][]=new int[arr[0].length][arr.length];


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                newarr[j][i]=arr[i][j];
                // System.out.println(i+" "+j+" "+newarr[j][i]+" "+arr[i][j]);

            }
        }
        // print2d(newarr);
    } 
}