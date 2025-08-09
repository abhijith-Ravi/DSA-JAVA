class directionPath{
  public static void directionPath(String str){
        int j=0;
        int i=0;
        for(int k=0;k<str.length();k++){
            switch(str.charAt(k)){
            case 'W' -> i--;
            case 'N' -> j++;
            case 'E' -> i++;
            case 'S' -> j--;
            default -> {
                }
            }
            System.out.println(i+ " "+j);
        }
        double distance=Math.sqrt(Math.pow(i,2)+Math.pow(j,2));
        System.out.println(distance);
    }

}