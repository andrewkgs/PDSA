# HW1: Percolation

## Examples of percolated and not percolated:
![](http://www.cs.princeton.edu/courses/archive/fall14/cos226/assignments/percolates.png)

## The model:
We model a percolation system using an N-by-N grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row.

## Input:
```
3
1,1
3,2
3,3
1,2
```

## Note:
The number (N) in the first row specifies the size of the system: an N-by-N grid. Each of the remaining rows in the file contains a pair of integers, i.e. the coordinates (row, column), specifying the next site to be opened.<br/>

After processing all the pairs of integers, if the system is already percolated, your program should output 0. If not, please tell whether the system percolates after opening one more site. If the answer is yes, your program should output the pair of integers that specify the coordinates of the site (row, column). If the answer is no, your program should output -1.
In other words, if you need more than one site to be opened before percolation, please output -1.

## Output:

2,2

## File to be submitted to the judge system:

You are requested to design a Java class named Percolation. So, please submitted a file named: Percolation.java <br/>
**Example file**: [hw1.zip](https://github.com/andrewkgs/PDSA/blob/master/hw1/hw1.zip)

## Related links

> http://algs4.cs.princeton.edu/code/edu/princetiion/cs/algs4/UF.java.html
> http://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/WeightedQuickUnionUF.java.html
