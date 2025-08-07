class buyandsellstock{
  public static void buyandsellstock(int arr[]){

        int buystock=Integer.MAX_VALUE;
        int maxprice=0;


        for (int i=0;i<arr.length; i++){
            if(buystock<arr[i]){
                int profit=arr[i]-buystock;
                maxprice=Math.max(profit,maxprice);

            }else{
                buystock=arr[i];
            }

        }
        System.out.print(maxprice);
    }
}


//O(n)

