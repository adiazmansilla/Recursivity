package tree;

import java.util.List;

public class Node {
	
	private int value;
	private List<Node> children;

	public Node() {
		this.value = 0;
		children = null;
	}

	public Node(int value, List<Node> children) {
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
