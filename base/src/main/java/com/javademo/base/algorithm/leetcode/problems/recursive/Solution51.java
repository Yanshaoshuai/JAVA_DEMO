package com.javademo.base.algorithm.leetcode.problems.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /14 14:38
 **/
public class Solution51 {
    private List<List<String>> result=new LinkedList<>();
    private boolean[] col,dia1,dia2;//列 正对角线 反对角线
    public List<List<String>> solveNQueens(int n) {
        col=new boolean[n];
        dia1=new boolean[2*n-1];//有2n减1条对角线
        dia2=new boolean[2*n-1];
        putQueen(n,0,new LinkedList<Integer>());
        return result;
    }

    /**
     * 尝试在一个n皇后问题中,摆放第row行的皇后问题
     * @param n
     * @param row
     * @param solve
     */
    private void putQueen(int n,int row, LinkedList<Integer> solve){
        if(row==n){//找到一个解
            result.add(generateBoard(n,solve));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!col[i]&&!dia1[row+i]&&!dia2[row-i+n-1]){//第i列没被占用 且该位置所在对角线没被占用
                solve.add(i);//保存第row行的列坐标
                col[i]=true;
                dia1[row+i]=true;
                dia2[row-i+n-1]=true;
                putQueen(n,row+1,solve);
                col[i]=false;
                dia1[row+i]=false;
                dia2[row-i+n-1]=false;
                solve.removeLast();
            }
        }
        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> solve) {
        if(solve.size()!=n){
            return null;
        }
        List<String> resultSolve=new LinkedList<>();
       char[][] board=new char[n][n];
        for (int i = 0; i < board.length; i++) {//构造棋盘
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]='.';
            }
        }
        for (int i = 0; i < n; i++) {//把第i行的对应列放置一个皇后 Q
            board[i][solve.get(i)]='Q';
        }
        for (int i = 0; i <board.length; i++) {//保存一个解棋盘
            resultSolve.add(new String(board[i]));
        }
        return resultSolve;
    }

    public static void main(String[] args) {
        Solution51 solution51=new Solution51();
        List<List<String>> result = solution51.solveNQueens(100);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("----------solve"+i+"--------------");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
        }
    }
}
