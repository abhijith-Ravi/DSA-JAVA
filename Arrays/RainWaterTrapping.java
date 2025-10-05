
class RainWaterTrapping{
public static void rainwatertrapping(int arr[]){
        int maxleft[]=new int[arr.length];
        maxleft[0]=arr[0];
        int maxright[]=new int[arr.length];

        int n=arr.length-1;
        maxright[n]=arr[n];



        for(int i=1; i<arr.length; i++ ){
            if(arr[i]<maxleft[i-1]){
                maxleft[i]=maxleft[i-1];
            }else{
                maxleft[i]=arr[i];
            }
        }

        for(int j=n-1;j>=0;j--){
            if(arr[j]<maxright[j+1]){
                maxright[j]=maxright[j+1];
            }else{
                maxright[j]=arr[j];
            }

        }

        for(int l=0;l<=n;l++){
            System.out.println(maxleft[l]+" "+maxright[l]);
        }

        int waterlevel=0;
        int sumOfTheWater=0;
        int width=1;

        for(int k=0; k<=n; k++){
            waterlevel=Math.min(maxleft[k],maxright[k]);
            if(waterlevel>arr[k]){
                sumOfTheWater+=(waterlevel-arr[k])*width;
            }
        }
        System.out.print(sumOfTheWater);


    }
    public static void main(String[] args) {
        int arr[]={0 ,1 ,0 ,2, 1, 0, 1, 3, 2, 1, 2, 1 };
        rainwatertrapping(arr);
        // int n=5;
        // int arr[]=new int[n+1];
        // System.out.println(fibo(n,arr));
        // printBackNum(5);
        // System.out.println(printSumN(5));
        // int arr[]={1,2,3,4,5};
        // System.out.println(firstOccurence(arr,0,6));
        // System.out.println(lastOccurence(arr,arr.length-1,6));
        // int arr[]={3,2,1};
        // System.out.println(sortedornot(arr,0));
        // System.out.println(power(2,5));
        // System.out.println(factorial(5));
        // System.out.println(sumOfDigits(1234));
        // System.out.println(countOfDigits(1234));
        // System.out.println(reverseANumber(1234));
        // System.out.println(palindrome(121));
        // System.out.println(productOfDigits(1234));
        // System.out.println(binaryToDecimal(1011));
        // System.out.println(octalToDecimal(17));
        // System.out.println(hexadecimalToDecimal("1A"));
        // System.out.println(gcd(12,15));
        // System.out.println(lcm(12,15));
        // towerOfHanoi(3,'A','C','B');
    }
}



