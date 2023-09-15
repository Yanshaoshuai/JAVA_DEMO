package com.javademo.base.algorithm.leetcode.problems.recursive;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 14:11
 **/
public class Solution200 {
    /**
     * 方向数组
     */
    private int[][] direction=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int row;
    private int column;
    private boolean[][] visited;
    /**
     * 检查是否越界
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x>=0&&x<row&&y>=0&&y<column;
    }
    /**
     * flood fill算法
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        row=grid.length;
        column=grid[0].length;
        visited=new boolean[row][column];
        int result=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j]=='1'&&!visited[i][j]){//遍历每个没有访问过的'1'点
                    result++;//找到新岛屿
                    //对相邻陆地标记
                    floodFill(grid,i,j);
                }
            }
        }
        return result;
    }

    /**
     * 标记相邻陆地
     * @param grid
     * @param i
     * @param j
     */
    private void floodFill(char[][] grid, int i, int j) {
        visited[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int  newX=i+direction[k][0];
            int  newY=j+direction[k][1];
            if(inArea(newX,newY)&&!visited[newX][newY]&&grid[newX][newY]=='1'){
                floodFill(grid,newX,newY);
            }
        }
    }

    public static void main(String[] args) {
        Solution200 solution200=new Solution200();
        int numIslands = solution200.numIslands(new char[][]{
                  {'1', '1', '1', '1', '0'}
                , {'1', '1', '0', '1', '0'}
                , {'1', '1', '0', '0', '0'}
                , {'0', '0', '0', '0', '1'}
        });
        System.out.println(numIslands);
    }
}
