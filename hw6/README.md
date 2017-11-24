# HW6: A* Search

## Examples of A* Search

![](https://github.com/andrewkgs/PDSA/blob/master/hw6/A_star.png)

A* search algorithm is a well-known algorithm for pathfinding and graph traversal. Based on its main idea, there are three important values which are f, g, and h you must concern. The g value is the real distance you go step by step from the start point to the current point. The h value is an estimated distance from the current point to the goal point. And the f value is the sum of g and h, which is the main target you need to minimize to get the best solution.<br/>

Video instruction: [link](https://www.youtube.com/watch?v=_CBhTubi-CU) 

## Assignment

In this assignment, you need to implement a class "Search.java" to solve a shortest path problem using A* search algorithm. Please follow the pseudocode in the link and try to finish the rest of the class.You need to use the MinPQ in algs4.jar in your program. The h value of each point is given as an input, so you don't need to worry about this part. 

```
public class Search {
    private final static int VH_length = 10; // The length of vertical and horizontal move is 10.
    private final static int Dia_length = 14; // The length of diagonal move is 14.
    //private MinPQ<>
}
```

## Note: 
* You must use the MinPQ to implement your program. 
* Adding the neighbors in the order of right -> lower right -> down -> lower left -> left -> upper left -> up -> upper right. 
* If there's two point with the same f value, make the point with larger g value have the priority in delMin. 


The input file will provide you the row, column, start point, goal point, and a row-by-column table filled with numbers or "nn". The numbers are the h values of the points. The "nn" means the wall or some obstacles, which implies this point cannot be passed through. Every number or "nn" is split by a space. For the output, you need to print out two things. One is the total cost in this path, and the other is the the shortest path including every point from the start point to the goal point. 

## Example input:
```
row 7
column 11
start 4,3
goal 4,7
nn nn nn nn nn nn nn nn nn nn nn 
nn 58 48 38 28 24 20 24 28 38 nn 
nn 62 52 42 nn 14 10 14 24 34 nn 
nn 66 56 52 nn 10 0 10 20 30 nn 
nn 68 58 48 nn nn 10 14 24 34 nn 
nn 64 54 44 34 24 20 24 28 38 nn 
nn nn nn nn nn nn nn nn nn nn nn
```

## Example output:
```
56
4,3
3,4
2,5
3,6
4,7
```

**Example file** : [hw6.zip](https://github.com/andrewkgs/PDSA/blob/master/hw6/hw6.zip)
