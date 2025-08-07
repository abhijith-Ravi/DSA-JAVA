class insertionSort{
  public static void insertionSort(int arr[]){
        // O(n^2)

        // for(int i=1;i<arr.length;i++){
        //     int jin=0;
        //     int curr=arr[i];
        //     for(int j=i-1;j>0;j--){
        //         if(curr<arr[j]){
        //             arr[j+1]=arr[j];
        //             jin=j-1;
        //         }
        //     }
        //     arr[jin]=curr;
        // }
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;        
        }
        // print(arr);

    }
}