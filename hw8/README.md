# HW8 - Building and using 2d-tree

## Assignment

Find all points in a query axis-aligned rectangle.

## Descriptions

Please design a class 'RangeSearch.java' which contains the following two public functions:

* Notice that the judge system will not execute the main function in RangeSearch.java

* Please use the Point2D from algs4.jar

1. Construct a 2d-tree when given a Point2D array
```
public void init(Point2D[] points){
    return;
}
```

2. Report the points in a given rectangle
```
public Point2D[] query(Point2D ll, Point2D ur){ 
    //"ll" is the lower left corner of the rectangle, "ur" is the upper right corner of the rectangle.
    //Points returned should be sorted first by their y coordinates.
    //If there are two points with the same y coordinate, sort the points by their x coordinates.
    Point2D[] result = new Point2D[];
    return result;
}
```

## Examples

If the points passed into the init function are as follows:
```
0.3833339428 0.1459115606
0.3426077152 0.7218207763
0.3406783533 0.3164794008
0.5034046695 0.7964833541
0.5969555271 0.1587087880
0.2126349801 0.4842532332
0.5299519862 0.4636946673
0.1171932327 0.6117403964
0.8730132530 0.5332436770
0.6247044587 0.0213209046
0.9218660505 0.7907778275
0.4253832308 0.3123947194
0.4526798481 0.8498759517
0.5245860322 0.0488684727
0.3255085068 0.9310410020
0.7281417757 0.7145077083
0.5720377234 0.4108029499
0.0447830281 0.2155560961
0.8674125381 0.2314056188
0.4914579564 0.8431045366
```

And the judge system query a rectangle with lower left corner(0.2 , 0.3) and upper right corner(0.7 , 0.8), the function should return points as below:
```
0.425383 0.312395
0.340678 0.316479
0.572038 0.410803
0.529952 0.463695
0.212635 0.484253
0.342608 0.721821
0.503405 0.796483
```
![](https://github.com/andrewkgs/PDSA/blob/master/hw8/example.png)

**Example file**: [hw8.zip](https://github.com/andrewkgs/PDSA/blob/master/hw8/hw8.zip)
