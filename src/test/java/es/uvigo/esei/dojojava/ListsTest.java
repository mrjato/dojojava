package es.uvigo.esei.dojojava;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListsTest {
	@Test
	public void testList() {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 10_000_000; i++) {
			list.add(i);
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i);
//		}
		
		for (Integer i : list) {
			
		}
	}
}
