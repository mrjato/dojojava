package es.uvigo.esei.dojojava;

import static org.junit.Assert.*;

import org.junit.Test;

public class CopyObjectsTest {

	class SimpleCloneable implements Cloneable {
		
		private String data; //inmutable object
		
		public int[] mutableData = new int[10]; //mutable object
		
		public void setData(String data) {
			this.data = data;
		}
		
		public String getData() {
			return data;
		}
		
		public SimpleCloneable clone() {
			
			try {
				SimpleCloneable clone = (SimpleCloneable) super.clone(); 
								// creates a new SimpleCloneable and
							   // assigns field-by-field
				
				// make a deep copy. We should also clone mutable data
				clone.mutableData = this.mutableData.clone();
				
				return clone;
				
			} catch (CloneNotSupportedException e) {
				// You should not see this!!
				return null;
			} 
		}
	}
	
	@Test
	public void testNotCloning() {
		SimpleCloneable object1 = new SimpleCloneable();
		object1.setData("object 1");
		
		SimpleCloneable object2 = object1;
		assertTrue(object1.getData().equals(object2.getData()));
		
		object1.setData("new data");
		
		assertTrue(object1.getData().equals(object2.getData())); // modifications are seen in the two instances
																// because they are the same single object
	}
	
	@Test
	public void testCloning() {
		SimpleCloneable object1 = new SimpleCloneable();
		object1.setData("object 1");
		
		SimpleCloneable object2 = object1.clone();
		assertTrue(object1.getData().equals(object2.getData()));
		
		object1.setData("new data");
		
		assertFalse(object1.getData().equals(object2.getData())); // modifications have made divergent objects
	}
	
	@Test
	public void testDeepCloning() {
		SimpleCloneable object1 = new SimpleCloneable();
		object1.mutableData[0] = 1;
		
		SimpleCloneable object2 = object1.clone();
		assertTrue(object1.mutableData[0] == object2.mutableData[0]);
		
		object1.mutableData[0] = 2;
		
		assertFalse(object1.mutableData[0] == object2.mutableData[0]);
	}
}
