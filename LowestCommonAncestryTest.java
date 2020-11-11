import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestryTest {

	@Test
	void testConstructor() {
		LowestCommonAncestry tree = new LowestCommonAncestry(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.left.left.left = new Node(8);
	}
	
	@Test
	void testValidInput() {
		LowestCommonAncestry tree = new LowestCommonAncestry(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.left.left.left = new Node(8);
		
        assertEquals( "Checking LCA of 4 and 5", 2, tree.findLCA(4,5));
        assertEquals( "Checking LCA of 3 and 6", 3, tree.findLCA(3,6));
        assertEquals( "Checking LCA of 7 and 8", 1, tree.findLCA(7,8));
	}
	
	@Test
	void testInvalidInput() {
		LowestCommonAncestry tree = new LowestCommonAncestry(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.left.left.left = new Node(8);
		
        assertEquals( "Checking LCA of -1 and 8", -1, tree.findLCA(-1,8));
        assertEquals( "Checking LCA of 0 and 6", -1, tree.findLCA(0,6));
        assertEquals( "Checking LCA of 7 and 10", -1, tree.findLCA(7,10));
	}
	
	@Test
	void testCreateDAG() {
		DAG graph = new DAG(5);
		assertEquals("Checking empty DAG", graph, graph);
		assertEquals("Adding edge 1 2", true, graph.addEdge(1, 2));
		assertEquals("Adding edge 2 4", true, graph.addEdge(2, 4));
		assertEquals("Adding edge 2 2, which is false", false, graph.addEdge(2, 2));
		assertEquals("Adding edge 4 2, opposite direction", true, graph.addEdge(4, 2));
		assertEquals("Adding edge 3 6, out of bounds", false, graph.addEdge(3, 6));
	}
	
	@Test
	void testValidInputDAG() {
		DAG graph = new DAG(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		
		assertEquals("LCA of 2 4", 2, graph.LCA(2, 4));
		assertEquals("LCA of 1 4", 1, graph.LCA(1, 4));
		assertEquals("LCA of 1 2", 0, graph.LCA(1, 2));
		
		// Test for 2 different possible LCA depending on order of input
		graph.addEdge(1, 5); 
		assertEquals("LCA of 4 5", 0, graph.LCA(4, 5));
		assertEquals("LCA of 5 4", 1, graph.LCA(5, 4));
	}
	
	@Test
	void testInvalidInputDAG() {
		DAG emptyGraph = new DAG(0);
		assertEquals("Test empty DAG", -1, emptyGraph.LCA(0, 1));
		
		DAG graph = new DAG(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		
		assertEquals("LCA of 2 7", -1, graph.LCA(2, 7));
		assertEquals("LCA of 7 2", -1, graph.LCA(7, 2));
		assertEquals("LCA of -3 -2", -1, graph.LCA(-3, -2));
		
	}
	
	
}
