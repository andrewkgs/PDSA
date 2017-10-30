# HW5 - Poker Game

In this homework, there are three Java classes involved. Please implement some functions in Player.java and Card.java.

## Assignment: HW5-1

The Card class should finish compareTo and SuitOrder, so the Card can be sorted. <br/>

HW5-1不需要讀檔

## Assignment: HW5-2

The Game Class deals two hole cards to each player (the number of players is given in the first line of the input file),and there are five community card(公用牌,in line 2~6), judges who has the best five card poker hand from any combination of the seven cards of the five community cards and their own two hole cards. <br/>

If multiple players have same priority of hands, compare the high card in it to decide who wins the game. For example, if David has one pair (Spades 10 and Diamonds 10) and Mary has one pair, too (Hearts 10 and Clubs 10), David is the winner, because Spades 10 is higher than Heart 10. (suit priority , Spades > Hearts > Diamonds > Clubs). <br/>

We only consider seven types of hands in the following order (Four of a kind > full house > flush > straight > two pair > one pair > high card).

### Reference
http://en.wikipedia.org/wiki/List_of_poker_hands

### Submission
When you are doing the homework, you put all the three class files in the same project. When submitting the homework, you will be requested to upload 'Card.java' and 'Player.java' separately. These files will be judged independently, which means that you are not allowed to modify the interface of the functions.

**Files**: [hw5.zip](https://github.com/andrewkgs/PDSA/blob/master/hw5/hw5.zip)

### Example output: 
```
Kristoff
```
