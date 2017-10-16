import java.io.*;
import java.util.*;
public class mutiples
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("what is the numbers you want to go up to?");
		int num = s.nextInt();
		HashMap<Integer, Integer> all = new HashMap<>();
		for(int i = 1; i<= num; i++)
		{
			HashMap<Integer, Integer> factor = new HashMap<>(factors(i));
			for(Integer j: factor.keySet())
			{
				Integer ele = all.get(j);
				Integer number = factor.get(j);
				if(ele == null)
				{
					all.put(j, number);
				}
				else if(number > ele)
				{
					all.put(j, number);
				}
			}
		} 
		System.out.println(all);
		int product = 1;
		for(Integer I: all.keySet())
		{
			product *= Math.pow(I,all.get(I));
		}
		System.out.println(product);
			
	}
	public static HashMap<Integer,Integer> factors(int x)
	{
		HashMap<Integer, Integer> factor = new HashMap<Integer,Integer>();
		for(int i = 2; i <= x; i++)
		{
			if(x % i == 0)
			{
				Integer hey = factor.get(i);
				if(hey == null)
					factor.put(i,1);
				else
					factor.put(i, factor.get(i)+1);
				x = x/i;
				i--;
			}
		
		}
		return factor; 
	}
}