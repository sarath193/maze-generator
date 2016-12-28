import java.util.Arrays;
import java.util.Stack;

public class MazeSolver {
	String[][] maze;
	String PATH = "@@";

	final String SPACE = "  ";
	final String WALL = "||";

	static int cols, rows;
	static int numNodes;

	boolean visited[];
	boolean deleteNodes[];

	int[] set;

	Stack<Integer> stack, stack2;

	public static void main(String[] args) {
		MazeSolver ms = new MazeSolver();
		ms.getMaze();
		ms.solveMaze();
		ms.printMaze();
	}

	void getMaze() {
		maze = MyMaze.getMaze(10, 10);
		cols = (maze[0].length - 1) / 2;
		rows = (maze.length - 1) / 2;
		numNodes = cols * rows;
		maze[2][1] = WALL;
		visited = new boolean[numNodes + 1];
		Arrays.fill(visited, false);
	}

	void solveMaze() {
		maze[2][2] = PATH;
		stack = new Stack<>();

		stack.add(1);
		visited[1] = true;

		int[] c = { 0, 1, 0, -1 }; // starts from 12 O' clock and moves
									// anti-clockwise
		int[] r = { -1, 0, 1, 0 };
		System.out.println(cols);

		while (true) {
			boolean flag = false;
			int currentNode = stack.peek();
			if (currentNode == numNodes)
				break;

			int rNode = (1 + (currentNode - 1) / cols) * 2;

			int cNode = (currentNode - (rNode - 2) / 2 * cols) * 2;

			for (int i = 0; i < 4; i++) {
				int curr_r = rNode + r[i];
				int curr_c = cNode + c[i];
				if (maze[curr_r][curr_c] == WALL) {
					continue;
				} else {
					curr_r += r[i];
					curr_c += c[i];

					int nodeNumber = cols * (int) ((curr_r - 1) / 2) + (curr_c / 2);
					if (!visited[nodeNumber]) {
						stack.add(nodeNumber);
						visited[nodeNumber] = true;
						flag = true;
						break;
					}
				}
			}
			if (!flag)
				stack.pop();
		}
		System.out.println("Reached end");

	}

	void printMaze() {
		while (!stack.isEmpty()) {
			int i = stack.pop();
			// System.out.println(i);
			int rNode = (1 + (i - 1) / cols) * 2;

			int cNode = (i - (rNode - 2) / 2 * cols) * 2;
			maze[rNode][cNode] = PATH;
			int[] c = { 0, 2, 0, -2 }; // starts from 12 O' clock and moves
										// anti-clockwise
			int[] r = { -2, 0, 2, 0 };

			for (int j = 0; j < 4; j++) {
				if (rNode + r[j] < maze.length && rNode + r[j] >= 0 && cNode + c[j] >= 0
						&& cNode + c[j] < maze[0].length && maze[rNode + r[j]][cNode + c[j]] == PATH
						&& maze[rNode + r[j] / 2][cNode + c[j] / 2] != WALL) {
					maze[rNode + r[j] / 2][cNode + c[j] / 2] = PATH;
				}
			}
		}

		System.out.println("\nSolution for Maze: ");
		maze[2][1] = maze[maze.length-2][maze[0].length-1]= PATH;
		for (int i = 1; i <= maze.length - 1; i++) {
			for (int j = 1; j <= maze[0].length - 1; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
}
