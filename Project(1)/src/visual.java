

import java.awt.Graphics;

import javax.swing.JFrame;

public class visual extends JFrame
{                                         
    static int adj[][];
    static int v = 0;              //num of nodes
    static int current_ordering [];//final selection
    static double current_fitness = 0;
    static double min_dis = 0;
    static double chunk;
    
    public visual()
    { 
    	setTitle("AI");
    	setSize(960, 960);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g)
    {
    	int radius = 100;
    	int mov = 200;
    	
    	for(int i = 0; i < v; i++)
    		for(int j = i + 1; j < v; j++)
    			if(adj[current_ordering[i]][current_ordering[j]] == 1)
    				g.drawLine(
                                (int)(((double) Math.cos(i * chunk)) * radius + mov),
                                (int)(((double) Math.sin(i * chunk)) * radius + mov),
                                (int)(((double) Math.cos(j * chunk)) * radius + mov),
                                (int)(((double) Math.sin(j * chunk)) * radius + mov));
    }
}
