import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> sub = new ArrayList<>();
		ArrayList<String> subList = new ArrayList<>();
		int N = sc.nextInt();
		String str = sc.next();
		
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sub.add(str.substring(0, i));
				sub.add(str.substring(i, j));
				sub.add(str.substring(j, N));
			}
		}
		
		for(String item : sub) {
			if(!subList.contains(item)) subList.add(item);
		}
		
		Collections.sort(subList);
		
		int sum = 0, max = 0;
		for (int i = 0; i < sub.size(); i++) {
			int a = 0;
			for (String item : subList) {
				if(sub.get(i).equals(item)) {
					a = subList.indexOf(item) + 1;
					break;
				}
			}
			sum += a;
			if (i % 3 == 2) {
				if (sum > max) max = sum;
				sum = 0;
			}
		}
		
		System.out.println(max);
	}
}
