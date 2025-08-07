
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
}



