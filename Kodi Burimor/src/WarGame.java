/**
 * Klasa WarGame e krijon strukturën e lojës War
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarGame
{
    //deklarimi i konstanteve
    private static final int COMPUTER_WIN = 0;
    private static final int USER_WIN = 1;
    private static final int WAR = -1;

    //Deklarimi i variablave
    private ArrayList<Card> userCards;	//"pile" i kartave të userit
    private ArrayList<Card> compCards;	//"pile" i kartave të kompjuterit
    private ArrayList<Card> warCards;	//"pile" i kartave kur kemi barazim (i jepen fituesit)c
    private Deck cardDeck;
    private Card userCard, compCard;	//kartat e vendosura "flipped" nga "pile" i userit dhe apo kompjuterit, që të krahasohen
    private int winNum;	//përmban vlerën numerike se kush e ka fituar roundin apo lojën në tërësi
    private int wagerCount; //përmban numrin e kartave të fituare qdo herë
    private boolean gameOver;	//tregon nëse loja ka mbaruar apo jo

    /**
     * Konstruktori
     */
    public WarGame()
    {
        userCards = new ArrayList<>();
        compCards = new ArrayList<Card>();
        warCards = new ArrayList<Card>();
        cardDeck = new Deck();
        gameOver = false;

        splitDeck();
    }

    /**
     * Metoda splitDeck,
     * e ndanë "deck" në mënyrë të barabart ndërmjet dy lojtarëve
     */
    public void splitDeck()
    {
        int count = 0;

        while ( cardDeck.cardsLeft() != 0 && count < 10 )
        {
            userCards.add(cardDeck.dealCard());
            compCards.add(cardDeck.dealCard());
            count++;
        }
    }

    /**
     * Metoda flipCard,
     * e largon nga një kart nga lista e secilit lojtar dhe kontrollon nëse
     * "pile" i userit apo kompjuterit nuk është i zbrazët
     */
    public void flipCard()
    {
        //nëse "pile" i userit dhe kompjuterit nuk janë të zbrazëta, "flip" (rrotullo) nga një kartë nga secili
        if (!userCards.isEmpty() && !compCards.isEmpty())
        {
            userCard = userCards.remove((userCards.size())-1);
            compCard = compCards.remove((compCards.size())-1);
        }
        //përndryshe nëse useri nuk ka asnjë kart por kompjuteri po, kompjuteri fiton
        else if (userCards.isEmpty() && !compCards.isEmpty())
        {
            //Kompjuteri fiton
            winNum = COMPUTER_WIN;
            gameOver = true;
        }
        //përndryshe nëse kompjuteri nuk ka asnjë kartë por useri po, useri fiton
        else if(!userCards.isEmpty() && compCards.isEmpty())
        {
            //Useri fiton
            winNum = USER_WIN;
            gameOver = true;
        }
        //përndryshe nëse asnjëri nuk kan karta "throw an exception"
        else if(userCards.isEmpty() && compCards.isEmpty())
        {
            throw new ListIndexOutOfBoundsException ("the arraylist is empty");
        }

    }
    /**
     * Metoda compareCards,
     * shikon se cili nga "pile" (i kompjuterit ose i userit) ka më shumë karta
     * nëse useri apo kompjuteri mbesin pa asnjë kartë, tjetri fiton
     * nëse useri dhe kompjuteri kanë karta të barabarta, kemi WAR
     */
    public void compareCards()
    {
        warCards.add(userCard);
        warCards.add(compCard);

        if (userCard.equals(compCard))
        {
            winNum = WAR;
            war();
        }
        else if (userCard.greaterThan(compCard)==true)
        {
            winNum = USER_WIN;
            wagerCount = warCards.size();
            for(Card c: warCards)

            {
                userCards.add(0,c);
            }

            //pastro arraylist e të gjithave kartave të fituara
            warCards.clear();
            //përziej kartat e userit dhe të kompjuterit
            shuffleCards();
        }
        else
        {
            winNum = COMPUTER_WIN;
            wagerCount = warCards.size();
            for(Card c: warCards)
            {
                compCards.add(0,c);
            }

            //pastro arraylist e të gjithave kartave të fituara
            warCards.clear();
            //përziej kartat e userit dhe të kompjuterit
            shuffleCards();
        }
    }


    /**
     * Metoda war,
     * kjo metod thirret atëherë ndonjë kartë e userit është e barabart me kartën e kompjuterit
     * e shton edhe një kart tjetër nga "pile" i secilit lojtarë tek numri i letrave për tu fituar
     */
    public void war()
    {
        warCards.add(userCards.remove((userCards.size())-1));
        warCards.add(compCards.remove((compCards.size())-1));
    }


    /**
     * Metoda shuffleCards,
     * bënë përzierjen e "piles" së userit dhe kompjuterit qdo round
     */
    public void shuffleCards()
    {
        //Deklarimi i variablave
        Random gen = new Random();
        int randNum;

        //vendosja e një loop-i "for" me qëllim të përzierjes së të gjitha kartave në "deck" të userit
        for (int i = 0; i < userCards.size(); i++)
        {
            randNum = gen.nextInt(userCards.size());
            Card temp = userCards.get(i);
            userCards.set(i, userCards.get(randNum));
            userCards.set(randNum, temp);

        }

        //vendosja e një loop-i "for" me qëllim të përzierjes së të gjitha kartave në "deck" të kompjuterit
        for (int i = 0; i < compCards.size(); i++)
        {
            randNum = gen.nextInt(compCards.size());
            Card temp = compCards.get(i);
            compCards.set(i, compCards.get(randNum));
            compCards.set(randNum, temp);

        }
    }

    /**
     * Metoda getUserCard,
     * @return një objekt userCard
     */
    public Card getUserCard()
    {
        return userCard;
    }

    /**
     * Metoda getCompCard,
     * @return një objekt computerCard
     */
    public Card getCompCard()
    {
        return compCard;
    }


    /**
     * Metoda getUserNumCards,
     * @return numrin e kartave të mbetura në "pile" të userit
     */
    public int getUserNumCards()
    {
        return userCards.size();
    }

    /**
     * Metoda getCompCards,
     * @return numrin e kartave të mbetura në "pile" të kompjuterit
     */
    public int getCompNumCards()
    {
        return compCards.size();
    }

    /**
     * Metoda getWagerSize
     */
    public int getWagerSize()
    {
        return wagerCount;
    }

    /**
     * Metoda getRoundWinner,
     * tregon se kush e ka fituar secilin round
     * @return një boolean se kush e ka fituar roundin
     */
    public int getRoundWinner()
    {
        return winNum;
    }


    /**
     * Metoda gameOver,
     * tregon se a ka mbaruar loja apo jo dhe
     * @return një boolean "true" nëse ka fitues dhe "false" nëse loja ende vazhdon
     */
    public boolean gameOver()
    {
        return gameOver;
    }
}
