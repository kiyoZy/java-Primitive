package onlyJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class Class01 {

	public static void main(String[] args) {
//		Class01 class01 = new Class01();
//		class01.test01();

//		test02();

//		test03();

//		testMap();

		testGenerics();
	}

	// 総称型テスト
	static void testGenerics() {
		PairMap pair = new PairMap<String>("ひとつめ","ふたつめ");
		System.out.println("1個目　＝　" + pair.first());
		System.out.println("2個目　＝　" + pair.second());

		System.out.println("\n");

		PairMap pair2 = new PairMap<Integer>(3, 6);
		System.out.println("first = " + pair.first());
		System.out.println("second = " + pair.second());

		// ↓はコンパイルエラーになる
		// PairMap pair3 = new PairMap<String>("はち", 8);

	}




	public void test01() {
		Person person = new Person(0, "a");
		System.out.println("person == " + person.toString());

		Member member = new Member(10, "b", "egg");
		System.out.println("member == " + member.toString());
	}

	static void test02() {
		List<Person> personList = new ArrayList<>();

		personList.add(new Person(0, "a"));
		personList.add(new Person(1, "b"));
		personList.add(new Person(2, "C"));

		for (Person p : personList) {
			System.out.println(p.toString());
		}
	}

	static void test03() {
		List<Member> memberList = new ArrayList<>();

		memberList.add(new Member(10, "A", "Apple"));
		memberList.add(new Member(11, "B", "Banana"));
		memberList.add(new Member(12, "C", "Strawberry"));

		for(Member m : memberList) {
			System.out.println(m.toString());
		}
	}

	static void testMap() {
		Map<String, String> map = new HashMap<>();

		map.put("赤", "イチゴ");
		map.put("緑", "キャベツ"); // ここは下記で上書きされる
		map.put("黄", "バナナ"); // ここは下記で上書きされる
		map.put("黄", "みそ");
		map.put("緑", "はっぱ");

		map.forEach((key, val) -> System.out.println(key + " : " + val));

		String key = "緑";
		System.out.println("\nキー：" + key + " = " + map.get(key));
	}
}

// https://camp.trainocate.co.jp/magazine/java-generics/
class PairMap<T> {
	private T first;
	private T second;

	public T first() {
		return this.first;
	}

	public T second() {
		return this.second;
	}

	public PairMap(T first, T second) {
		this.first = first;
		this.second = second;
	}
}

@Data
class Person {
	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

@Data
@EqualsAndHashCode(callSuper = false)
class Member extends Person {
	private String food;

	public Member(int age, String name, String food) {
		super(age, name);
		this.food = food;
	}

	public String toString() {
		return "Member(age=" + super.getAge() + ", name=" + super.getName() + ", food=" + food + ")";
	}
}