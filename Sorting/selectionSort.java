class selectionSort{
  public static void selectionSort(int arr[]){

        // O(n^2)
        int min=0;
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            // System.out.println(min);

            // System.out.println(arr[i]+ " "+ arr[min]);
            // arr[i]=arr[i]+arr[min];
            // System.out.println(arr[i]+ " "+ arr[min]);

            // arr[min]=arr[i]-arr[min];
            // System.out.println(arr[i]+ " "+ arr[min]);

            // arr[i]=arr[i]-arr[min];
            // System.out.println(arr[i]+ " "+ arr[min]);

            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        

        }
       
       

        
    }
}