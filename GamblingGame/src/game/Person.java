package game;

import java.util.Scanner;

public class Person {
	private String name;
	private Scanner scan = new Scanner(System.in);
	public Person(String name) {
		this.name = name;
	}
	public String getName() {return name;}
	public void getEnterKey() {
		scan.nextLine();
	} 
	public boolean turn() {
		System.out.print("[" + name + "]:<Enter>");			
		getEnterKey();
		
		int num[] = new int [3];
		 
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*3 + 1);
		}
		
		System.out.print("\t");
		for (int i=0; i<num.length; i++) {
			System.out.print(num[i]+"   ");
		}
	
		boolean result = true;
		for (int i=0; i<num.length; i++) {
			if (num[i] != num[0]) { 
				result = false;
				break;
			}
		}
		
		return result;
	}
}
