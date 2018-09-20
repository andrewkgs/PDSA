# HW9: Shortest path

In this assignment, you need to implement a class "Shortestpath.java" to solve a shortest path problem. <br/>

The input file will provide you the number of rows, the number of columns, the start point, the goal point, and some block points.The distance between any two points is defined below. The block points stand for the wall or some obstacles, which menas these points cannot be passed through. For the output, you need to print out the total cost of your shortest path.

## Example input
```
row 7
column 11
start 4,3
goal 4,7
block points
3,5
4,5
5,5
5,6
```

## Note
1. The four walls (row 1 and 7,column 1 and 11) are considered blocked by default and will not be given as input.
2. The length of vertical and horizontal move is 10, and the length of diagonal move is 14.
3. We will execute your main function while your code is judged in the judging system.

## Example output
```
56
```
