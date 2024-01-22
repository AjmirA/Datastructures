package main;

import java.util.HashMap;
import java.util.Map;

public class ds {
public static void main(String[] args) {

	 String test = "Welcome to Sling";
	 Map<Character,Integer> map=new HashMap<>();
	 int count=0;
	 for(int i=0;i<test.length();i++) {
		
		 if(map.containsKey(test.charAt(i))){
			  count=map.get(test.charAt(i));
			  count++;
			 map.put(test.charAt(i),count);
		 }else
			 map.put(test.charAt(i),1);
				 
	 }

	 for(Map.Entry<Character, Integer> g:map.entrySet()) {
		 System.out.println(g.getKey()+" -> "+g.getValue());
	 }
}
}


