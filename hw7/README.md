# HW7

## Assignment 7-1: NewBST

Finding a given node x's inorder predecessors and successors is useful in many applications. However, they are not implemented in Class BST from algs4.jar, Let's do it by ourselves. <br/>
 
In this assignment, you need to implement a class "NewBST.java". <br/>

Try to inherit BST.java in algs4.jar so you can find a node x's predecessor, successors, following the API below:

```
public class NewBST<Key extends Comparable<Key>, Value> extends BST{
    public Value predecessor(Key key, int m){
    }
    public Value successor (Key key, int m){ 
    }
}
```

### Special cases:
1. Return the m-th predecessor or successor, if there's no such element, go to the other end and search, as picture b.
2. If key doesn't exist, return null.
 
For example, in the NewBST as picture a (key: int, value: char).

![](https://github.com/andrewkgs/PDSA/blob/master/hw7/BST.jpg)

predecessor(7, 2)=h; predecessor(4, 2)=e; predecessor(84, 0)=e; predecessor(6, 0)=null
 
We won't execute main() in this program.

**Example file** : [hw7-1.zip](https://github.com/andrewkgs/PDSA/blob/master/hw7/hw7-2.zip)

## Assignment 7-2: Prize

There is a festival in PDSA city called LOTTO festival.
On this day, every citizen of this city can assign for a lucky draw.
The draw would be hold several times on that day. <br/>

The procedures are all on Net, as following:
1.  Total N people can join. N > 0
2.  Enter your name and a number X. -500N ≤ X ≤ 500N. X must not been chosen by another person yet.
3.  After N people assigned, a winning number W will be chosen among people's X. The person with that number win the first prize. People with ±M nearest X win second prize.
 
In this assignment, you need to write a program "Prize.java", which reads N, M, W, names and their corresponding X. Print winners of the game. <br/>

Use Class NewBST to store data and search, we'll use our NewBST.java while judging, you don't need to copy the whole class to this program. <br/>
 
### Example input, output

For your convenience, one case occurs on its own in testing data. <br/>
It's promised that all the input constraints are followed (e.g. don't worry if N is positive).

![](https://github.com/andrewkgs/PDSA/blob/master/hw7/example.jpg)

**Example file** : [hw7-2.zip](https://github.com/andrewkgs/PDSA/blob/master/hw7/hw7-2.zip)
