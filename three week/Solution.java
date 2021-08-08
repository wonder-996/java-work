package duilie;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	public char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer>linkedHashMap=new LinkedHashMap<Character,Integer>();
        char[]ch=s.toCharArray();
        for(char chars:ch) {
        	if(!linkedHashMap.containsKey(chars)) {linkedHashMap.put(chars,1);}
        	else {
        		Integer integer=linkedHashMap.get(chars);
        		integer++;
        		linkedHashMap.put(chars, integer);
        	}}
        Iterator<Map.Entry<Character, Integer>> iterator=linkedHashMap.entrySet().iterator();
        while(iterator.hasNext()) {
        	Map.Entry<Character, Integer>entry=iterator.next();
        	if(entry.getValue()==1)return entry.getKey();
        	else continue;}
        return ' ';
        }
}
