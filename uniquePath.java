class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid.length==0||obstacleGrid[0][0]==1)
            return 0;

        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[] memo=new int[col];
        memo[0]=1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(obstacleGrid[i][j]==1){
                    memo[j]=0;
                }else{
                    if(j>0){
                        memo[j]+=memo[j-1];
                    }
                }
            }
        }
        return memo[col-1];

    }
}
