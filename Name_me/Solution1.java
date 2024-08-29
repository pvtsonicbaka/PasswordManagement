    class Solution1 {
        public static void main(String[] args) {
            int grid[][] = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
            Solution1 s = new Solution1();
            int a[][] =  s.largestLocal(grid);
            for(int i[] : a){
                for(int j:i){
                    System.out.print(j);
                }
                System.out.println();
            }
        }
        public int[][] largestLocal(int[][] grid) {
            int a[][] = new int[grid.length-2][grid.length-2];
            int temp[][] = new int[3][3];
            
            for(int i =0;i<grid.length-3;i++){
                for(int i2 =0;i2<grid.length-3;i2++){
                int max =0;
                for(int j = 0 ; j<3;j++){
                    for(int k = 0 ; k<3;k++){
                        if(max<grid[i][k])max = grid[j][k];
                        System.out.println(max);
                    }

                    a[i][i2] = max;
                    max=0;
                }
                }
            }

            return a;
        }
    }
    