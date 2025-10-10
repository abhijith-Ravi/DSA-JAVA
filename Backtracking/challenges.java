class challenges {
   static int[] row = {0, 1, 0, -1};
    static int[] col = {1, 0, -1, 0};

    static int countpath = 0;


    public static boolean isSafePath(int arr[][], int i, int j,boolean[][] visited){
        if(i < 0 || j < 0 || i >= arr.length ||  j >= arr[0].length || arr[i][j] == 0 || visited[i][j]){
            return false;
        }
        
        return true;
    }

    public static void ratPath(int[][] arr, int i, int j,boolean[][] visited){
    // base case: reached bottom-right
    if(i == arr.length -1 && j == arr[0].length -1){
         visited[i][j] = true; // mark destination as visited
        printsuduku(visited);
        // visited[i][j] = false; // backtrack
        countpath++;
        return ;
    }

    // mark current cell as visited
    visited[i][j] = true;

    // explore all 4 directions
    for(int p = 0; p < 4; p++){
        int nextr = i + row[p];
        int nextc = j + col[p];

        if(isSafePath(arr,nextr,nextc,visited)){
            ratPath(arr, nextr, nextc,visited);
                // return true;
            
        }
    }

    // backtrack: unmark current cell
    visited[i][j] = false;

    // return false;
    }





    static String[] allnumchar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public static void phoneButton(int n, String empstr){
        //base
        if(n == 0){
            System.out.println(empstr);
            return;
        }


            int m = n%10;


        //recur
        for(int i=0; i<3; i++){
            char strsub = allnumchar[m].charAt(i);
           

            phoneButton(n/10, empstr+strsub);
        }
    }




    static int[] movex = {2, -2, -2, 2, 1, -1, -1, 1};
    static int[] movey = {1, 1, -1, -1, 2, 2, -2, -2};


    public static boolean isSafe(int nextx, int nexty, int[][] arr){
        return (nextx >= 0 && nextx < arr[0].length && nexty >=0 && nexty < arr.length && arr[nextx][nexty] == -1);
    } 




    public static boolean nknight(int[][] arr, int i, int j, int movei){
        //base
        if(movei == (arr.length*arr.length)){
            return true;
        }


        //recur
        for(int d=0; d<=7; d++){
            int nextx = i + movex[d];
            int nexty = j + movey[d];

            if(isSafe(nextx,nexty,arr)){
                arr[nextx][nexty] = movei;
                if(nknight(arr, nextx, nexty, movei+1)){
                    return true;
                }else{
                    arr[nextx][nexty] = -1;
                }

            }

        }
        return false;
    }


    static int count = 0;
    public static void printsuduku(boolean[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean issafe(int[][] arr,int i, int j,int digit){
        //column
        for(int l=0; l<9; l++){
            if(arr[l][j] == digit){
                return false;
            }
        }
        //row
        for(int p=0; p<9; p++){
            if(arr[i][p] == digit){
                return false;
            }
        }
        // 0 - 2
        // 3 - 5
        // 6 - 8
        int row = (i/3)*3;
        int column = (j/3)*3;

        for(int q=row; q<row+3; q++){
            for(int w=column; w<column+3; w++){
                if(arr[q][w] == digit){
                    return false;
                }
            }

        }
        return true;

    }


    public static boolean suduku(int[][] arr, int i, int j){
        //base
        if(i == 9 && j == 9){
            return true;
        }else if(i == 9){
            return true;
        }


        //recurr
        int row=i;
        int col=j+1;
        if(col == 9){
            row = row + 1;
            col = 0;
        }

        if(arr[i][j] != 0){
            return suduku(arr, row, col);
        }

        for(int d=1; d<=9; d++){
            if(issafe(arr,i, j,d)){
                arr[i][j] = d;
                if(suduku(arr, row, col)){
                    return true;
                }
                arr[i][j] = 0;
                
            }
        }
        return false;
    }


    public static int matrixpathszeroton(int[][] arr, int i, int j){
        //base
        if(j == arr[0].length || i == arr.length){
            return 0;
        }
        if(j == arr[0].length-1 && i == arr.length-1){
            return 1;
        }
        

        //recurr 
        //right
        int right = matrixpathszeroton(arr,i,j+1);
        //down
        int left = matrixpathszeroton(arr,i+1,j);

        return right+left;




    }
    
}