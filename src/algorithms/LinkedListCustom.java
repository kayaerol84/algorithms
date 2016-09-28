package algorithms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCustom {
	Friend head;
	int listcount;

	private String convertList(List<String> list) {
		String listString = "";

		for (String s : list) {
			listString += s + ",";
		}
		return listString;
	}

	public LinkedListCustom() {
		head = null;
		listcount = 0;
	}

	public void add(String name, int age) {
		Friend node = new Friend(name, age);
		if (head == null) {
			head = node;
			return;
		}
		if (head.name.compareTo(node.name) > 0) {
			node.nextName = head;
			head = node;
			return;
		}
		Friend current = head;
		Friend previous = null;

		while (current.name.compareTo(node.name) < 0 && current.nextName != null) {
			previous = current;
			current = current.nextName;
		}
		if (current.name.compareTo(node.name) == 0 && current.age < node.age) {
			node.nextName = current.nextName;
			current.nextName = node;
		} else if (current.name.compareTo(node.name) < 0) {
			previous.nextName = current;
			current.nextName = node;
		} else {
			previous.nextName = node;
			node.nextName = current;
		}
	}

	public void printList() {
		Friend temp = head;
		while (temp != null) {
			temp.print();
			temp = temp.nextName;
		}
		System.out.println("***");
	}

	public static void main(String[] args) {
		String s = "falan,fisman,bidi,bidi";
		String[] array = s.split(",");
		LinkedList<String> linkList = new LinkedList(Arrays.asList(array));
		System.out.println(linkList);
		
		LinkedListCustom l = new LinkedListCustom();
		l.add("Travis", 19);
		l.printList();
		l.add("Kyler", 14);
		l.printList();
		l.add("Abby", 10);
		l.printList();
		l.add("Bob", 19);
		l.printList();
		l.add("Travis", 12);
		l.printList();
		l.add("Zander", 99);
		l.printList();
	}
}
