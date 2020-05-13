import javax.swing.*;

/** Klasa CARD krijon objektet (kartat) gjithsej 52,
 * metodat e sajë kthejnë "suit" (figurën) dhe/ose "rank" (numrin)
 * dhe lejojnë krahasimin e letrave (kartave).
 */
public class Card extends JFrame
{

    //Deklarimi i konstanteve
    public final static int CLUBS = 0;
    public final static int DIAMONDS = 1;
    public final static int HEARTS = 2;
    public final static int SPADES = 3;
    public final static int JOKER = 4;


    //Deklarimi i variablave
    private final int suit;
    private final int faceName;
    private final ImageIcon image;

    /**
     * Konstruktori,
     * nëse nuk ka parametra si default vendoset "Joker" xhokeri
     */
    public Card()
    {
        suit = JOKER;
        faceName = 0;
        image = new ImageIcon("src/images/joker.jpg");
    }

    /**
     * Konstruktori
     */
    public Card (int theSuit, int theFaceName)
    {
        suit = theSuit;
        faceName = theFaceName;
        image = imageOfCard();

    }

    /**
     * Metoda getImage,
     * @return ImageIcon e kartës së cekur
     */
    public ImageIcon getImage()
    {
        return image;
    }
    /**
     * Metoda suitToString,
     * @return vlerën e "suit" në form stringu
     */

    private String suitToString()
    {
        switch(suit)
        {
            case CLUBS:
            {
                return "Clubs";

            }
            case DIAMONDS:
            {
                return "Diamonds";

            }
            case HEARTS:
            {
                return "Hearts";

            }
            case SPADES:
            {
                return "Spades";

            }
            default:
            {
                return "Joker";

            }
        }
    }

    /**
     * Metoda faceNameToString,
     * @return vlerën e "rank" në formë stringu
     */
    private String faceNameToString()
    {
        if (suit == JOKER)
        {
            return "0";
        }
        else
        {
            switch( faceName )
            {
                case 1:
                {
                    return "Ace";
                }
                case 2:
                {
                    return "2";
                }
                case 3:
                {
                    return "3";
                }
                case 4:
                {
                    return "4";
                }
                case 5:
                {
                    return "5";
                }
                case 6:
                {
                    return "6";
                }
                case 7:
                {
                    return "7";
                }
                case 8:
                {
                    return "8";
                }
                case 9:
                {
                    return "9";
                }
                case 10:
                {
                    return "10";
                }
                case 11:
                {
                    return "Jack";
                }
                case 12:
                {
                    return "Queen";
                }
                case 13:
                {
                    return "King";
                }
                default:
                {
                    return "King";
                }
            }
        }
    }

