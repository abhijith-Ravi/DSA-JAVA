class SubArray{



  public static void prefixprintsubarray(int arr[]){
        int max=0;
        int currsum=0;
        int prefixArr[]=new int[arr.length];
        for(int i=1; i<prefixArr.length; i++){
            prefixArr[i]=prefixArr[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                
                currsum= i==0 ? prefixArr[j] : prefixArr[j]-prefixArr[i-1];
                System.out.println(currsum);
                if(currsum>max){
                    max=currsum;
                }
                System.out.print("  ");
                System.out.println(max);
            }
            System.out.println();
        }
    }



  //subarray normal
  public static void printsubarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for (int k=i;k<=j ;k++ ) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();

            }
            System.out.println();
        }
    }



  //sum subarray normal
  public static void sumprintsubarray(int arr[]){
    int max=0;
    int sum=0;
    for(int i=0;i<arr.length;i++){
        for(int j=i;j<arr.length;j++){
            sum=0;
            for (int k=i;k<=j ;k++ ) {
                sum+=arr[k];
            }
            if(sum > max){
                max=sum;
            }

        }
    }
    System.out.print(max);
  }

}




