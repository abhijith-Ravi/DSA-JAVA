
import java.util.ArrayList;
import java.util.Collections;

class AllArrayList { 
  public static ArrayList<Integer> beautifulArrayList(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i=2; i<=n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer ele : ans){
                if(2*ele <= n){
                    temp.add(2*ele);
                }
            }
            for(Integer ele : ans){
                if(2*ele - 1 <= n){
                    temp.add(2*ele - 1);
                }
            }
            ans = temp;
        }
        return ans;
    }

    public static void beautifulArrayListDandq(int start, int increment, ArrayList<Integer> arr, int n){
        if(start > n)return;
        if(start + increment > n){
            arr.add(start);
            return;
        }
        beautifulArrayListDandq(start, 2*increment, arr, n);
        beautifulArrayListDandq(start + increment, 2*increment, arr, n);
    }

    public static ArrayList<Integer> lonelyNumAno(ArrayList<Integer> arr){

        //O(n)
        Collections.sort(arr);
        ArrayList<Integer> larr = new ArrayList<>();
        for(int i=1; i<arr.size()-1; i++){
            if( arr.get(i-1) + 1 < arr.get(i) && arr.get(i) + 1 < arr.get(i+1) ){
                larr.add(arr.get(i));
            }
        }

        if(arr.size() == 1){
            larr.add(arr.get(0));
        }

        if(arr.size() > 1){
            if(arr.get(0) + 1 > arr.get(1)){
                larr.add(arr.get(0));
            }
            if(arr.get(arr.size()-1) - 1 < arr.get(arr.size() - 2)){
                larr.add(arr.get(arr.size()-1));
            }
        }
        return larr;
    }

    public static int frequncyOfnext(ArrayList<Integer> arr, int key){
        int[] count = new int[1001];

        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) == key){
                count[arr.get(i+1)]++;
            }
        } 

        int max = Integer.MIN_VALUE;
        int index = 0;

        for(int i=0; i<1001; i++){
            if(count[i] > max){
                max = count[i];
                index = i;
            }
        }
        return index;


    }



    public static ArrayList<Integer> lonelyNum(ArrayList<Integer> arr){

        //O(n^2)
        ArrayList<Integer> larr = new ArrayList<>();
        for(int i=0; i<arr.size(); i++){
            int lone = arr.get(i);
            int left = lone - 1;
            int right = lone + 1;
            System.out.println( left + " " + lone + " " + right);
            boolean isThere = false;
            for(int j=0; j<arr.size(); j++){
                if(arr.get(j) == lone || left == arr.get(j) || right == arr.get(j) ){
                    if( i != j){
                        isThere = true;
                    }
                }
            }
            if(!isThere){
                larr.add(lone);
            }
        }
        return larr;
    }

    public static boolean monotonicNum(ArrayList<Integer> arr){
        boolean incr = true;
        boolean decr = true;

        for(int i=0 ;i<arr.size()-1; i++){
            if(arr.get(i) > arr.get(i+1)){
                incr = false;
            }else{
                decr = false;
            }


        }
        return incr || decr;
    }



    public static int  raintMostWaterTraped(int[] arr){

        //O(n^2)
        int max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int rain = Math.min(arr[i], arr[j]) * (j - i);
                if(rain > max ){
                    max = rain;
                }

            }
        }
        return max;
    }

    public static int raintMostWaterTraped2p(int[] arr){

        //O(n)
        int max = Integer.MIN_VALUE;
        int j = arr.length - 1;
        int i = 0;

        while(i < j){
            int rain = Math.min(arr[i], arr[j]) * (j - i);
            if(rain > max){
                max = rain;
            }    
            if(arr[i] < arr[j]){
                i++;
            }else{
                j--;
            }        
        }
        return max;

    } 

    public static boolean pairSum2p(ArrayList<Integer> li, int target){
        int i = 0;
        int j = li.size() - 1;

        while(i < j){
            int sum = li.get(i) + li.get(j);

            if(sum == target){
                return true;
            }

            if( sum > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    public static boolean pairSum2WithRotated(ArrayList<Integer> li, int target){
        int i = 0;
        int j = 0;

        //pivot
        for(int k=1; k<li.size(); k++){
            if(li.get(k) < li.get(k-1)){
                i = k;
                j = k-1;
                break;
            }
        }
        int n = li.size(); 


        while(i != j){
            int sum = li.get(i) + li.get(j);
            System.out.println(i + " " + j);

            System.out.println(sum);
            if(sum == target){
                return true;
            }
            
            if( sum > target){
                j = (j - 1 + n) % n;
            }else{
                i = (i + 1) % n;
            }
            // if(j == 0){
            //     j = li.size() - 1;

            // }
            // if(i == li.size() - 1){
            //     i = 0;
            // }
        }
        return false;

    }
}