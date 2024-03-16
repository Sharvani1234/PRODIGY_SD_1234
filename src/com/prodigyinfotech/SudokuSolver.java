package com.prodigyinfotech;

public class SudokuSolver{
	private static final int SIZE=9;
	private static final int EMPTY=0;
	
	public static boolean solveSudoku(int[][]grid) {
		int row=0;
		int col=0;
		
		boolean isEmpty=true;
		for(int i=0;i<SIZE && isEmpty;i++) {
			for(int j=0;j<SIZE && isEmpty;j++) {
				if(grid[i][j]==EMPTY) {
					row=i;
					col=j;
					isEmpty=false;
				}
			}
		}
		
		if(isEmpty) {
			return true;
		}
		
		for(int num=1;num<=SIZE;num++) {
			if(isSafe(grid,row,col,num)) {
				grid[row][col]=num;
				
				if(solveSudoku(grid)) {
					return true;
				}
				
				grid[row][col]=EMPTY;
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][]grid,int row,int col,int num) {
		return !usedInRow(grid,row,num)&&
				!usedInColumn(grid,col,num)&&
				!usedInBox(grid,row-row%3,col-col%3,num);
	}
	
	private static boolean usedInRow(int[][]grid,int row,int num) {
		for(int col=0;col<SIZE;col++) {
			if(grid[row][col]==num) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean usedInColumn(int[][]grid,int col,int num) {
		for(int row=0;row<SIZE;row++) {
			if(grid[row][col]==num) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean usedInBox(int[][]grid,int boxStartRow,int boxStartCol,int num) {
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				if(grid[row+boxStartRow][col+boxStartCol]==num) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void printGrid(int[][]grid) {
		for(int row=0;row<SIZE;row++) {
			for(int col=0;col<SIZE;col++) {
				System.out.print(grid[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][]grid= {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
		};
		
		if(solveSudoku(grid)) {
			System.out.println("Sudoku solved successfully:");
			printGrid(grid);
		}
		else {
			System.out.println("No solution exists for the given sudoku puzzle.");
		}
	}
}