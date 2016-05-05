package es.uvigo.esei.dojojava;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class TreeCollections {
	
	public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
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

		@Override
		public int compareTo(CaseInsensitiveString o) {
			return this.string.toLowerCase().compareTo(o.string.toLowerCase());
		}
	}
	
	
	@Test
	public void testTreeSet() {
		SortedSet<CaseInsensitiveString> set = new TreeSet<>();
		
		CaseInsensitiveString s1 = new CaseInsensitiveString("hola");
		CaseInsensitiveString s2 = new CaseInsensitiveString("HOLA");
		CaseInsensitiveString s3 = new CaseInsensitiveString("adios");
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		System.out.println(set);
	}
	
	
	@Test
	public void testTreeSetDescending() {
		Comparator<CaseInsensitiveString> descending =
			new Comparator<TreeCollections.CaseInsensitiveString>() {
				@Override
				public int compare(CaseInsensitiveString o1, CaseInsensitiveString o2) {
					return -o1.compareTo(o2);
				}
			};
		
		SortedSet<CaseInsensitiveString> set = new TreeSet<>(descending);
		
		CaseInsensitiveString s1 = new CaseInsensitiveString("hola");
		CaseInsensitiveString s2 = new CaseInsensitiveString("HOLA");
		CaseInsensitiveString s3 = new CaseInsensitiveString("adios");
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		System.out.println(set);
	}
}
