package cmput402.tdd.game;



import cmput402.tdd.App;
import cmput402.tdd.User;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class DeckTest {




    @Test
    public void testCreateDeck() {


        Deck new_deck = new Deck();



        Card new_card = new_deck.drawCard();



        assertFalse(new_card.retunCardNumber() == 0);

    }

    @Test

    public void testUniqueCard(){
        Deck new_deck  = new Deck();
        Card tempCard;

        int totalCount[] = new int[13];


        for (int i = 0; i < 52; i++){
            tempCard = new_deck.drawCard();
            totalCount[tempCard.retunCardNumber()]++;
        }

        for (int i = 0; i <13; i++){
            assertFalse(totalCount[i] > 4);
        }




    }


}
