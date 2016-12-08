import java.util.Random;
import java.util.Scanner;

/*
 *  @title Maze Generator
 *  @author Sarath Chandra
 */
public class MyMaze {
	final int rows;
	final int cols;
	static String[][] maze;
	final String SPACE = "  ";
	final String WALL = "||";
	final int X;
	final int Y;
	static DisJointSet set;
	final int nodeCount;

	private int COUNTER;

	public MyMaze(int w, int h) {
		rows = h;
		cols = w;
		X = rows * 2 + 1;
		Y = cols * 2 + 1;
		nodeCount = rows * cols;
		maze = new String[X + 1][Y + 1];
		set = new DisJointSet(nodeCount);
		COUNTER = nodeCount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter width and height of Maze, separated by space: ");
		getMaze(sc.nextInt(), sc.nextInt());

	}

	public static String[][] getMaze(int width, int height) {
		MyMaze m = new MyMaze(width, height);

		m.generateGrid();
		m.createMaze();
		m.printMaze();
		// set.print();
		return maze;
	}

	/*
	 * The following method creates the maze
	 */
	private void createMaze() {
		Random rand = new Random();

		/*
		 * COUNTER maintains number of distinct sets so if the number of
		 * distinct sets is one that means all the nodes are connected.
		 */

		while (COUNTER != 1) {
			int r = rand.nextInt(X - 2) + 2;
			int c = rand.nextInt(Y - 2) + 2;

			if (((r & 1) ^ (c & 1)) == 0)
				continue;

			if (r % 2 == 0) {
				int node1 = cols * ((r - 1) / 2) + (c - 1) / 2;
				int node2 = cols * ((r - 1) / 2) + (c + 1) / 2;

				/*
				 * if the following two nodes are connected now, then counter is
				 * decreased by one and the wall between them is broken.
				 * 
				 * If they're already connected then they are left just like
				 * that.
				 */
				if (join(node1, node2)) {
					--COUNTER;
					maze[r][c] = SPACE;
				}
			} else {
				int node1 = cols * ((r - 1) / 2) + (c) / 2;
				int node2 = cols * ((r - 2) / 2) + (c) / 2;

				if (join(node1, node2)) {
					--COUNTER;
					maze[r][c] = SPACE;
				}
			}

		}

	}

	/*
	 * the following method takes two nodes and finds their parents.
	 * 
	 * if the parents are same then they are already connected.
	 * 
	 * returns false if they're already connected. else connects them.
	 */

	private boolean join(int a, int b) {
		int rootA = set.find(a);
		int rootB = set.find(b);
		if (rootA == rootB)
			return false;
		else {
			set.union(rootA, rootB);
			return true;
		}
	}

	/*
	 * The following method generates a grid of separated blocks;
	 */
	private void generateGrid() {
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				if ((i & 1) != 0) {
					maze[i][j] = WALL;
				} else {
					if ((j & 1) != 0) {
						maze[i][j] = WALL;
					} else {
						maze[i][j] = SPACE;
					}
				}
			}
		}
	}

	void printMaze() {
		System.out.println();
		System.out.println("The generated grid: \n");
		maze[2][1] = "  "; // Entry Point
		maze[X - 1][Y] = "  "; // Exit Point
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}

}
