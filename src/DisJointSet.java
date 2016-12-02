
public class DisJointSet {

	private static int[] s;

	/*
	 * implementation changed slightly for convenience. Array index starts from
	 * 1.
	 * 
	 */
	public static int[] getArray(){
		return s;
	}
	
	public DisJointSet(int numElements) {
		s = new int[numElements + 1];
		for (int i = 1; i <= numElements; i++)
			s[i] = -1;
	}
	
	public void print(){
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}

	/**
	 * Union two disjoint sets using the height heuristic. For simplicity, we
	 * assume root1 and root2 are distinct and represent set names.
	 * 
	 * @param root1
	 *            the root of set 1.
	 * @param root2
	 *            the root of set 2.
	 */
	public void union(int root1, int root2) {
		if (s[root2] < s[root1]) // root2 is deeper
			s[root1] = root2; // Make root2 new root
		else {
			if (s[root1] == s[root2])
				s[root1]--; // Update height if same
			s[root2] = root1; // Make root1 new root
		}
	}

	/**
	 * Perform a find with path compression. Error checks omitted again for
	 * simplicity.
	 * 
	 * @param x
	 *            the element being searched for.
	 * @return the set containing x.
	 */
	public int find(int x) {
		if (s[x] < 0)
			return x;
		else
			return find(s[x]);
	}

}
