class compressString{
  public static String compressString(String str){
        StringBuilder str2=new StringBuilder();

          
        for(int i=0;i<str.length();i++){
            int count=1;  
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            str2.append(str.charAt(i));
            str2.append(count);
        }
        return str2.toString();

    }
}