class alldivideandconquerplusassign{
  public static int invbruteforce(int[] num){
        int count = 0;
        for(int i=0; i<num.length-1; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[i] > num[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static int mergesort(int[] arr,int lo, int hi){
        int inv = 0;
        if(hi > lo){
            int mid = lo+(hi - lo)/2;
            inv = mergesort(arr, lo, mid);
            inv = inv + mergesort(arr, mid+1, hi);
            inv = inv +  merge2(arr, lo, mid, hi);


        }
        return inv;
    }

    public static int merge2(int[] arr, int si, int mid, int ei) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        int[] arrtemp = new int[ei - si + 1];
        int inv = 0;


        // Merge both halves
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                arrtemp[k++] = arr[i++];
            } else {
                arrtemp[k++] = arr[j++];
                inv = inv + (mid + 1 -i);


            }
        }

        // Copy remaining elements
        while (i <= mid) {
            arrtemp[k++] = arr[i++];
        }
        while (j <= ei) {  
            arrtemp[k++] = arr[j++];
        }

        // Copy back into original array
        for (int p = 0; p < arrtemp.length; p++) {  
            arr[si + p] = arrtemp[p];
        }
        return inv;
    }

    // public static int quicksortinv(int[] num, int lo, int hi, int count){
    //     int p = partition(num, count, lo, hi);
    //     quicksortinv(num, lo, p, count);
    //     quicksortinv(num, p+1, hi, count);
    //     return count;
    // }


    // public static int partition(int[] num, int count, int lo, int hi){
    //     int pivot = num[lo];
    //     int i = lo + 1;
    //     int j = hi;

    //     while(i<j){
    //         while(num[i] < pivot && i < j)i++;
    //         while(num[j] > pivot && j > i)j--;
    //         if(i <= j){
    //             int temp = num[i];
    //             num[i] = num[j];
    //             num[j] = temp;
    //             i++;j--;
    //             count++;
    //         }else{
    //             break;
    //         }

    //     }
    //     num[lo] = num[i];
    //     num[i] = pivot;
    //     return i;
    // }

    public static int count(int[] num, int num1, int lo, int hi){
        int count = 0;

        for(int i=lo; i<hi; i++){
            if(num[i] == num1){
                count++;
            }
        }
        return count;
    }


    public static int majorityeledaq(int[] num, int lo, int hi){

        if(lo == hi){
            return num[lo];
        }

        int mid = lo + (hi - lo)/2;
        int left = majorityeledaq(num, lo, mid);
        int right = majorityeledaq(num, mid+1, hi);

        if(left == right){
            return left;
        }

        int leftcount = count(num, left, lo, hi);
        int rightcount = count(num, right, lo, hi);

        int res = leftcount > rightcount ? left : right ;

        return res;



    }


    public static int majorityele(int[] ele){
        int count = 0;
        for(int i=0; i<ele.length; i++){
            count = 0;
            for(int j=0;j<ele.length; j++){
                if(ele[j] == ele[i]){
                    count++;
                }
            }
            if(count> ((ele.length)/2)){return ele[i];}
        }
        return -1;
    }



    public static int rotatedsortedsearch(int arr[],int tar,int si,int ei){
        if(si>ei){
            return -1;
        }


        int mid = si + ( ei - si ) / 2;

        if(arr[mid] == tar){
            return mid;
        }

        // case a : on line 1
        if(arr[si] <= arr[mid]){
            if(tar <= arr[mid] && arr[si] <= tar){
                return rotatedsortedsearch(arr,tar, si,mid-1 );
            }else{
                return rotatedsortedsearch(arr,tar, mid+1,ei );
            }

        }

        //case b : line 2
         else{
            if(tar >= arr[mid] && arr[ei] >= tar){
                return rotatedsortedsearch(arr,tar, mid+1, ei );
            }else{
                return rotatedsortedsearch(arr,tar, si,mid-1 );
            }

        }
        // return -1;

    }



    public static void sortusingmerge(String[] arr,int si, int ei){
        if( si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;

        sortusingmerge(arr,si, mid);
        sortusingmerge(arr,mid+1, ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(String[] arr, int si, int mid, int ei) {
    int i = si;
    int j = mid + 1;
    int k = 0;
    String[] arrtemp = new String[ei - si + 1];

    // Merge both halves
    while (i <= mid && j <= ei) {
        if (arr[i].compareTo(arr[j]) <= 0) {
            arrtemp[k++] = arr[i++];
        } else {
            arrtemp[k++] = arr[j++];
        }
    }

    // Copy remaining elements
    while (i <= mid) {
        arrtemp[k++] = arr[i++];
    }
    while (j <= ei) {   // ✅ fixed here
        arrtemp[k++] = arr[j++];
    }

    // Copy back into original array
    for (int p = 0; p < arrtemp.length; p++) {   // ✅ fixed loop
        arr[si + p] = arrtemp[p];
    }
}
  
}