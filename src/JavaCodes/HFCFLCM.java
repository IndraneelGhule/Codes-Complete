package JavaCodes;

import java.util.*;

public class HFCFLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 20;
		int b=10;
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		
		List<Integer> lst1 = getFactors(a);
		List<Integer> lst2 = getFactors(b);
		List<Integer> lst3 = new LinkedList<Integer>();
		
		if(lst1.size() < lst2.size()) {
			lst1.contains(lst2);
			lst3 = lst1;
		}
		else {
			lst2.containsAll(lst1);
			lst3 = lst2;
		}
		
		System.out.println("Final: "+lst3);
		
	}
	
	public static List<Integer> getFactors(int no){
		System.out.println(no+"Execution");
		
		List<Integer> lst = new LinkedList<>();
		int mid = (no/2) +1;
		int reqNum =no;
		
		for(int i=2;i<=mid;) 
		{
			int rem = reqNum % i;
			if(rem == 0) {
				lst.add(i);
				reqNum = reqNum /i;
			}
			else {
				
				i++;
			}
		}
		
		System.out.println(no+" | "+lst);
		return lst;
	}
	

}
