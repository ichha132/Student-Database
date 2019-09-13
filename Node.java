
public class Node<K, T> implements Node_<K, T> {
	Node left;
	Node right;
	K key;
	T obj;
	public Node(Node left, Node right, K key, T obj)
	{
		this.left=left;
		this.right=right;
		this.key=key;
		this.obj=obj;
	}

	@Override
	public Node_ getLeft() {
		// TODO Auto-generated method stub
		return this.left;
	}

	@Override
	public Node_ getRight() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public T getObj() {
		// TODO Auto-generated method stub
		return this.obj;
	}

}
