
import java.math.*;

public class FitnessGainer 
{	
	double chunk;
	private int length;
	int[][] adjacencyMatrix;
	
	public double getFitness(int[] array)
	{
		int[] indexToNode = orderArray(array);
		double[][] coordinate = setCoordinate();
		double totalLength =  getTotalLength(indexToNode, coordinate);
		
		return totalLength*-1;
	}
	
	public FitnessGainer(int length, int[][] Matrix)
	{
		chunk = ((3.14) * 2) / length;
		this.length = length;
		this.adjacencyMatrix = new int[length][length];

		for(int i=0; i<length; i++)
			for(int j=0; j<length; j++)
				this.adjacencyMatrix[i][j] = Matrix[i][j];//gain the adj[][]
	}
	
	double getTotalLength(int[] indexToNode, double[][] coordinate)
	{
		int totalLength = 0;
		
		for(int line = 0; line < length; line++)
		{
			for(int count = line; count < length; count ++)
			{
				if(adjacencyMatrix[line][count] == 1)
				{
					int node_1 = indexToNode[line];
					int node_2 = indexToNode[count];

					totalLength += getLength(node_1, node_2, coordinate);
				}
			}
		}
		
		return totalLength;
	}
	
	double getLength(int node_1, int node_2, double[][] coordinate)
	{
		double x_1 = coordinate[0][node_1];
		double y_1 = coordinate[1][node_1];
		double x_2 = coordinate[0][node_2];
		double y_2 = coordinate[1][node_2];
		
		double squareOfLength = Math.pow((x_1-x_2), 2) + Math.pow((y_1-y_2), 2);
		double Length = Math.sqrt(squareOfLength);

		return Length;
	}
	
	double[][] setCoordinate()
	{
		double[][] temp = new double[2][length];
		
		for(int i = 0; i < length; i++)
		{
			double x = getCosX(i);
			double y = getSinY(i);
			
			temp[0][i] = x;
			temp[1][i] = y;
		}
		
		return temp;
	}
	
	int[] orderArray(int[] array)
	{
		int[] temp = new int[length];
		
		for(int i = 0; i < length; i++)
			temp[array[i]] = i;
		
		return temp;
	}
	
	public FitnessGainer(int length)
	{
		this.length = length;
		chunk = ((3.14) * 2) / length;
	}
	
	double getCosX(int n)
	{
		double x = Math.cos(n*chunk);
		return x;
	}
	double getSinY(int n)
	{
		double x = Math.sin(n*chunk);
		return x;
	}
	
}
