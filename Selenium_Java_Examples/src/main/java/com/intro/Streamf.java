package com.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Streamf {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		List<String> names1 = new ArrayList<String>();
		names.add("Abhisheek");
		names.add("Araya");
		names.add("Maruthi");
		names.add("Mike");
		names.add("Heshika");
		names1.add("Anusha");
		names1.add("Mounika");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {

			String actual = names.get(i);
			if (actual.startsWith("A")) {

				count++;
				System.out.println(actual);
			}
		}
		System.out.println(count);
        //filter data starts with 'M'
		long c = names.stream().filter(s -> s.startsWith("M")).count();
		System.out.println(c + " M count");
         //filter data contains with 'H'
		long d = Stream.of("Aaarya", "Hari", "Jack").filter(s -> s.contains("H")).count();
		System.out.println(d);
		//filter data which is having 4 length and print it
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println("limited " + s));
		// print names with upppercase
		names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// print names which have first letter as a with uppercase an sorted
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
        //concate the 2 arrayslist and check mounika is present is list 
		Stream<String> ns = Stream.concat(names.stream(), names1.stream());
		Boolean flag = ns.anyMatch(s -> s.equalsIgnoreCase("mounika"));
		System.out.println(flag);
		Assert.assertTrue(flag);

		// stream of strings elements check it end with n ,sored and lowercase then
		// collect into list

		List<String> ls = Stream.of("Ajay", "varun", "Akkin").filter(s -> s.endsWith("n")).sorted()
				.map(s -> s.toLowerCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		//Print unique numbers,sort and display the 3rd number
		List<Integer> values = Arrays.asList(3, 2, 3, 2, 6, 2, 1, 5, 6);
		List<Integer> ln=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ln.get(2));
		
	}

}
