public class allBitmanipulation{
  public static void addOneBit(int num){
        System.out.print(-(~num));
    }

    public static void toUpperCaseByBitsOrLower(char ch){
        if((ch & 1<<5) ==0){
            System.out.print( (char)(ch | 1<<5) );
        }else{
            System.out.print( (char)(ch & ~(1<<5)) );
        }
        
    }


    public static void powerOfTheNumberByBits(int num,int pow){
        int ans=1;
        while(pow>0){
            if((pow&1) == 1){
                ans*=num;
            }
            num=num*num;
            pow=pow>>1;
        }
        System.out.print(ans);
    }


    public static void countSetBits(int num){
        int count=0;
        while(num>0){
            if((num & 1 )!= 0){
                count++;
            }
            num=num>>1;
        }
        System.out.print(count);


    }

    public static void checkPowerOfTwo(int num){
        int ans = (num & num-1);
        if(ans==0){
            System.out.println("power of 2");

        }else{
            System.out.println("not a power of 2");

        }
    }

    public static void clearRangeOfBits(int num,int i,int j){
        // int bitMask=(~0)<<i-j;
        // bitMask=~(bitMask);
        // bitMask=bitMask<<j;
        // bitMask=~(bitMask);

        int bitMask= ((~0<<i) | (1<<j)-1);



        System.out.print( bitMask & num );

    }


    public static void clearLastBit(int num,int i){
        int bitMask=-1<<i;
        System.out.print(num & bitMask);
    }

    public static int updateIthBt(int num,int i,int value){
        // if(value==0){
        //      clearIthBit(num,i);
        // }else{
        //      setIthBit(num,i);
        // }


        int clear=clearIthBit(num,i);
        int bit=value<<i;
        System.out.print(clear | bit);
        return ( clear | bit );

    }


    public static int clearIthBit(int num,int i){
        int bitMask=~(1<<i);
        System.out.print(num & bitMask);
        return num & bitMask;


    }

    public static void setIthBit(int num,int i){
        int bitMask=1<<i;
        System.out.print(num | bitMask);
    }

    public static void getIthBit(int num,int i){
        int bitMask=1<<i;
        System.out.print(num & bitMask);
        if((num & bitMask)==num){
            System.out.print("t");
        }else{
            System.out.print("f");
        }
    }
}