package Demo;

import java.util.Scanner;

//Problem Stmt: 
//Fibanacii Series: 0 1 1 2 3 5 ...


public class Demo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter count: ");
		int count = sc.nextInt();
		
		int a =0;
		int b=1;
		int c = 0;
		
		System.out.println();
		System.out.print(a);
		System.out.print(" "+b);
		
		for(int i=0;i<count;i++) {
			c = a + b;
			System.out.print(" "+c);
			a = b;
			b = c;
		}
	}
}
