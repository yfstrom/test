package com.util.math;

import java.util.Scanner;

/**
 * 数独计算
 * @author llmf
 *
 */
public class SudoKuCale {

	static int result = 0; // 结果数
/*
	public static void main(String[] args) {

		int[][] a = new int[9][9];

		System.out.println("请输入数独中的原始数据，没有数据的用0代替...");
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			System.out.print("请输入第" + (i + 1) + "行的9个数：");
			for (int j = 0; j < 9; j++)
				a[i][j] = scanner.nextInt();
			// scanf("%d",&a[i][j]);
		}

		System.out.println();
		System.out.println();

		Sudoku(a, 0);
		if (result == 0)
			System.out.print("此数独无解!");

	}
*/
	// 输出可行的解
	public static void print(int[][] a) {
		result++;

		System.out.println("第" + result + "个填法为：");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				System.out.print(a[i][j]);

				if ((j == 2) || (j == 5))
					System.out.print("  ");
			}

			System.out.println();
			if ((i == 2) || (i == 5))
				System.out.println();

		}
		System.out.println();
	}

	// 判断是否可以将第i行、第j列的数设为k
	public static boolean check(int[][] a, int i, int j, int k) {

		int m, n;
		// 判断行
		for (n = 0; n < 9; n++) {
			if (a[i][n] == k)
				return false;
		}
		// 判断列
		for (m = 0; m < 9; m++) {
			if (a[m][j] == k)
				return false;
		}
		// 判断所在小九宫格
		int t1 = (i / 3) * 3, t2 = (j / 3) * 3;
		for (m = t1; m < t1 + 3; m++) {
			for (n = t2; n < t2 + 3; n++) {
				if (a[m][n] == k)
					return false;
			}
		}
		// 可行，返回true
		return true;
	}

	// 数独求解函数
	public static void Sudoku(int[][] a, int n) {
		int[][] temp = new int[9][9];

		int i, j;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++)
				temp[i][j] = a[i][j];
		}
		i = n / 9;
		j = n % 9; // 求出第n个数的行数和列数
		// 已经有原始数据
		if (a[i][j] != 0) {
			if (n == 80) // 是最后一个格子，输出可行解
				print(temp);
			else // 不是最后一个格子，求下一个格子
				Sudoku(temp, n + 1);
		}
		// 没有数据
		else {
			for (int k = 1; k <= 9; k++) {
				boolean flag = check(temp, i, j, k);
				if (flag) // 第i行、第j列可以是k
				{
					temp[i][j] = k; // 设为k
					if (n == 80)
						print(temp);
					else
						Sudoku(temp, n + 1);
					temp[i][j] = 0; // 恢复为0，判断下一个k
				}
			}
		}
	}

}

