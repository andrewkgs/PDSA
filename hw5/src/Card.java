import java.util.Comparator;
public class Card implements Comparable<Card> {

	private String face; // should be one of [A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K]
	private String suit; // should be one of [Spades, Hearts, Diamonds, Clubs]
	
    public static final Comparator<Card> SUIT_ORDER = new SuitOrder();

    // DO NOT MODIFY THIS
    public Card(String face, String suit){
        this.face = face;
        this.suit = suit;
    }
     
    // DO NOT MODIFY THIS   
    public String getFace(){
        return this.face;
    }
    
    // DO NOT MODIFY THIS    
    public String getSuit(){
        return this.suit;
    }

    private static int face_convert(String face) {
        if (face.equals("A")) return 14;
        else if (face.equals("K")) return 13;
        else if (face.equals("Q")) return 12;
        else if (face.equals("J")) return 11;
        else return Integer.parseInt(face);
    }

    private static int suit_convert(String suit) {
        if (suit.equals("Spades")) return 3;
        else if (suit.equals("Hearts")) return 2;
        else if (suit.equals("Diamonds")) return 1;
        else if (suit.equals("Clubs")) return 0;
        else {
            StdOut.println("Invalid suit name");
            return -1;
        }
    }

    // TODO
    public int compareTo(Card that) {
        int this_card = face_convert(this.face) * 10 + suit_convert(this.suit);
        int that_card = face_convert(that.face) * 10 + suit_convert(that.suit);

        if (this_card > that_card) return 1;
        else if (this_card == that_card) return 0;
        else return -1;
    }  

    // TODO
    private static class SuitOrder implements Comparator<Card> {
        public int compare(Card c1, Card c2) {
            int c1_card = suit_convert(c1.suit);
            int c2_card = suit_convert(c2.suit);

            if (c1_card > c2_card) return 1;
            else if (c1_card == c2_card) return 0;
            else return -1;
        }
    }   
}
