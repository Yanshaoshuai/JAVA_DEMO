package com.javademo.base.algorithm.leetcode.problems.recursive;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /13 21:45
 **/
public class Solution79 {
    /**
     * 方向数组
     */
    private int[][] direction=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int row;
    private int column;
    private boolean[][] visited;
    /**
     * 从board[startX,startY]开始寻找word[index...word.size()]
     * @param board
     * @param word
     * @param index
     * @param startX
     * @param startY
     * @return
     */
    private boolean searchWord(char[][] board,String word,int index ,int startX,int startY){
        if(index==word.length()-1){//最后一个字符 返回是否相等
            return board[startX][startY]==word.charAt(index);
        }
        if(board[startX][startY]==word.charAt(index)){//此次字符相等才继续在周围找下一个
            visited[startX][startY]=true;//每次在路径上的要标记为以访问
            for (int i = 0; i < 4; i++) {//遍历四个方向
                int newX=startX+direction[i][0];
                int newY=startY+direction[i][1];
                if(inArea(newX,newY)&&!visited[newX][newY]){//如果数组没越界且新节点没访问
                    if(searchWord(board,word,index+1,newX,newY)){//递归以新节点开始寻找 如果找到了就返回true
                        return true;
                    }
                }
            }
            visited[startX][startY]=false;//四个方向都尝试过且没有找到就把当前节点置为未访问 以供下一次访问
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x>=0&&x<row&&y>=0&&y<column;
    }

    /**
     * 函数入口
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board==null&&board.length==0||word==null){
            return false;
        }
        row=board.length;//行 X
        column=board[0].length;//列 Y
        visited=new boolean[row][column];
        for (int i = 0; i < board.length; i++) {//从board[i][j]开始寻找
            for (int j = 0; j < board[i].length; j++) {
                if(searchWord(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}
