/**
 * Klasa WarGameGUI e bën ndërfaqen grafike me qëllim të luajtjes së lojës WAR ndërmjet userit dhe kompjuterit
 * Useri klikon tek butoni "Flip Card" për ti'a filluar lojës. Ky buton bëhet "disable" kur loja mbaron.
 * Qdo kartë e kthyer shfaqë një kartë tjetër nda "deck" i cili ishte ndarë ndërmjet userit dhe kompjuterit.
 * Kartat krahasohen ndërmjetvete dhe karta me vlerë më të madhe fiton.
 * Nëse vlera e kartave është e barabart, lojtarët marrin 2 karta të tjera nga "pile" i tyre dhe njëren nga ato e kthejnë,
 * fituesi i merr të gjitha kartat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGameGUI extends JFrame{
    //Deklarimi i variablave
    private JPanel gameContainer, leftTop, rightTop, leftBottom,
            rightBottom, buttonBar, cardBar, winnerBar;

    private JButton flipButton, restartButton, exitButton;   //Butonat

    /*
     * ImageIcon,
     * userBack dhe compBack mbajnë imazhet (statike) të pjesës së prapme të kartës
     * userFront dhe compFront ndrrojnë pas qdo "flip" të kartave
     */
    private ImageIcon userFront, userBack, compFront, compBack;

    /*
     * JLabels përmbajnë në vete imazhet e caktuara
     * warBack1 dhe warBack2 përdoren për shfaqjen e pjesës së prapme të kartës së dytë (gjat WAR)
     */
    private JLabel userPicBack, userPicFront, compPicBack, compPicFront, warBack1, warBack2;

    /*
     * JLabels për të shfaqur:
     * I kujt është "deck" (userCards dhe numCards)
     * Numrin e kartave që i kan mbetur lojtarëve (userNum dhe compNum)
     * Fituesin e qfo roundi dhe fituesin e lojës (winnerLabel)
     */
    private JLabel userCards, compCards, userNum, compNum, winnerLabel;

    /*
     * Objekti WarGame,
     * instancon lojë të re War
     */
    private WarGame war;

    public WarGameGUI()
    {
        //Titulli
        super("Game of War");
        war = new WarGame();

        setLayout(new BorderLayout());

        createPanels();
        createPanelLabels();
        createButtons();
        createImageIcons();
        addPanelsToFrames();
        addToMainFrame();

    }


    /**
     * Klasa createPanels krijon panelët
     */
    private void createPanels()
    {
        //krijimi i një "rrjete" për vendosjen e kartave
        gameContainer = new JPanel(new GridLayout(2,2));
        gameContainer.setMaximumSize(new Dimension(450,550));

        //krijimi i 4 paneleve
        leftTop = new JPanel(new FlowLayout());
        leftTop.setMaximumSize(new Dimension(200, 225));

        rightTop = new JPanel(new FlowLayout());
        rightTop.setMaximumSize(new Dimension(250, 225));

        leftBottom = new JPanel(new FlowLayout());
        leftBottom.setMaximumSize(new Dimension(200, 225));

        rightBottom = new JPanel(new FlowLayout());
        rightBottom.setMaximumSize(new Dimension(250, 225));

        //krijimi i panelit (shiritit) që shfaq fituesin
        winnerBar = new JPanel(new FlowLayout());
        winnerBar.setMinimumSize(new Dimension(300,200));

        //krijimi i panelit (shiritit) të letrave
        cardBar = new JPanel(new GridLayout(4,1));
        cardBar.setBackground(new Color(250,250,250));
        cardBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardBar.setAlignmentY(Component.CENTER_ALIGNMENT);
        cardBar.setSize(200,300);

        //krijimi i panelit për vendosjen e butonave
        buttonBar = new JPanel(new FlowLayout());
        buttonBar.setMinimumSize(new Dimension(900,200));

        //vendosja e kufinjëve (borders)
        winnerBar.setBorder(BorderFactory.createLoweredBevelBorder());
        cardBar.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 2, Color.black));
        leftTop.setBorder(BorderFactory.createLoweredBevelBorder());
        rightTop.setBorder(BorderFactory.createLoweredBevelBorder());
        leftBottom.setBorder(BorderFactory.createLoweredBevelBorder());
        rightBottom.setBorder(BorderFactory.createLoweredBevelBorder());

        //rreshtimi i tekstit
        winnerBar.setAlignmentX(50);
    }

    /**
     * Metoda createPanelLabel krijon "labels" për winnerBar dhe cardBar
     */
    private void createPanelLabels()
    {
        //krijimi i një "label" për shfaqjen se kush i fiton roundet
        winnerLabel = new JLabel();
        winnerLabel.setFont(new Font("Times",Font.BOLD,36));
        winnerLabel.setText("Welcome to War");
        winnerBar.add(winnerLabel);

        //krijimi i "label" për "pile" të kartave
        userCards = new JLabel();
        userCards.setText("User Cards ");
        userCards.setFont(new Font("Times", Font.BOLD, 18));
        userCards.setHorizontalAlignment(SwingConstants.CENTER);
        cardBar.add(userCards);

        userNum = new JLabel();
        userNum.setText(""+war.getUserNumCards());
        userNum.setFont(new Font("Times", Font.BOLD, 40));
        userNum.setForeground(new Color(0,186,161));
        userNum.setHorizontalAlignment(SwingConstants.CENTER);
        userNum.setVerticalAlignment(SwingConstants.TOP);
        cardBar.add(userNum);


        compCards = new JLabel();
        compCards.setText("Computer Cards ");
        compCards.setFont(new Font("Times", Font.BOLD, 18));
        compCards.setHorizontalAlignment(SwingConstants.CENTER);
        cardBar.add(compCards);

        compNum = new JLabel();
        compNum.setText(""+war.getCompNumCards());
        compNum.setFont(new Font("Times", Font.BOLD, 40));
        compNum.setForeground(new Color(216,88,118));
        compNum.setHorizontalAlignment(SwingConstants.CENTER);
        compNum.setVerticalAlignment(SwingConstants.TOP);
        cardBar.add(compNum);


    }

    /**
     * Metoda createButtons i krijon dhe aktivizon butonat e panelit buttonBar
     */
    private void createButtons()
    {
        //krijimi i butoni "Flip" (për userin)
        flipButton = new JButton("Flip Card");
        flipButton.setForeground(new Color(42,125,220));
        flipButton.setFont(new Font("Times",Font.BOLD,18));
        flipButton.addActionListener(new ButtonListener());
        buttonBar.add(flipButton);

        //krijimi i butoni "Restart"
        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Times",Font.BOLD,18));
        restartButton.setForeground(new Color(17,176,59));
        restartButton.addActionListener(new ResetListener());
        buttonBar.add(restartButton);

        //krijimi i butoni "Exit"
        exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(220,60,42));
        exitButton.setFont(new Font("Times",Font.BOLD,18));
        exitButton.addActionListener(new ExitListener());
        buttonBar.add(exitButton);

    }

    /**
     * Metoda createImageIcons,
     * i krijon të gjitha imazhet dhe "labels"
     * i shton "JLabels" në koriza (frames)
     */
    private void createImageIcons()
    {
        //krijimi i imazheve
        userFront = null;
        userBack = new ImageIcon("src/images/back.jpg");
        compFront = null;
        compBack = new ImageIcon ("src/images/back.jpg");

        //krijimi i "labels" për imazhe
        userPicFront = new JLabel();
        compPicFront = new JLabel();

        userPicBack = new JLabel(userBack);
        compPicBack = new JLabel(compBack);

        warBack1 = new JLabel();
        warBack2 = new JLabel();

        //shtimi i imazheve në panele
        leftTop.add(userPicBack);
        leftBottom.add(compPicBack);

        rightTop.add(warBack1);
        rightBottom.add(warBack2);

        rightTop.add(userPicFront);
        rightBottom.add(compPicFront);

    }

    /**
     * Metoda addPanelsToFrames,
     * i shton "subpanels" tek paneli kryesor
     */
    private void addPanelsToFrames()
    {
        //shtimi i të gjitha paneleve tek kornizat përkatëse
        gameContainer.add(leftTop);
        gameContainer.add(rightTop);
        gameContainer.add(leftBottom);
        gameContainer.add(rightBottom);
    }
    /**
     * Metoda addToMainFrame,
     * shtimi i paneleve tek korniza kryesore
     */
    private void addToMainFrame()
    {
        add(gameContainer, BorderLayout.CENTER);
        add(cardBar, BorderLayout.WEST);
        add(buttonBar, BorderLayout.SOUTH);
        add(winnerBar, BorderLayout.NORTH);
    }


    /**
     * Klasa ButtonListener bën implementimin e metodave për qdo "flip" të kartave
     * "flip" i kartave aktivizohet nga flipButton
     */
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (war.gameOver()==false)
            {
                userNum.setText( "" + war.getUserNumCards() );
                compNum.setText( "" + war.getCompNumCards() );

                if (war.getRoundWinner() == -1)
                {
                    warBack1.setIcon(userBack);
                    warBack2.setIcon(compBack);
                }
                else
                {
                    warBack1.setIcon(null);
                    warBack2.setIcon(null);
                }

                //"flip" kartën e rradhës në qdo "pile"
                war.flipCard();

                //ndërrinmi i iimazheve të kartave
                userFront = war.getUserCard().getImage();
                compFront = war.getCompCard().getImage();

                userPicFront.setIcon(userFront);
                compPicFront.setIcon(compFront);

                //krahasimi i kartave me qëllim që të dihet fituesi
                war.compareCards();

                if (war.getRoundWinner() == 1)
                {
                    winnerLabel.setForeground(new Color(0,186,161));
                    winnerLabel.setText("User wins "+war.getWagerSize()+" cards.");

                }
                else if(war.getRoundWinner() == 0)
                {
                    winnerLabel.setForeground(new Color(216,88,118));
                    winnerLabel.setText("Computer wins " + war.getWagerSize() + " cards.");

                }
                else if (war.getRoundWinner() == -1)
                {
                    winnerLabel.setForeground(Color.black);
                    winnerLabel.setText("It's a War!");

                }
            }
            else if(war.gameOver() == true)
            {
                if (war.getRoundWinner() == 1)
                {
                    winnerLabel.setForeground(new Color(0,186,161));
                    winnerLabel.setText("Game over. User Wins!");
                    winnerLabel.setFont(new Font("Times",Font.BOLD, 50));
                    disableFlip();
                }
                else if(war.getRoundWinner() == 0)
                {
                    winnerLabel.setForeground(new Color(216,88,118));
                    winnerLabel.setText("Game over. Computer Wins.");
                    winnerLabel.setFont(new Font("Times",Font.BOLD, 50));
                    disableFlip();
                }
            }
        }
        /**
         * Metoda disableFlip,
         * bën deaktivizimin e butonit "Flip" në momentin
         * kur një lojëtar nuk ka asjnë letër, mbaron loja
         */
        public void disableFlip()
        {

            flipButton.setEnabled(false);
        }
    }


    /**
     * Klasa ExitListener bën implementimin e metodave të lidhura me aktivizimin e butonit "Exit"
     * bën mbylljen e programit
     */
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    /**
     * Klasa ResetListener bën implementimin e metodave për butonin "Restart"
     * fillon një lojë të re kur useri klikon në buton
     */
    private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //krijimi i një loje të re WAR
            war = new WarGame();

            //rivendosja e të gjitha imazheve dhe "labels"
            winnerLabel.setForeground(Color.black);
            winnerLabel.setText("New Game");

            userCards.setText("User Cards ");

            userNum.setText(""+war.getUserNumCards());

            compCards.setText("Computer Cards ");

            compNum.setText(""+war.getCompNumCards());

            //rivendosja e imazheve
            userFront = null;
            compFront = null;

            userPicFront.setIcon(userFront);
            compPicFront.setIcon(compFront);

        }
    }
}
