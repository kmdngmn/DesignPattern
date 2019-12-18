package Adapter_Facade_Pattern;

import java.util.Arrays;
import java.util.List;

public class ArraysAdapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"1", "2"};
		
		List<String> list = Arrays.asList(arr);
		
		list.set(0, "100");
		
		for(String s: list) {
			System.out.println(s);
		}
		
	}

}
