import java.util.Scanner;
import java.util.Vector;

public class CapitalGame_vector {
	private Vector<Nation> store = new Vector<Nation>();
	private Scanner scan = new Scanner(System.in);
	
	public CapitalGame_vector() {
		store.add(new Nation("그리스", "아테네"));
		store.add(new Nation("독일", "하얼빈"));
		store.add(new Nation("멕시코", "멕시코시티"));
		store.add(new Nation("영국", "런던"));
		store.add(new Nation("중국", "베이징"));
		store.add(new Nation("일본", "도쿄"));
		store.add(new Nation("미국", "워싱턴"));
		store.add(new Nation("프랑스", "파리"));
		store.add(new Nation("캐나다", "오타와"));
	}
	
	private void error(String msg) {
		System.out.println(msg);
	}
	
	public void run() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
			int menu = scan.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					error("잘못된 입력입니다.");
			}
		}
		
	}

	private boolean contains(String country) {
		for(int i=0; i<store.size(); i++) {
			if(store.get(i).getCountry().equals(country)) {
				return true;
			}
		}
		
		return false;

	}
	private void input() {
		int n = store.size();
		System.out.println("현재 " + n + "개 나라와 수도가 입력되어 있습니다.");
		n++;
		while(true) {
			System.out.print("나라와 수도 입력" + n + ">> ");
			String country = scan.next();
			if(country.equals("그만")) {
				break;
			}
			String capital = scan.next();

			if(contains(country)) {
				System.out.println(country + "는 이미 있습니다!");
				continue;
			}
				
			store.add(new Nation(country, capital));
			n++;
		}
	}

	private void quiz() {
		while(true) {
			int index = (int)(Math.random()*store.size());
			
			Nation nation = store.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
			System.out.print(question + "의 수도는? ");
			
			String capitalFromUser = scan.next();
			if(capitalFromUser.equals("그만")) {
				break;
			}
			if(capitalFromUser.equals(answer))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");				
		}	
		
	}

	private void finish() {
		System.out.println("게임을 종료합니다.");	
	}

	public static void main(String[] args) {
		CapitalGame_vector game = new CapitalGame_vector();
		game.run();

	}

}
class Nation {
	private String country;
	private String capital;
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	public String getCountry() {
		return country;
	}
	public String getCapital() {
		return capital;
	}
}
