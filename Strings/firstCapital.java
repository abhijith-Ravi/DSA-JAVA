class firstCapital{
  public static StringBuilder allFirstCapital(String str){
        StringBuilder str2=new StringBuilder();
        str2.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            str2.append(str.charAt(i));
            if(str.charAt(i)==' '){
                str2.append(Character.toUpperCase(str.charAt(i+1)));
                i++;
            }
        }
        return str2;
    }
}