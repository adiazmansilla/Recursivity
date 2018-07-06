package tree;

import java.util.ArrayList;
import java.util.List;

public class SumNodeValues {
	
	/**
	 * returns a tree with nodes and levels.
	 * @return
	 */
	private static Node getNodes() {
		// Creamos los nodos de nivel 2
		Node nodeLevel21 = new Node(2, null);
		Node nodeLevel22 = new Node(4, null);
		Node nodeLevel25 = new Node(10, null);

		// Creamos la lista de nodos de nivel 2
		List<Node> lstNode21 = new ArrayList<>();
		lstNode21.add(nodeLevel21);
		lstNode21.add(nodeLevel22);
		lstNode21.add(nodeLevel25);

		Node nodeLevel23 = new Node(6, null);
		Node nodeLevel24 = new Node(8, null);

		List<Node> lstNode22 = new ArrayList<>();
		lstNode22.add(nodeLevel23);
		lstNode22.add(nodeLevel24);

		// Creacion de nodos de nivel 1
		Node nodeLevel11 = new Node(1, lstNode21);
		Node nodeLevel12 = new Node(3, lstNode22);
		Node nodeLevel13 = new Node(5, null);
		Node nodeLevel14 = new Node(7, null);
		Node nodeLevel15 = new Node(9, null);
		Node nodeLevel16 = new Node(11, null);

		// Agregamos a Nivel 1 la lista.
		List<Node> lstNode = new ArrayList<>();
		lstNode.add(nodeLevel11);
		lstNode.add(nodeLevel12);
		lstNode.add(nodeLevel13);
		lstNode.add(nodeLevel14);
		lstNode.add(nodeLevel15);
		lstNode.add(nodeLevel16);
		Node root = new Node(25, lstNode);
		
		return root;
	}

	public static void main(String[] args) {
		//This method recibes Node and level. 
		System.out.println(getLevelSum(getNodes(), 0));
	}

	static int level = 1;
	static int sum = 0;
	/**
	 * Implements sum of nodes in the same level n
	 * @param root
	 * @param n
	 * @return
	 */
	public static int getLevelSum( Node root, int n) {
		if (root != null && n == 0) {
			return root.getValue();
		}
		if (root!=null && root.getChildren() != null) {
			for (Node node : root.getChildren()) {
				if (level < n) {
					level++;
					getLevelSum(node, n);
				} else if (level == n) {
					sum += node.getValue();
					continue;
				}
			}
		}
		level = 1;
		return sum;
	}
}
