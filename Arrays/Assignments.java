class Assignment{
  
  public static void findingTargetInRotatedArray(int arr[],int target){ //O(n^2)
        int min=binary(arr);

        int res=0;
        if(target>=arr[min] && target<arr[arr.length-1]){
            res=binarysearch(arr,min+1,arr.length-1,target);
        }else{
            res=binarysearch(arr,0,min,target);
        }
        System.out.println(res);

       


        
    }
    // O(log(n))
    public static int binarysearch(int arr[],int left,int right,int target){
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return -1;
    }


    public static int binary(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if( mid > 0 && arr[mid]<arr[mid-1]){
                return mid;
            }else if(arr[left]<=arr[mid] && arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left;

    }



    



}