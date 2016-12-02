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
  
  
