import java.io.*;
import java.util.*;

public class quiz_8 {
	private File getFile = null;
	Vector<String> lineVector = new Vector<String>();
	
	public quiz_8() { }
	
	private void read(String file) {
		getFile = new File(file);
		try {
			Scanner fscan = new Scanner(new FileReader(getFile));
			while(fscan.hasNext()) {
				String line = fscan.nextLine();
				lineVector.add(line);
			}			
			fscan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Vector<Integer> search(String word) {
		Vector<Integer> noVector = new Vector<Integer>();
		for(int i=0; i<lineVector.size(); i++) {
			String line = lineVector.get(i);
			if(line.indexOf(word) != -1) 
				noVector.add(i);
		}
		
		return noVector;
	}

	private void print(Vector<Integer> noVector) {
		for(int i=0; i<noVector.size(); i++) {
			int lineNo = noVector.get(i);
			String line = lineVector.get(lineNo);
			System.out.println(lineNo + ":" + line);
		}
	}
	
	public void run() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		Scanner scan = new Scanner(System.in);
		String file = scan.nextLine();

		read(file);
		
		while(true) {
			System.out.print("검색할 단어나 문장>> ");
			String line = scan.nextLine();
			if(line.equals("그만"))
				break;
			Vector<Integer> noVector = search(line);
			print(noVector);
		}
		scan.close();
		System.out.println("프로그램을 종료합니다.");
	}
	public static void main(String[] args) {
		quiz_8 ws = new quiz_8();
		ws.run();
	}
}