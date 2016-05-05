package es.uvigo.esei.dojojava;

import org.junit.Test;

public class EqualsVsSame {
	@Test
	public void testStringEqualsAndSame() {
		String s1 = "Hola";
		String s2 = "Ho" + "la";
		String s3 = new String("Hola").intern();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println();
		
		System.out.println(s1.equals(s2)); // TRUE
		System.out.println(s1.equals(s3)); // TRUE
		System.out.println(s2.equals(s3)); // TRUE

		System.out.println();
		
		System.out.println(s1 == s2); // TRUE
		System.out.println(s1 == s3); // FALSE
		System.out.println(s2 == s3); // FALSE
	}
}
