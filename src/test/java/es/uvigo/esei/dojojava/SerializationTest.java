package es.uvigo.esei.dojojava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

class MySerializable implements Serializable {
	int[] data = new int[10];
}

public class SerializationTest {

	
	@Test
	public void testCopyViaSerialization() throws IOException, ClassNotFoundException {
		MySerializable object = new MySerializable();
		object.data[0] = 20;
		
		File f = new File("object.dat");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(object);
		}
		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			MySerializable loadedObject = (MySerializable) ois.readObject();
			
			assertTrue(object.data[0] == loadedObject.data[0]);
			object.data[0] = 25;
			assertFalse(object.data[0] == loadedObject.data[0]); //since it is a deep copy
		}
		 
	}
}
