class spiralMatrix{
  public static void spiralMatrix(int arr[][]){
        int startrow=0;
        int endrow=arr.length-1;
        int startcol=0;
        int endcol=arr.length-1;

        while(startrow<=endrow && startcol<=endcol){
             for(int i=startcol;i<=endcol;i++){
                System.out.print(arr[startrow][i]+ " ");

             }
             for(int i=startrow+1;i<=endrow;i++){
                System.out.print(arr[i][endcol]+" ");
             }
             for(int i=endcol-1;i>=startcol;i--){
                if(startrow==endrow){
                    break;
                }
                System.out.print(arr[endrow][i]+" ");

             }
             for(int i=endrow-1;i>startrow;i--){
                if(startcol==endcol){
                    break;
                }
                System.out.print(arr[i][startcol]+" ");
             }
             startrow++;
             endrow--;
             startcol++;
             endcol--;

        }
    }
}