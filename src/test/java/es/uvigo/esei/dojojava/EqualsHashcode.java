package es.uvigo.esei.dojojava;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class EqualsHashcode {
	
	public class CaseInsensitiveString {
		private String string;

		public CaseInsensitiveString(String string) {
			this.string = string;
		}
		
		public void setString(String string) {
			this.string = string;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof CaseInsensitiveString) {
				CaseInsensitiveString cis = (CaseInsensitiveString) obj;
				
				return this.string.equalsIgnoreCase(cis.string);
			} else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return this.string.toLowerCase().hashCode();
		}
		
		@Override
		public String toString() {
			return this.string;
		}
	}
	
	
	@Test
	public void testEqualsHashcode() {
		Set<CaseInsensitiveString> set = new HashSet<>();
		
		CaseInsensitiveString s1 = new CaseInsensitiveString("hola");
		CaseInsensitiveString s2 = new CaseInsensitiveString("HOLA");
		CaseInsensitiveString s3 = new CaseInsensitiveString("adios");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		System.out.println(set);
		
		s3.setString("X");
		System.out.println(set);
		System.out.println(set.contains(s3));
	}
}
