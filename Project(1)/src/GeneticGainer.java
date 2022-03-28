

import java.io.*;
import java.util.*;

public class GeneticGainer {
	
	int P;      //population size
	int G;      //number of indexInGenerations
	int Cr;     //crossover rate
	int Mu;     //mutation rate
	int length; 
	Random random;
	int[][] current;
	int[][] next;
	int indexInGeneration; 
	
	public GeneticGainer(int p, int g, int cr, int mu, int length_n)
	{
		P = p;
		G = g;
		Cr = cr;
		Mu = mu;
		length = length_n;
		
		random = new Random();
		current = new int[p][length];// each lines with length(num of elements) for p lines(groups)
		next = new int[p][length];
		indexInGeneration = 0;
	}
	
	public int[][] getNextGeneration(int[][] temp)
	{ 
		indexInGeneration = 0;
		
		for(int i = 0; i < P; i++)
			System.arraycopy(temp[i], 0, current[i], 0, length);
		
		while(indexInGeneration < P)//limit the max population under p
			indexInGeneration += generateNext();
		
		return next;
	}
	
	//index represent the NO. of one ordering within a generation 
	public int generateNext()
	{
		int Pr = random.nextInt(101);
		
		if(Cr >= Pr)
		{
			int index1 = random.nextInt(P);
			int index2 = random.nextInt(P);
			crossover(current[index1], current[index2]);//swap two orderings of current
			
			return 2;
		}
			
		else if(Cr <= Pr && Pr <= (Cr + Mu))
		{
			int index = random.nextInt(P);
			mutation(current[index]);//mutate
			
			return 1;
		}
			
		else if((Cr + Mu) <= Pr)
		{
			int index = random.nextInt(P);
			reproduction(current[index]);//copy an ordering of current into next
			
			return 1;
		}
		
		return 0;
	}
	
	public void reproduction(int[] array)
	{
		System.arraycopy(array, 0, next[indexInGeneration], 0, array.length);
	}
	
	public void mutation(int[] array)
	{
		int index1 = random.nextInt(length); 
		int index2 = random.nextInt(length);
		while(index1 == index2)//ensure two definite different orderings
			index2 = random.nextInt(length);
		
		int temp;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

		System.arraycopy(array, 0, next[indexInGeneration], 0, array.length);
		
	}
	
	public void crossover(int[] array1, int[] array2)
	{
		/*text data: int [] b2 = {4,7,0,6,5,3,1,2};*/
		
		//generate a random point(cp alias index)
		int index = random.nextInt(length);
				
		//segment crossover
		int temp1[] = new int[length];
		int temp2[] = new int[length];
				
		for(int i = index; i < length; i++)//copy the post-part
		{
			temp1[i] = array1[i]; 
			temp2[i] = array2[i];
		}
					
		for(int i = index; i < length; i++)////crossover
		{
			array1[i] = temp2[i];
			array2[i] = temp1[i];
		}
							
		for(int i = 0; i < index; i++)//pre-part
		{
			for(int j = index; j < length; j++)//post-part
			{                               
				if(array1[i] == array1[j])  //if duplicate elements in ord1
					array1[i] = array2[i];
						
				if(array2[i]==array2[j]);   //if duplicate elements in ord2
					array2[i]=array1[i];
			}
		}

		System.arraycopy(array1, 0, next[indexInGeneration], 0, array1.length);
		if(indexInGeneration+1 < P)
			System.arraycopy(array2, 0, next[indexInGeneration+1], 0, array2.length);
				
				/*for(i=0;i<count1;i++)
					System.out.print(array1[i]+" ");
				System.out.print("\n");
				
				for(i=0;i<count2;i++)
					System.out.print(array2[i]+" ");*/
	}

}
