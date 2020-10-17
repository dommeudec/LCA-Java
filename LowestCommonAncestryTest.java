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

}
