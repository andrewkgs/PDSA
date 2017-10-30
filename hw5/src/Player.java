public class Player implements Comparable<Player>{ 

    private Card[] cards = new Card[7];
    private String name;
     
    // DO NOT MODIFY THIS
    public Player(String name) {
        this.name = name;
    }
     
    // DO NOT MODIFY THIS
    public String getName() {
        return this.name;
     }
     
    // DO NOT MODIFY THIS
    public void setCards(Card[] cards) {
        this.cards = cards;
    }
     
    // TODO 
    public int compareTo(Player that) {
        // complete this function so the Player can be sorted according to the cards he/she has.
        return 0;
    }
}

