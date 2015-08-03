 package test;

public class StringCode {

	public static void main(String[] args) {
		String str = "xmruibi";
		for (char c : str.toCharArray())
			System.out.print(c - 'a'+1);
	}
}
