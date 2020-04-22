package com.lquan.test;/**
 * Created by 01370602 on 2020/4/22.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName Test
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Test {
//	public static void main(String[] args) {
//
//		Object object = new Object();
//
//		object.equals("");
//		object.hashCode();
//
//
//		String a ="aaa";
//		String b ="aaa";
//		if(a.equals(b)){
//
//		}
//
//
//		List<String> list = new ArrayList<>();
//		list.contains("");
//		list.equals("");
//		list.hashCode();
//	}

	public static void main(String[] args) {


		Person person1 = new Person("TUCJVXCB");
		Person person2 = new Person("TUCJVXCB");


		Map<Person, Integer> hashMap = new HashMap<>();
		hashMap.put(person1, 1);

		//hashMap.put(null);
		System.out.println(person1.equals(person2));
		System.out.println(hashMap.containsKey(person2));
	}

	static class Person {
		private String name;

		public Person(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Person) {
				Person person = (Person) obj;

				return name.equals(person.name);
			}
			return false;
		}
	}
}

