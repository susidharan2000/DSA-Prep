package StackAndQueues.CelebrityProblem;


public class TheCelibertyProblem {
    //brute force approch
    public static void getCelebrity(int [][]know,int n){
        int [][] grid = new int [n+1][n+1];
        for(int i = 0;i<know.length;i++){
            int x = know[i][0];
            int y = know[i][1];
            grid[x][y] = 1;
        }
        int [] knowMe = new int[n+1];
        int [] knowYou = new int[n+1];
        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    knowYou[i]++;
                    knowMe[j]++;
                }
            }
        }
        int ans = -1;
        for(int i = 1;i<n;i++){
            if(knowYou[i] == 0 && knowMe[i] == n-1){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
    //optimal approch
    public static void getCelebrityOpt(int [][]know,int n){
        int [][] grid = new int [n+1][n+1];
        for(int i = 0;i<know.length;i++){
            int x = know[i][0];
            int y = know[i][1];
            grid[x][y] = 1;
        }
        int top = 1;
        int down = n;
        while(top<down){
            if(grid[top][down] == 0 && grid[down][top] == 0){
                top++;
                down--;
            }else if(grid[top][down] == 1){
                top++;
            }else if(grid[down][top] == 1){
                down--;
            }
        }
        int Celebrity = -1;
        if(top == down){
            Celebrity = top;
        }
        for(int i = 1;i<=n;i++){
            if(grid[i][Celebrity] == 0){
                if(i == Celebrity)continue;
                Celebrity = -1;
                break;
            }
            if(grid[Celebrity][i] == 1){
                Celebrity = -1;
                break;
            }
        }
        System.out.println(Celebrity);
    }
    public static void main(String[] args) {
        int [][] know = {{1,3},{2,3},{4,3}};
        int n = 4;
        //brute force approch
        getCelebrity(know,n);
        //optimal approch
        getCelebrityOpt(know,n);
    }
}

