# HW9: Shortest path

## HW9-1
In this assignment, you need to implement a class "Shortestpath.java" to solve a shortest path problem. <br/>

The input file will provide you the number of rows, the number of columns, the start point, the goal point, and some block points.The distance between any two points is defined below. The block points stand for the wall or some obstacles, which menas these points cannot be passed through. For the output, you need to print out the total cost of your shortest path.

### Example input:
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

### Note: 
1. The four walls (row 1 and 7,column 1 and 11) are considered blocked by default and will not be given as input.
2. The length of vertical and horizontal move is 10, and the length of diagonal move is 14.
3. We will execute your main function while your code is judged in the judging system.

### Example output: 
```
56
```

## HW9-2
In this assignment, you need to implement a class "Block.java" to solve a dynamic shortest path problem.<br/>

In HW9-2, the input file is the same as that of HW9-1. So, please first build the initial map according to the input. Next, find the shortest path from the start point to the goal point. The rule here is that you can only take one step in one iteration. In HW9-2, there will be more points become blocked in each iteration. Since there may be some points blocked on your way, so you need to update your shortest path dynamically. While you reach the goal point, the process is done. We will call the cost() function to get your final cost. Make sure you implement the functions listed below in your class. 
```
public class Block {
    private int cost;
    public void init(String file){
        // Read in the file and build an initial map. 
    }
    public boolean isfinished(){
        // Return true if the goal point is reached.
	return true;
    }
    public String addblock(String[] points){
        // After each single step, this function will be called to add some new block points in the map.
	// Return the next step you choose.(Ex: 4,5)
	return null;
    }
    public int cost(){ 
        // Return the total cost of the path you build recently.
        return cost;
    }

}
```

### Note: 
1. We will run our own main function in this part of assignment.

**Example file**: [hw9-2.zip](https://github.com/andrewkgs/PDSA/blob/master/hw9/hw9-2.zip)
