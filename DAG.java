import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private ArrayList<Integer>[] adj;
	private int V;
	private int E;
	
	public DAG(int V) 
	{
		this.V=V;
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
			
		}
	}
	
	public boolean addEdge(int v, int w) 
	{
		if( v==w)
		{
			return false;
		}
		else if(validVertex(v) && validVertex(w)) 
		{
			this.adj[v].add(w);
			this.E++;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	private boolean validVertex(int v) 
	{
		if (v < 0 || v >= V) return false;
		else return true;
	}

	public ArrayList<Integer> adj(int v)
	{ 
		return adj[v]; 
	}

	public int LCA(int v, int w) 
	{
		
		if (!validVertex(w)|| !validVertex(v)) 
		{
			return -1;
		}

		ArrayList<Integer> commonAncestor = new ArrayList<Integer>();
		boolean hasCommonAncestor = false;
		
		DAG reversed = this.reverse();
		ArrayList<Integer> searchV = reversed.search(v);
		ArrayList<Integer> searchW = reversed.search(w);

		for (int i = 0; i < searchV.size(); i++) 
		{
			for (int j = 0; j < searchW.size(); j++) 
			{
				if (searchV.get(i) == searchW.get(j)) 
				{
					commonAncestor.add(searchV.get(i));
					hasCommonAncestor = true;
				}
			}
		}

		if (hasCommonAncestor) 
		{
			return commonAncestor.get(0);
		} 
		else 
		{
			return -1;
		}
	}
	
	//Reverses DAG to traverse through the vertices
	public DAG reverse()
	{
        DAG reversedDAG = new DAG(this.V);
        for (int i = 0; i < this.V; i++)
        {
            for (int j: adj(i)) 
            {
                reversedDAG.addEdge(j, i);
            }
        }
        return reversedDAG;
    }
	
	//BFS Algorithm
	public ArrayList<Integer> search(int s) 
	{
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) 
		{
			s = queue.poll(); 
			result.add(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) 
			{
				int n = i.next();
				if (!visited[n]) 
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return result;
	}
}
