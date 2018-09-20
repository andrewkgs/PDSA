# HW5 - Poker Game

In this homework, there are three Java classes involved. Please implement some functions in Player.java and Card.java.

## Assignment: HW5-1

The Card class should finish compareTo and SuitOrder, so the Card can be sorted. <br/>

* HW5-1 不需要讀檔

## Assignment: HW5-2

The Game Class deals two cards to each player (the number of players is given in the first line of the input file). Given that there are five community cards (公用牌, in line 2~6), the Game Class will judge who has the best five card poker hand by combining each player's own two cards with three of the community cards. (從5張公用牌中挑出3張,和自己的兩張做組合) <br/>

If multiple players have same priority of hands, compare the high card in it to decide who wins the game. For example, if David has one pair (Spades 10 and Diamonds 10) and Mary has one pair, too (Hearts 10 and Clubs 10), David is the winner, because Spades 10 is higher than Heart 10. (More information please see hint.txt in hw5.zip). <br/>

We only consider seven types of hands in the following order (Four of a kind > full house > flush > straight > two pair > one pair > high card)

### Reference
http://en.wikipedia.org/wiki/List_of_poker_hands

### Submission
When you are doing the homework, you put all the three class files in the same project. When submitting the homework, you will be requested to upload 'Card.java' and 'Player.java' separately. These files will be judged independently, which means that you are not allowed to modify the interface of the functions.

**Files**: [hw5.zip](https://github.com/andrewkgs/PDSA/blob/master/hw5/hw5.zip)

### Example input
```
4
Diamonds_10
Spades_10
Spades_9
Hearts_Q
Clubs_6
Kristoff
Hearts_10,Hearts_9
Elsa
Spades_A,Hearts_K
Anna
Diamonds_J,Diamonds_K
Olaf
Clubs_A,Hearts_8
```

### Example output
```
Kristoff
```
