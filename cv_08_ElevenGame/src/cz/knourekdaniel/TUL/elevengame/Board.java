package cz.knourekdaniel.TUL.elevengame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the table with cards to play and a deck
 * @author janvit
 */
public class Board implements BoardInterface{
    private Card[] cards;
    private Deck deck;

    public Board(){
        //create deck
        deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        //deal cards
        cards = new Card[9];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.deal();
        }
    }

    @Override
    public String gameName() {
        return "Hra jedenactka";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }

    @Override
    public String getCardDescriptionAt(int index){
        if(cards[index] == null){
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        List<String> triple = new ArrayList<>();
        triple.addAll(Arrays.asList( DataStore.getTriple() ));
        int[] tripleIndexes = new int[]{0,0,0}; //cheats
//        boolean possibleMove = false;



        for (int i = 0; i < cards.length; i++) {
            if (triple.contains( cards[i].getValue() )){
                tripleIndexes[triple.size()-1] = i; //cheats
                triple.remove(cards[i].getValue());
                if (triple.size() == 0){
                    System.out.println((tripleIndexes[0] + " + " + tripleIndexes[1] + " + " + tripleIndexes[2] )); //cheats
                    return true;
                }
            }
            for (int j = i+1; j < cards.length; j++) {
                if (cards[i].getnPoints() + cards[j].getnPoints() == 11){
                    System.out.println((i+1) + " + " + (j+1)); //cheats
                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        List<String> selectedCards = new ArrayList<>();
        for (int iSelectedCard : iSelectedCards) {
            selectedCards.add(cards[iSelectedCard].getValue());
        }
        if (selectedCards.size() == 3){
            if (    selectedCards.contains(DataStore.getTriple()[0]) &&
                    selectedCards.contains(DataStore.getTriple()[1]) &&
                    selectedCards.contains(DataStore.getTriple()[2]) ){
                cards[iSelectedCards[0]] = deck.deal();
                cards[iSelectedCards[1]] = deck.deal();
                cards[iSelectedCards[2]] = deck.deal();
                return true;
            }
        }else if(iSelectedCards.length == 2 &&
                cards[iSelectedCards[0]].getnPoints() + cards[iSelectedCards[1]].getnPoints() == 11){
            cards[iSelectedCards[0]] = deck.deal();
            cards[iSelectedCards[1]] = deck.deal();
            return true;
        }
        return false;
    }

    @Override
    public boolean isWon() {
        return (deck.isEmpty() && nCards() == 0);
    }
}
