

import java.io.*;
import java.util.Random;

public class Randomer {
	
	int length = 0;
	Random rand;
	
	public Randomer(int length)
	{
		this.length = length;
		rand = new Random();
	}
	
	int getARandomNumber(int max)
	{
		return rand.nextInt(max); // 0 <= nextInt(n) < n
	}

	int[] getAnOrdering() //generating an ordering without repeat number 
	{
		int[] aOrdering = new int[length];
		boolean[] numbersTaken = new boolean[length];
		for(int count = 0; count < length; count++)
			numbersTaken[count] = false; //default
		
		for(int i = 0; i < length; i++) 
		{
			aOrdering[i] = rand.nextInt(length); //generate a random numer
			if(numbersTaken[aOrdering[i]])       //if the num existed, then i--, until generate a different numberS
			{
				i--;
				continue;
			}
			numbersTaken[aOrdering[i]] = true;
		}
		
		return aOrdering;
	}
}
