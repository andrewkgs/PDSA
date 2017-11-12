import java.util.Arrays;

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

    private int[] face_array(Card[] card, int x, int y, int z) {
        int[] faces = new int[13];
        faces[face_convert(card[0].getFace()) - 2] += 1;
        faces[face_convert(card[1].getFace()) - 2] += 1;
        faces[face_convert(card[x].getFace()) - 2] += 1;
        faces[face_convert(card[y].getFace()) - 2] += 1;
        faces[face_convert(card[z].getFace()) - 2] += 1;

        return faces;
    }

    private int[] suit_array(Card[] card, int x, int y, int z) {
        int[] suits = new int[4];
        suits[suit_convert(card[0].getSuit())] += 1;
        suits[suit_convert(card[1].getSuit())] += 1;
        suits[suit_convert(card[x].getSuit())] += 1;
        suits[suit_convert(card[y].getSuit())] += 1;
        suits[suit_convert(card[z].getSuit())] += 1;

        return suits;
    }

    private boolean isFourAKind(Card[] card, int x, int y, int z) {
        int[] faces;

        faces = face_array(card, x, y, z);
        Arrays.sort(faces);

        return faces[12] == 4;
    }

    private boolean isFullHouse(Card[] card, int x, int y, int z) {
        int[] faces;

        faces = face_array(card, x, y, z);
        Arrays.sort(faces);

        return (faces[12] == 3 && faces[11] == 2);
    }

    private boolean isFlush(Card[] card, int x, int y, int z) {
        int[] suits;

        suits = suit_array(card, x ,y, z);
        Arrays.sort(suits);

        return suits[3] == 5;
    }

    private boolean isStraight(Card[] card, int x, int y, int z) {
        int[] faces;

        faces = face_array(card, x, y, z);

        if (faces[12] == 1 && faces[0] == 1 && faces[1] == 1 && faces[2] == 1 && faces[3] == 1) return true;

        for (int i=0; i<9; i++) {
            if (faces[i] == 1) {
                if (faces[i+1] == 1) {
                    if (faces[i+2] == 1) {
                        if (faces[i+3] == 1) {
                            if (faces[i+4] == 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isTwoPair(Card[] card, int x, int y, int z) {
        int faces[];

        faces = face_array(card, x, y, z);
        Arrays.sort(faces);

        return (faces[12] == 2 && faces[11] == 2);
    }

    private boolean isOnePair(Card[] card, int x, int y, int z) {
        int faces[];

        faces = face_array(card, x, y, z);
        Arrays.sort(faces);

        return (faces[12] == 2 && faces[11] == 1);
    }

    private Card[] hand_assign(Card[] card, Card[] hands, int[] common) {
        hands[0] = card[0];
        hands[1] = card[1];
        hands[2] = card[common[1]]; // common in hand is in index 1, 2, 3
        hands[3] = card[common[2]];
        hands[4] = card[common[3]];

        Arrays.sort(hands);

        return hands;
    }

    private int rankFourAKind(Card[] card, int[] common) {
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        if (hands[0].getFace().equals(hands[1].getFace())) return face_convert(hands[0].getFace());
        else return face_convert(hands[1].getFace());
    }

    private int[] rankFullHouse(Card[] card, int[] common) {
        int[] ranking = new int[2];
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        ranking[0] = face_convert(hands[0].getFace());
        ranking[1] = face_convert(hands[4].getFace());

        return ranking;
    }

    private Card[] rankFlush(Card[] card, int[] common) {
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        return hands;
    }

    private Card[] rankStraight(Card[] card, int[] common) {
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        if (hands[4].getFace().equals("A")) {
            Card[] modified_hands = new Card[5];

            for (int i=1; i<5; i++) modified_hands[i] = hands[i-1];
            modified_hands[0] = hands[4];
            hands = modified_hands;
        }
        return hands;
    }

    private int[] rankTwoPair(Card[] card, int[] common) {
        int[] ranking = new int[2];
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        if (hands[3].getFace().equals(hands[4].getFace())) {
            ranking[0] = face_convert(hands[4].getFace());
            if (hands[1].getFace().equals(hands[2].getFace())) ranking[1] = face_convert(hands[2].getFace());
            else ranking[1] = face_convert(hands[1].getFace());
        }
        else {
            ranking[0] = face_convert(hands[3].getFace());
            ranking[1] = face_convert(hands[1].getFace());
        }
        return ranking;
    }

    private Card[] rankOnePair(Card[] card, int[] common) {
        Card[] pair = new Card[2];
        Card[] hands = new Card[5];

        hands = hand_assign(card, hands, common);

        int i=0;
        while (!hands[i].getFace().equals(hands[i+1].getFace())) i += 1;

        pair[0] = hands[i]; // smaller
        pair[1] = hands[i+1]; // greater

        return pair;
    }

    private Card[] rankHighCard(Card[] card) {
        Card[] all_common_cards = new Card[5];
        Card[] hands = new Card[5];

        for (int i=0; i<5; i++) all_common_cards[i] = card[i+2];
        Arrays.sort(all_common_cards);

        hands[0] = card[0];
        hands[1] = card[1];
        hands[2] = all_common_cards[2];
        hands[3] = all_common_cards[3];
        hands[4] = all_common_cards[4];
        Arrays.sort(hands);

        return hands;
    }

    private int[] hand_info(Card[] cards) {
        int[] a = new int[4];
        for (int i=2; i<7; i++) {
            for (int j=i+1; j<7; j++) {
                for (int k=j+1; k<7; k++) {
                    if (isFourAKind(cards, i, j, k)) {
                        a[0] = 6;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                    else if (a[0] < 5 && isFullHouse(cards, i, j, k)) {
                        a[0] = 5;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                    else if (a[0] < 4 && isFlush(cards, i, j, k)) {
                        a[0] = 4;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                    else if (a[0] < 3 && isStraight(cards, i, j, k)) {
                        a[0] = 3;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                    else if (a[0] < 2 && isTwoPair(cards, i, j, k)) {
                        a[0] = 2;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                    else if (a[0] < 1 && isOnePair(cards, i, j, k)) {
                        a[0] = 1;
                        a[1] = i;
                        a[2] = j;
                        a[3] = k;
                    }
                }
            }
        }
        return a;
    }

    // TODO 
    public int compareTo(Player that) {
        // complete this function so the Player can be sorted according to the cards he/she has.

        if (hand_info(this.cards)[0] > hand_info(that.cards)[0]) return 1;
        else if (hand_info(this.cards)[0] < hand_info(that.cards)[0]) return -1;
        else {

            int index;

            switch (hand_info(this.cards)[0]) {
                case 0:
                    index = 4;
                    while (rankHighCard(this.cards)[index].compareTo(rankHighCard(that.cards)[index]) == 0) index--;
                    return rankHighCard(this.cards)[index].compareTo(rankHighCard(that.cards)[index]);

                case 1:
                    if (rankOnePair(this.cards, hand_info(this.cards))[1].compareTo(rankOnePair(that.cards, hand_info(that.cards))[1]) > 0) return 1;
                    else if (rankOnePair(this.cards, hand_info(this.cards))[1].compareTo(rankOnePair(that.cards, hand_info(that.cards))[1]) < 0) return -1;
                    else if (rankOnePair(this.cards, hand_info(this.cards))[0].compareTo(rankOnePair(that.cards, hand_info(that.cards))[0]) > 0) return 1;
                    else if (rankOnePair(this.cards, hand_info(this.cards))[0].compareTo(rankOnePair(that.cards, hand_info(that.cards))[0]) < 0) return -1;
                    else return 0;

                case 2:
                    if (rankTwoPair(this.cards, hand_info(this.cards))[0] > rankTwoPair(that.cards, hand_info(that.cards))[0]) return 1;
                    else if (rankTwoPair(this.cards, hand_info(this.cards))[0] < rankTwoPair(that.cards, hand_info(that.cards))[0]) return -1;
                    else if (rankTwoPair(this.cards, hand_info(this.cards))[1] > rankTwoPair(that.cards, hand_info(that.cards))[1]) return 1;
                    else if (rankTwoPair(this.cards, hand_info(this.cards))[1] < rankTwoPair(that.cards, hand_info(that.cards))[1]) return -1;
                    else return 0;

                case 3:
                    index = 4;
                    while (rankStraight(this.cards, hand_info(this.cards))[index].compareTo(rankStraight(that.cards, hand_info(that.cards))[index]) == 0) index--;
                    return rankStraight(this.cards, hand_info(this.cards))[index].compareTo(rankStraight(that.cards, hand_info(that.cards))[index]);

                case 4:
                    index = 4;
                    while (rankFlush(this.cards, hand_info(this.cards))[index].compareTo(rankFlush(that.cards, hand_info(that.cards))[index]) == 0) index--;
                    return rankFlush(this.cards, hand_info(this.cards))[index].compareTo(rankFlush(that.cards, hand_info(that.cards))[index]);

                case 5:
                    if (rankFullHouse(this.cards, hand_info(this.cards))[0] > rankFullHouse(that.cards, hand_info(that.cards))[0]) return 1;
                    else if (rankFullHouse(this.cards, hand_info(this.cards))[0] < rankFullHouse(that.cards, hand_info(that.cards))[0]) return -1;
                    else if (rankFullHouse(this.cards, hand_info(this.cards))[1] > rankFullHouse(that.cards, hand_info(that.cards))[1]) return 1;
                    else if (rankFullHouse(this.cards, hand_info(this.cards))[1] < rankFullHouse(that.cards, hand_info(that.cards))[1]) return -1;
                    else return 0;

                case 6:
                    if (rankFourAKind(this.cards, hand_info(this.cards)) > rankFourAKind(that.cards, hand_info(that.cards))) return 1;
                    else if (rankFourAKind(this.cards, hand_info(this.cards)) < rankFourAKind(that.cards, hand_info(that.cards))) return -1;
                    else return 0;
            }
        }
        return 0;
    }
}
