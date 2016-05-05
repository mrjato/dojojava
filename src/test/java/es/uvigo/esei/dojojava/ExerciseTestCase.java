package es.uvigo.esei.dojojava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class ExerciseTestCase {
	private final static Random RANDOM = new Random(33);
	private final static int NUM_CARS = 10000;
	
	private final static String[] CAR_NAMES = new String[] {
		"alfa romeo", "bentley", "citroen", "dacia", "fiat",
		"honda", "infiniti", "jeep", "kia", "lexus"
		
		/* "nissan", "toyota", "mitsubishi", "mazda", 
		"ford", "peugeot", "bmw", "audi", "renault", 
		"volkswagen", "hyundai", "opel", "subaru", "suzuki", 
		"volvo", "porsche", "chevrolet", "seat", 
		"skoda", "chrysler", "mercedes", "land rover", 
		"mini", "saab", "dodge", "jaguar", "ferrari", 
		"smart", "daihatsu", "lancia", "ssangyong", 
		"cadillac", "isuzu", "rover", "lamborghini", 
		"maserati", "lotus", "mg", "daewoo", "tata" */
	};
	
	private final static List<String> CARS = new ArrayList<>(NUM_CARS);
	private final static List<String> CARS_RANDOM_CASE = new ArrayList<>(NUM_CARS);  

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < NUM_CARS; i++) {
			final String car = CAR_NAMES[RANDOM.nextInt(CAR_NAMES.length)];
			
			CARS.add(car);
			CARS_RANDOM_CASE.add(randomCase(car));
		}
		
		System.out.println("CARS: " + CARS);
		System.out.println("CARS RANDOM CASE: " + CARS_RANDOM_CASE);
		System.out.println();
	}
	
	@Test
	public void testDistinctUnsorted() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   diferentes que hay en CARS.
		   No importa el orden.
		*/
		
		System.out.println("Distinct unsorted: " + new HashSet<>(CARS));
	}
	
	@Test
	public void testDistinctSorted() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   diferentes que hay en CARS.
		   Ordenados por orden alfabético.
		*/
		
		System.out.println("Distinct sorted: " + new TreeSet<>(CARS));
	}
	
	@Test
	public void testCountUnsorted() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS seguido por el número de veces que aparece
		   en la lista.
		   No importa el orden.
		*/
		
		Map<String, Integer> count = new HashMap<>();
		
		for (String car : CARS) {
			if (count.containsKey(car)) {
				count.put(car, count.get(car) + 1);
			} else {
				count.put(car, 1);
			}
		}
		
		
		System.out.println("Count unsorted: " + count);
	}
	
	@Test
	public void testCountSorted() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS seguido por el número de veces que aparece
		   en la lista.
		   Ordenados por orden alfabético.
		*/
		
		Map<String, Integer> count = new TreeMap<>();
		
		for (String car : CARS) {
			if (count.containsKey(car)) {
				count.put(car, count.get(car) + 1);
			} else {
				count.put(car, 1);
			}
		}
		
		System.out.println("Count sorted: " + count);
	}
	
	@Test
	public void testCountSameOrderAsList() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS seguido por el número de veces que aparece
		   en la lista.
		   El el mismo orden en el que aparecen en la lista CARS.
		*/
		
		Map<String, Integer> count = new LinkedHashMap<>();
		
		for (String car : CARS) {
			if (count.containsKey(car)) {
				count.put(car, count.get(car) + 1);
			} else {
				count.put(car, 1);
			}
		}
		
		System.out.println("Count original order: " + count);
	}
	
	@Test
	public void testDistinctUnsortedCaseInsensitive() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   diferentes que hay en CARS_RANDOM_CASE.
		   No importa el orden.
		*/
		
		System.out.println("Distinct unsorted c.i.: ");
	}
	
	@Test
	public void testDistinctSortedCaseInsensitive() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   diferentes que hay en CARS_RANDOM_CASE.
		   Ordenados por orden alfabético.
		*/
		
		System.out.println("Distinct sorted c.i.: ");
	}
	
	@Test
	public void testCountUnsortedCaseInsensitive() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS_RANDOM_CASE seguido por el número de veces
		   que aparece en la lista.
		   No importa el orden.
		*/
		
		System.out.println("Count unsorted c.i.: ");
	}
	
	@Test
	public void testCountSortedCaseInsensitive() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS_RANDOM_CASE seguido por el número de veces
		   que aparece en la lista.
		   Ordenados por orden alfabético.
		*/
		
		System.out.println("Count sorted c.i.: ");
	}
	
	@Test
	public void testCountSameOrderAsListCaseInsensitive() {
		/*
		   Muestra por pantalla una lista con el nombre de los coches
		   que hay en CARS_RANDOM_CASE seguido por el número de veces
		   que aparece en la lista.
		   El el mismo orden en el que aparecen en la lista CARS_RANDOM_CASE.
		*/
		
		System.out.println("Count original order c.i.: ");
	}

	private static String randomCase(String string) {
		String randomString = "";
		
		for (char c : string.toCharArray()) {
			if (RANDOM.nextBoolean())
				c = Character.toUpperCase(c);
			
			randomString += c;
		}
		
		return randomString;
	}
}
