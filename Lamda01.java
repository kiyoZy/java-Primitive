package onlyJava;

import java.util.function.Function;

public class Lamda01 {

	public static void main(String[] args) {

		// Lamda01 l01 = new Lamda01(); l01.test01();
		// Lamda01.test001();
		// Lamda01.test02();
		Lamda01.test03();
	}

	static public void test03() {
		Runnable runner = () -> {
			System.out.println("Hello Lambda!");
		};
		runner.run();

		Function<Integer, String> asterisker = (i) -> {
			return "String: " + i;
		};
		String result = asterisker.apply(10);
		System.out.println(result);
	}

	static public void test02() {
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Lambda ! 01");
			}
		};

		Runnable runner02 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Lambda ! 02");
			}
		};

		runner.run();
		runner02.run();
	}

	public void test01() {
		System.out.println("Hello World !");

		class Local implements Runnable {
			@Override
			public void run() {
				System.out.println("Hello Lambda!");
			}
		}

		Runnable runner = new Local();
		runner.run(); // Hello Lambda!

		Local runner02 = new Local();
		runner02.run(); // Hello Lambda!

	}

	// new しないから static
	static public void test001() {
		System.out.println("Hello World !");

		class Local implements Runnable {
			@Override
			public void run() {
				System.out.println("Hello Lambda!");
			}
		}

		Runnable runner = new Local();
		runner.run(); // Hello Lambda!

		Local runner02 = new Local();
		runner02.run(); // Hello Lambda!

	}
}
