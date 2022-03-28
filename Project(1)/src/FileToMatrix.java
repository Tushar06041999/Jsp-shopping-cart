
import java.io.*;

public class FileToMatrix {

	private int[][] array;
	private int length;
	private int matrixLength;
	private int[][] adjacencyMatrix;
	private File file;
	private FileReader fr;
	private FileReader frl;
	private BufferedReader br;
	private BufferedReader brl;
	
	public int[][] getMatrix()//transfer the data from file to an Adjacency Matrix
	{
		getFileLength();
		toArray(); 
		
		getMatrixLength();
		toMatrix();
		
		return adjacencyMatrix;
	}
	
	public int getLength()
	{
		return matrixLength;
	}
	
	public FileToMatrix(String address)
	{
		file = new File(address);
		
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br  = new BufferedReader(fr);
        try {
            frl = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    	brl = new BufferedReader(frl);
	}
	
	public void toArray()//content of file -> represent by array
	{
        int count=0;
        
        try {
           String line = "";
           String [] aLine = null;
           String [][] temp = new String[length][2];
           
           while((line=br.readLine()) != null)//stored by string type temporary
           {
               aLine = line.split(" "); 
               
               for(int i=0;i<2;i++)
                   temp[count][i] = aLine[i];
               
               count++;
           }
           
           for(int i = 0; i < count; i++)//convert string to int
               for(int j = 0; j < 2; j++)
                   array[i][j] = Integer.parseInt(temp[i][j]);
                   /*System.out.print(array[i][j]+" ");*/
               /*System.out.println();*/
       } catch (IOException e) {
           e.printStackTrace();
       }
	}
	
	public void toMatrix()//represent by array -> convert to adjacency matrix
	{		
		for(int i = 0; i < length; i++)
		{
			int node_1 = array[i][0]; //the first Node
			int node_2 = array[i][1]; //the second 

            adjacencyMatrix[node_1][node_2] = 1; //fill the matrix, connect two points:a[i][j]=1
		}
	}
			
	public void getFileLength()
	{
		String aLine = "";
     	try{
     		while((aLine = brl.readLine()) != null)
     			length++;
     		
     	}catch (IOException e) {
                 e.printStackTrace();
        }
        
        array = new int[length][2];
	}
	
	public void getMatrixLength() 
	{                             //the max rand(length) of array should be the max value displayed in the dataset 
		for(int count = 0; count < array.length; count++)
		{
			for(int i = 0; i < 2; i++)
			{
				if(array[count][i] > matrixLength)
					matrixLength = array[count][i];
			}
		}
		matrixLength++;
		
		adjacencyMatrix = new int[matrixLength][matrixLength];
	}
	
	
	public static void main(String[] args) {

		FileToMatrix fileToMatrix = new FileToMatrix("src\\Edges.txt");

		int[][] matrix= fileToMatrix.getMatrix();

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.printf("\n");
		}
	}
}
