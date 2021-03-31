package io;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("정수 1 입력");
		int first = key.nextInt();
		System.out.println("정수 2 입력");
		int second = key.nextInt();
		System.out.println(first+second);
		key.nextLine();
		
		System.out.println("한글문자열 입력");
		String word = key.nextLine();
		System.out.println(word);
	}

}
