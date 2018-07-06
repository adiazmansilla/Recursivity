package tree;

import java.util.ArrayList;
import java.util.List;

public class SumNodeValues {

	public static interface Node {
		int getValue();

		List<Node> getChildren();
	}
	
	/**
	 * returns a tree with nodes and levels.
	 * @return
	 */
	private static Node getNodes() {
		// Creamos los nodos de nivel 2
		NodeC nodeLevel21 = new NodeC(2, null);
		NodeC nodeLevel22 = new NodeC(4, null);
		NodeC nodeLevel25 = new NodeC(10, null);

		// Creamos la lista de nodos de nivel 2
		List<Node> lstNode21 = new ArrayList<>();
		lstNode21.add(nodeLevel21);
		lstNode21.add(nodeLevel22);
		lstNode21.add(nodeLevel25);

		NodeC nodeLevel23 = new NodeC(6, null);
		NodeC nodeLevel24 = new NodeC(8, null);

		List<Node> lstNode22 = new ArrayList<>();
		lstNode22.add(nodeLevel23);
		lstNode22.add(nodeLevel24);

		// Creacion de nodos de nivel 1
		NodeC nodeLevel11 = new NodeC(1, lstNode21);
		NodeC nodeLevel12 = new NodeC(3, lstNode22);
		NodeC nodeLevel13 = new NodeC(5, null);
		NodeC nodeLevel14 = new NodeC(7, null);
		NodeC nodeLevel15 = new NodeC(9, null);
		NodeC nodeLevel16 = new NodeC(11, null);

		// Agregamos a Nivel 1 la lista.
		List<Node> lstNode = new ArrayList<>();
		lstNode.add(nodeLevel11);
		lstNode.add(nodeLevel12);
		lstNode.add(nodeLevel13);
		lstNode.add(nodeLevel14);
		lstNode.add(nodeLevel15);
		lstNode.add(nodeLevel16);
		NodeC root = new NodeC(25, lstNode);
		
		return root;
	}

	public static void main(String[] args) {
		//This method recibes Node and level. 
		System.out.println(getLevelSum(getNodes(), 1));
	}

	/**
	 * Node Object with Value and list of children implements Node interface.
	 * @author albertodiaz
	 *
	 */
	static class NodeC implements Node {
		private int value;
		private List<Node> children;

		public NodeC() {
			this.value = 0;
			children = null;
		}

		public NodeC(int value, List<Node> children) {
			this.value = value;
			this.children = children;
		}

		public int getValue() {
			return value;
		}

		public List<Node> getChildren() {
			return children;
		}

		@Override
		public String toString() {
			return "Node value : " + this.value;
		}
	}

	static int level = 1;
	static int sum = 0;
	/**
	 * Implements sum on nodes in the same level n
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
