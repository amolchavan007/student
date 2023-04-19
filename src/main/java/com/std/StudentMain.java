package com.std;


import java.util.Iterator;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentIUD s=new StudentIUD();
		for (; ; ) {
			System.out.println("chouse your option\n");
		
			System.out.println("1.Insert Student\t2.Update Stusent\t3.Remove Student\t4.View Student\t\t5.All Data View\t\t6.Exit");
			int ch=sc.nextInt();
			switch (ch) {
			case 1:s.Insetr();	
			break;
			
			case 2:s.Update();
			break;
			
			case 3:s.Delete();
			break;
			
			case 4:s.Display();
			break;

			case 5:s.AllDataView();
			break;

			case 6:System.exit(0);
			
			
			}
		}
	
	}
}
