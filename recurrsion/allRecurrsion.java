class allRecurrsion{
  
    public static int optimizedfindPowerUsingRecurr(int x,int n){
        System.out.println(x+" "+n);
        if(n==0){
            return 1;
        }
        int halfpower=optimizedfindPowerUsingRecurr(x,n/2);
        int num=halfpower*halfpower;
        if(n%2!=0){
            return x*num;
        }

        return num;
    }






    public static int findPowerUsingRecurr(int x,int power){
        if(power==0){
            return 1;

        }
        return x*findPowerUsingRecurr(x,power-1);
    }

    public static int lastocurrence(int[] arr,int x,int i ){
        if(i==0){
            return -1;
            
        }
        if(arr[i]==x){
            return i;
        }
        return lastocurrence(arr,x,--i);


    }
    public static int lastocurrence2(int[] arr,int x,int i ){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastocurrence2(arr,x,i+1);
        System.out.println(i+" "+isFound);
        if(isFound==-1&&arr[i]==x){
            return i;
        }
        return isFound;
    }

    
    public static int checkSort(int[] sort,int track){
        System.out.println(track);
        if(track==sort.length){
            return 1;
        }
        
        if(sort[track-1]>=sort[track]){
            return -1;
            
        }

        return checkSort(sort,++track);


        // return 1;
        

    }

    public static int firstOccurence(int arr[],int i,int x){

        if(arr[i]==x){
            return i;
        }
        if(i==arr.length-1){
            return -1;
        }



        return firstOccurence(arr,++i,x);

    }


    public static int fibo(int n,int[] arr){
        if(n==1 || n==0){
            return n;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        
        arr[n]=(fibo(n-1,arr)+fibo(n-2,arr));
        
        return arr[n];
    }



    public static int  printSumN(int n){
        if(n==1){
            return 1;
        }
        return printSumN(n-1)+n;

    }


    public static void printforward(int n){
        if(n==0){
            return;
        }
        printforward(n-1);
        System.out.println(n);
    }


    public static void printBackNum(int n){
        System.out.println(n);
        if(n==0){
            return ;
        }
        printBackNum(n-1);
    }
}