    /**
     * Metoda imageOfCard ia vendos fotografinë qdo karte nga "path-i" ku janë te vendosura fotografitë,
     * @return ImageIcon të fotografive të vendosura tek kartat e vlerës së caktuar
     */
    private ImageIcon imageOfCard()
    {
        switch(suit)
        {
            case CLUBS:
            {
                switch( faceName )
                {
                    case 1:
                    {
                        return new ImageIcon("src/images/acec.jpg");
                    }
                    case 2:
                    {
                        return new ImageIcon("src/images/2c.jpg");
                    }
                    case 3:
                    {
                        return new ImageIcon("src/images/3c.jpg");
                    }
                    case 4:
                    {
                        return new ImageIcon("src/images/4c.jpg");
                    }
                    case 5:
                    {
                        return new ImageIcon("src/images/5c.jpg");
                    }
                    case 6:
                    {
                        return new ImageIcon("src/images/6c.jpg");
                    }
                    case 7:
                    {
                        return new ImageIcon("src/images/7c.jpg");
                    }
                    case 8:
                    {
                        return new ImageIcon("src/images/8c.jpg");
                    }
                    case 9:
                    {
                        return new ImageIcon("src/images/9c.jpg");
                    }
                    case 10:
                    {
                        return new ImageIcon("src/images/10c.jpg");
                    }
                    case 11:
                    {
                        return new ImageIcon("src/images/jackc.jpg");
                    }
                    case 12:
                    {
                        return new ImageIcon("src/images/queenc.jpg");
                    }
                    case 13:
                    {
                        return new ImageIcon("src/images/kingc.jpg");
                    }
                }
            }
            case DIAMONDS:
            {
                switch( faceName )
                {
                    case 1:
                    {
                        return new ImageIcon("src/images/aced.jpg");
                    }
                    case 2:
                    {
                        return new ImageIcon("src/images/2d.jpg");
                    }
                    case 3:
                    {
                        return new ImageIcon("src/images/3d.jpg");
                    }
                    case 4:
                    {
                        return new ImageIcon("src/images/4d.jpg");
                    }
                    case 5:
                    {
                        return new ImageIcon("src/images/5d.jpg");
                    }
                    case 6:
                    {
                        return new ImageIcon("src/images/6d.jpg");
                    }
                    case 7:
                    {
                        return new ImageIcon("src/images/7d.jpg");
                    }
                    case 8:
                    {
                        return new ImageIcon("src/images/8d.jpg");
                    }
                    case 9:
                    {
                        return new ImageIcon("src/images/9d.jpg");
                    }
                    case 10:
                    {
                        return new ImageIcon("src/images/10d.jpg");
                    }
                    case 11:
                    {
                        return new ImageIcon("src/images/jackd.jpg");
                    }
                    case 12:
                    {
                        return new ImageIcon("src/images/queend.jpg");
                    }
                    case 13:
                    {
                        return new ImageIcon("src/images/kingd.jpg");
                    }
                }

            }
            case HEARTS:
            {
                switch( faceName )
                {
                    case 1:
                    {
                        return new ImageIcon("src/images/aceh.jpg");
                    }
                    case 2:
                    {
                        return new ImageIcon("src/images/2h.jpg");
                    }
                    case 3:
                    {
                        return new ImageIcon("src/images/3h.jpg");
                    }
                    case 4:
                    {
                        return new ImageIcon("src/images/4h.jpg");
                    }
                    case 5:
                    {
                        return new ImageIcon("src/images/5h.jpg");
                    }
                    case 6:
                    {
                        return new ImageIcon("src/images/6h.jpg");
                    }
                    case 7:
                    {
                        return new ImageIcon("src/images/7h.jpg");
                    }
                    case 8:
                    {
                        return new ImageIcon("src/images/8h.jpg");
                    }
                    case 9:
                    {
                        return new ImageIcon("src/images/9h.jpg");
                    }
                    case 10:
                    {
                        return new ImageIcon("src/images/10h.jpg");
                    }
                    case 11:
                    {
                        return new ImageIcon("src/images/jackh.jpg");
                    }
                    case 12:
                    {
                        return new ImageIcon("src/images/queenh.jpg");
                    }
                    case 13:
                    {
                        return new ImageIcon("src/images/kingh.jpg");
                    }
                }

            }
            case SPADES:
            {
                switch( faceName )
                {
                    case 1:
                    {
                        return new ImageIcon("src/images/aces.jpg");
                    }
                    case 2:
                    {
                        return new ImageIcon("src/images/2s.jpg");
                    }
                    case 3:
                    {
                        return new ImageIcon("src/images/3s.jpg");
                    }
                    case 4:
                    {
                        return new ImageIcon("src/images/4s.jpg");
                    }
                    case 5:
                    {
                        return new ImageIcon("src/images/5s.jpg");
                    }
                    case 6:
                    {
                        return new ImageIcon("src/images/6s.jpg");
                    }
                    case 7:
                    {
                        return new ImageIcon("src/images/7s.jpg");
                    }
                    case 8:
                    {
                        return new ImageIcon("src/images/8s.jpg");
                    }
                    case 9:
                    {
                        return new ImageIcon("src/images/9s.jpg");
                    }
                    case 10:
                    {
                        return new ImageIcon("src/images/10s.jpg");
                    }
                    case 11:
                    {
                        return new ImageIcon("src/images/jacks.jpg");
                    }
                    case 12:
                    {
                        return new ImageIcon("src/images/queens.jpg");
                    }
                    case 13:
                    {
                        return new ImageIcon("src/images/kings.jpg");
                    }
                }

            }
            default:
            {
                return new ImageIcon("src/images/joker.jpg");

            }
        }
    }

    /**
     * Metoda toString,
     * @return "suit" dhe "rank" në form stringu
     */
    public String toString()
    {
        return faceNameToString()+ " of " +suitToString();
    }

    /**
     * Metoda greaterThan,
     * @return një vlerë boolean, varësisht nëse "rank" i një karte është më i madh se "rank" i kartës tjetër
     */
    public boolean greaterThan(Card otherCard)
    {
        //Deklarimi i variablave
        boolean status;

        if ( faceName > otherCard.faceName )
        {
            status = true;
        }
        else
        {
            status = false;
        }

        return status;

    }

    /**
     * Metoda equal,
     * @return një vlerë boolean, varësisht nëse "rank" i kartave është i barabart
     */
    public boolean equals(Card otherCard)
    {
        //Deklarimi i variablave
        boolean status;
        if ( this.faceName == otherCard.faceName )
        {
            status = true;
        }
        else
        {
            status = false;
        }
        return status;
    }


}