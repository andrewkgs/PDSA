In this homework, you will be guided to learn:
1. How to draw points in a 2-dimensional plane;
2. How to use 'compareTo';
3. How to find convex hull vertices;

# Assignment: HW4-0 (practice by yourself)
1. Create N 2D points with StdRandom (store in a array of Point2D), and draw the points with StdDraw (radius = 0.01)
2. Find the point with the samllest y coordinate, and draw the point with red color
3. Base on the red point, calculate the angles of the red point to other points, and sort by angles (counterclockwise)

#Assignment: HW4-1

Write a function that takes an array of N points as the input, and return its convex hull vertices. <br/>

There is no need to read data in HW5-1, the judge system will call ConvexHullVertex of Onion.java.Please calculate the convex hull of points in Point2D[], and return the indices (in the primary array) of the points generating convexhull.

#Assignment: HW4-2

Implement Onion.java <br/>

The main function of the source code "Onion.java" must read in a input file, of which the first line specifies the number (N) of points to be read in, and the rest lines are coordinates of the N points. The main function should output the number of convex hulls generated. Shown as below:

![](http://c4lab.bime.ntu.edu.tw:25080/judge/problem/106html/onion.png)

* Input data is read by HW4-2, and the judge system will call the main function of Onion.java. the first row is an integer N, representing the number of points, the rest rows specifies the coordinates of the points (the coordintae are between 0 and 1).
* You have to read input file in HW4-2 and the judge system will run the main function in Onion.java. 

The source code "Onion.java" must have a function named "ConvexHullVertex" that takes in an array of 2D points and return a int[] of the set constituting the convex hull:
```
public class Onion {
    public static int[] ConvexHullVertex(Point2D[] a) {
	    // return the index set of the ConvexHullVertex, the index is the same as the index in array a:0, 1, 2, 3, 4, ....a.length-1
    }

    public static void main(String[] args) {
		// 1. read in the file containing N 2-dimentional points
		// 2. recursively find the convexhull of the resting points
		// 3. count the number of convexhulls and print it
    }
}
```
## Example input:
```
20
0.35 0.17
0.12 0.11
0.54 0.53
0.83 0.20
0.68 0.23
0.44 0.49
0.21 0.40
0.34 0.09
0.31 0.52
0.36 0.95
0.17 0.65
0.86 0.48
0.77 0.67
0.55 0.78
0.54 0.86
0.02 0.40
0.56 0.19
0.49 0.95
0.00 0.83
0.28 0.11
```

## Example output: 
```
3
```
