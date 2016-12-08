# maze-generator

The project involves generating a maze using Disjoint Sets Data Structure.

The idea is generating a grid first and then taking a wall randomly 
and we check if the two blocks which are adjacent to the wall, are connected or not.

If they are already connected we leave them as they were, but if they are not connected we break down the wall between them.
 
We continue this, till every block is connected with every other block.

Using Disjoint Sets :
  a. Initially every block is considered to be in a separate set.
  b. Whenever two blocks need to be connected, we union the two sets which contain the two blocks.
  c. We continue this, till every block is in same set.
 
 Example output : 
 
 ||||||||||||||||||||||||||||||||||||||||||
    ||  ||      ||      ||      ||  ||  ||
||  ||  ||||||  ||  ||||||  ||||||  ||  ||
||  ||  ||  ||          ||  ||  ||      ||
||  ||  ||  ||||||  ||||||  ||  ||  ||  ||
||                  ||              ||  ||
||||||  ||||||  ||  ||  ||||||  ||||||  ||
||          ||  ||          ||      ||  ||
||  ||  ||  ||||||||||||||||||||||  ||||||
||  ||  ||  ||      ||  ||  ||          ||
||||||||||||||||||  ||  ||  ||  ||||||||||
||  ||          ||  ||                  ||
||  ||  ||  ||||||  ||  ||||||  ||||||  ||
||      ||  ||  ||      ||  ||  ||  ||  ||
||  ||  ||||||  ||  ||  ||  ||  ||  ||||||
||  ||          ||  ||      ||          ||
||  ||  ||||||  ||||||||||  ||  ||  ||||||
||  ||  ||              ||  ||  ||      ||
||||||  ||||||||||||||  ||  ||  ||||||||||
||      ||                  ||            
||||||||||||||||||||||||||||||||||||||||||
  
  
Maze Solver: The maze solver class uses DFS to solve the maze and find a path. To draw the path, and to keep track of nodes in the path are maintained in a stack.
Starting from node 1, in each loop, the stack is peeked and one of the unvisited child is pushed into the stack till we reach a dead end. Then the node is popped until we find a differnet branch. We continue doing this, till we reach the final node.
Then all the nodes in the stack are the nodes in the path. Connecting them with a different character gives us a path.

Solution for the above maze:

||||||||||||||||||||||||||||||||||||||||||
@@@@||  ||      ||      ||      ||  ||  ||
||@@||  ||||||  ||  ||||||  ||||||  ||  ||
||@@||  ||  ||          ||  ||  ||      ||
||@@||  ||  ||||||  ||||||  ||  ||  ||  ||
||@@@@@@@@@@@@@@@@@@||@@@@@@@@@@    ||  ||
||||||  ||||||  ||@@||@@||||||@@||||||  ||
||          ||  ||@@@@@@    ||@@@@@@||  ||
||  ||  ||  ||||||||||||||||||||||@@||||||
||  ||  ||  ||      ||  ||  ||@@@@@@    ||
||||||||||||||||||  ||  ||  ||@@||||||||||
||  ||          ||  ||        @@        ||
||  ||  ||  ||||||  ||  ||||||@@||||||  ||
||      ||  ||  ||      ||  ||@@||  ||  ||
||  ||  ||||||  ||  ||  ||  ||@@||  ||||||
||  ||          ||  ||      ||@@        ||
||  ||  ||||||  ||||||||||  ||@@||  ||||||
||  ||  ||              ||  ||@@||      ||
||||||  ||||||||||||||  ||  ||@@||||||||||
||      ||                  ||@@@@@@@@@@@@
||||||||||||||||||||||||||||||||||||||||||
