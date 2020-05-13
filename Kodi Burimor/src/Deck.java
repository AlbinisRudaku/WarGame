import java.util.Random;
import java.util.ArrayList;

public class Deck
{

    //Deklarimi i variablave
    private ArrayList<Card> deck;	//Përmban të gjitha kartat e nevojshme për të krijuar një "deck" standard të kartave
    private int usedCards;
    private int cardCount;

    /**
     * Konstruktori default,
     * në mënyr automatike i largon xhokerat nga "deck" i kartave
     */
    public Deck()
    {
        this(false);
    }

    /**
     * Konstruktori,
     * tregon numrin e kartave në "deck" dhe shton karta tek vargu
     * @param hasJokers "a ka xhoker"
     */
    public Deck(boolean hasJokers)
    {
        deck = new ArrayList<Card>();

        //shtimi i kartave në "deck"
        cardCount = 0;
        for (int suit = 0; suit <= 3; suit++)
        {
            for(int rank = 1; rank <= 13; rank++)
            {
                deck.add(new Card(suit, rank));
                cardCount++;
            }
        }

        if (hasJokers)
        {
            deck.add(new Card(Card.JOKER,0));
            cardCount++;
            deck.add(new Card(Card.JOKER,0));
            cardCount++;
        }

        //vendosja e kartave të përdorura në 0
        usedCards = 0;

        //përzierja e kartave
        shuffleCards();

    }

    /**
     * Metoda shuffle,
     * bën përzierjen e kartave në mënyrë randome,
     * këtë e bënë duke zëvendësuar qdo kartë me një random kartë tjetër në "deck"
     */
    public void shuffleCards()
    {
        //Deklarimi i variablave
        Random random = new Random();
        int cardShuffle, randomNumber;

        if (deck.size() == 54)
        {
            cardShuffle = 54;
        }
        else
        {
            cardShuffle = 52;
        }
        //vendosja e p[rzierjes së kartave në një loop
        for (int i = 0; i <= deck.size()-1; i++)
        {
            randomNumber = random.nextInt(cardShuffle);
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomNumber));
            deck.set(randomNumber, temp);

        }

    }

    /**
     * Metoda dealCard
     * kjo metodë kthen një kartë, dhe rrit numrin e kartave të përdorura për 1
     * @return Card object
     */
    public Card dealCard()
    {
        if (usedCards == deck.size())
        {
            throw new ListIndexOutOfBoundsException("The deck is empty");
        }
        else
        {
            usedCards++;
            return deck.get(usedCards-1);
        }
    }

    /**
     * Metoda getIndex,
     * @return kthen vlerën e lokacionit të kartës në formë integer
     * nëse nuk ka asnjë kartë, kthehet numri -1
     */
    public int getIndex(Card c)
    {
        //deklarimi i variablave
        boolean equals, found = false;
        int position;
        int count = 0;

        while(found == false)
        {
            equals = c.equals(deck.get(count));
            if (equals == true)
            {
                found = equals;
            }
            else
            {
                found = equals;
                count++;
            }

        }
        if (found == true)
        {
            position = count;
        }
        else
        {
            position = -1;
        }
        return position;
    }

    /**
     * Metoda cardsLeft,
     * @return numrin e kartave të papërdorura të mbetura në "deck"
     */
    public int cardsLeft()
    {
        return (deck.size() - usedCards);
    }


    /**
     * Metoda hasJokers,
     * @return një vlerë boolean, varësisht nëse "deck" i kartave ka xhokera apo jo
     */
    public boolean hasJokers()
    {
        if (deck.size() == 54)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}