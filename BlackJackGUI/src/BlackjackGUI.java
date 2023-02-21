//Adam Thomson
//BlackjackGUI

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class BlackjackGUI {
    private JPanel Background;
    private JPanel Welcome;
    private JPanel Age;
    private JPanel eligibleAge;
    private JPanel Name;
    private JButton continueBtnWelcome;
    private JButton nextBtnAge;
    private JButton backBtnAge;
    private JLabel ageLbl;
    private JTextArea welcomeTxt;
    private JTextField ageTxtField;
    private JButton backBtnEligible;
    private JButton nextBtnEligible;
    private JButton okBtnIneligible;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane eligibleAgeTextPane;
    private JTextPane nameTxtPane;
    private JButton nextBtnName;
    private JTextField nameTxtField;
    private JTextPane textPane4;
    private JTextPane textPane5;
    private JTextPane textPane6;
    private JButton backBtnName;
    private JPanel welcomeName;
    private JTextPane welcomeNameTxtPane;
    private JButton playBtnWelcName;
    private JButton backBtnWelcName;
    private JPanel Blackjack;
    private JTextArea blackjackTxtArea;
    private JButton startBtn;
    private JTextPane textPane7;
    private JButton clearRecordBtn;
    private JButton exitBtn;
    private JButton hitBtn;
    private JButton standBtn;
    private JButton okBtnWin;
    private JButton okBtnLoss;
    private JTextArea recordTxtArea;
    private JButton okBtnDraw;
    private JButton clearGameBtn;
    private JButton backBtnBlackjack;
    private JTextPane blackjackTitleTxtArea;
    public int total;
    public int dealersTotal;
    public int totalWins = 0;
    public int totalLosses = 0;
    public String name;
    public int totalDraws = 0;
    public int age = 0;


    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }


    //main method
    public static void main(String[] args) {
        // create new jFrame
        JFrame frame = new JFrame("Blackjack");
        // set the jFrame to contain the GUI
        frame.setContentPane(new BlackjackGUI().Background);
        // set exit on close, pack components and make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public BlackjackGUI() {
        //Takes the user onto the Age page when clicked
        continueBtnWelcome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Age panel to the background panel
                Background.removeAll();
                Background.add(Age);
                Background.repaint();
                Background.revalidate();

            }
        });

        //Takes the user back to the Welcome page when clicked
        backBtnAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Welcome panel to the background panel
                Background.removeAll();
                Background.add(Welcome);
                Background.repaint();
                Background.revalidate();
            }
        });
        //Takes the user onto either the eligibleAge or ineligibleAge panel when clicked
        nextBtnAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Asking user to input number

                //Receives the age from the user and checks if it is eligible or ineligible
                try {
                    age = Integer.parseInt(ageTxtField.getText());
                    // Checks to see if the age input is >= 18 and sends them to the eligible age window
                    if (age >= 18) {
                        //Clears the background panel of everything and then adds eligibleAge panel to the background panel
                        Background.removeAll();
                        Background.add(eligibleAge);
                        Background.repaint();
                        Background.revalidate();
                    }
                    // Checks to see if the age input is <= 17 and sends them to the ineligible age window
                    else if (age <= 17) {
                        //Ineligible age warning popup telling the user they must be older than 18 to continue
                        BlackjackGUI.infoBox("Hello, you must be 18 or older to play!", "INELIGIBLE AGE");


                    }
                    //If the input is anything other than an integer it will give a invalid input warning
                } catch (NumberFormatException d) {
                    JOptionPane.showMessageDialog(null, "INVALID INPUT!\nPlease enter a number.", "INVALID INPUT", JOptionPane.WARNING_MESSAGE);
                }

            }


        });
        //Takes the user onto the Name page when clicked
        nextBtnEligible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Name panel to the background panel
                Background.removeAll();
                Background.add(Name);
                Background.repaint();
                Background.revalidate();

            }
        });
        //Takes the user back to the Name page when clicked
        backBtnEligible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Age panel to the background panel
                Background.removeAll();
                Background.add(Age);
                Background.repaint();
                Background.revalidate();

            }
        });


        //Takes the user onto the welcome name page when clicked
        nextBtnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Asks the user to input name

                name = (nameTxtField.getText());
                //If name text field is empty then the next button is disabled
                if (nameTxtField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter your name");
                    //nextBtnName.setEnabled(false);
                }else {
                    nextBtnName.setEnabled(true);
                    //Clears the background panel of everything and then adds welcomeName panel to the background panel
                    Background.removeAll();
                    Background.add(welcomeName);
                    Background.repaint();
                    Background.revalidate();

                    //When the next button is pressed, it will move onto the welcomeName window a welcome message will display, welcoming them with the name they provided
                    welcomeNameTxtPane.setText("Hello " + name + ", welcome to Blackjack! Would you like to get started or go back and edit your information provided?");
                }
            }
        });
        //Takes the user back to the eligible age page when clicked
        backBtnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds eligibleAge panel to the background panel
                Background.removeAll();
                Background.add(eligibleAge);
                Background.repaint();
                Background.revalidate();
            }
        });
        //Takes the user onto the blackjack page when clicked
        playBtnWelcName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Blackjack panel to the background panel
                Background.removeAll();
                Background.add(Blackjack);
                Background.repaint();
                Background.revalidate();
            }
        });
        //Takes the user back to the Name page when clicked
        backBtnWelcName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds Name panel to the background panel
                Background.removeAll();
                Background.add(Name);
                Background.repaint();
                Background.revalidate();
            }
        });
        //Starts the round
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initialises rand to allow it to apply random numbers
                Random rand = new Random();

                //Enables the hit and stand button and disables the start button
                hitBtn.setEnabled(true);
                standBtn.setEnabled(true);
                startBtn.setEnabled(false);

                //Array to generate random number
                int[] randomNumArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
                int randomIndex = rand.nextInt(randomNumArray.length);
                int random1 = randomNumArray[randomIndex];

                //Generates a random number between 1 and 11
                int random2 = rand.nextInt(11);
                random2 += 1;

                //Calculating total, displaying first random number, second random number and total and updating the win/loss/draw record
                total = random1 + random2;
                blackjackTxtArea.setText(random1 + " is your first number.\n" + random2 + " is your second number.\n" + total + " is your total \n");
                recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);

                //Applies the Ace rule
                if (random1 == 11 && total > 21) {
                    random1 = 1;
                    total = total - 11 + random1;
                    blackjackTxtArea.append("As there was an ace, 11 became " + random1 + ". " + random2 + " is your second number\n" + total + " is your new total.\n" );
                } else if (random1 == 1 && total < 11) {
                    random1 = 11;
                    total = total - 1 + random1;
                    blackjackTxtArea.append("As there was an ace, 1 became " + random1 + ". " + random2 + " is your second number\n" + total + " is your new total.\n" );
                } else if (random2 == 11 && total > 21) {
                    random2 = 1;
                    total = total - 11 + random2;
                    blackjackTxtArea.append(random1 + " is your first number. As there was an ace, 11 became " + random2 + ".\n" + total + " is your new total.\n" );
                } else if (random2 == 1 && total < 11){
                    random2 = 11;
                    total = total - 1 + random2;
                    blackjackTxtArea.append(random1 + " is your first number. As there was an ace, 1 became " + random2 + ".\n" + total + " is your new total.\n" );
                }

                //Asks the user if they would like to stand or hit if their total < 21
                if (total < 21) {
                    blackjackTxtArea.append("Would you like to hit or stand? \n");
                }


                //generating 2 random numbers between 1 and 11 and assigning it to the variable dealersNum
                int dealersNum = rand.nextInt(11);
                dealersNum += 1;
                int dealersNum1 = rand.nextInt(11);
                dealersNum1 += 1;
                dealersTotal = dealersNum1 + dealersNum;

                //Checking to see if the dealers total is <= 13 and adding another random number between 1 and 11 if it is <= 13
                if (dealersTotal <= 13) {
                    int dealersNum2 = rand.nextInt(11);
                    dealersNum2 += 1;
                    dealersTotal = dealersTotal + dealersNum2;
                }

                // Checks if the total is > 21 to find out if the user has loss
                if (total > 21) {
                    //Enables start button and disables the hit and stand button
                    startBtn.setEnabled(true);
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);

                    //Popup message saying the user has lost
                    BlackjackGUI.infoBox("Unfortunately, you have lost the game!", "LOSS");

                    //Displays dealers total and adds one to totalLosses and updates the win/loss/draw record.
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    totalLosses = totalLosses + 1;
                    recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("You have lost!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue, please\nclear your wins, draws and losses and exit the program.\n");
                }
                // Checks if the total = 21 to find out if the user has won
                else if (total == 21) {
                    //Disables stand and hit button and enables hit button
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);
                    startBtn.setEnabled(true);

                    //Popup message saying the user has won
                    BlackjackGUI.infoBox("Congratulations, you have won the game!", "WINNER");

                    //Adds 1 to the totalWins updates the win/loss/draw record and displays the dealers total
                    totalWins = totalWins + 1;
                    recordTxtArea.setText(name + "'s record\n Wins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    blackjackTxtArea.append("Congratulations, you have won!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue please\nclear your wins, draws and losses and exit the program.\n");
                }
            }


        });
        //Adds new random number
        hitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Initialises rand
                Random rand = new Random();

                //Generates random number between 1 and 11 and adds it to the total and updates the total
                int random = rand.nextInt(11);
                random += 1;
                total = total + random;
                blackjackTxtArea.append(random + " is your new number. \n" + total + " is your new total.\n");


                int randomAce = 1 | 11;
                if (random == 11 || random == 0) {
                    randomAce = random;
                }

                //Applies the Ace rule
                if (random == 11 && total > 21) {
                    random = 1;
                    total = total - 11 + random;
                    blackjackTxtArea.append("As there was an ace, 11 became " + random + ".\n" + total + " is your new total.\n" );
                } else if (random == 1 && total < 11) {
                    random = 11;
                    total = total - 1 + random;
                    blackjackTxtArea.append("As there was an ace, 11 became " + random + ".\n" + total + " is your new total.\n" );
                } else if (randomAce == 11 && total > 21){
                    randomAce = 1;
                    total = total - 11 + randomAce;
                    blackjackTxtArea.append("As there was an ace, 11 became " + randomAce + ".\n" + total + " is your new total.\n" );
                } else if (randomAce == 1 && total < 11){
                    randomAce = 11;
                    total = total - 1 + randomAce
                }


                    //Asks the user if they would like to stand or hit if their total < 21
                    if (total < 21) {
                        blackjackTxtArea.append("Would you like to hit or stand? \n");
                    }

                // Checks if the total = 21 to find out if the user has won
                if (total == 21) {
                    //Disables stand and hit button and enables hit button
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);
                    startBtn.setEnabled(true);

                    //Popup message saying the user has won
                    BlackjackGUI.infoBox("Congratulations, you have won the game!", "WINNER");

                    //Adds 1 to the totalWins updates the win/loss/draw record and displays the dealers total
                    totalWins = totalWins + 1;
                    recordTxtArea.setText(name + "'s record\n Wins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    blackjackTxtArea.append("Congratulations, you have won!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue please\nclear your wins, draws and losses and exit the program.\n");
                }
                // Checks if the total > 21 to find out if the user has lost
                else if (total > 21) {
                    //Enables start button and disables the hit and stand button
                    startBtn.setEnabled(true);
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);

                    //Popup message saying the user has lost
                    BlackjackGUI.infoBox("Unfortunately, you have lost the game!", "LOSS");

                    //Displays dealers total and adds one to totalLosses and updates the win/loss/draw record.
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    totalLosses = totalLosses + 1;
                    recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("You have lost!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue, please\nclear your wins, draws and losses and exit the program.\n");
                }


            }
        });
        //Locks the total when pressed and compares it to the dealers total
        standBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checks if the dealersTotal > 21 to find out if the user has won
                if (dealersTotal > 21) {
                    //Disables stand and hit button and enables hit button
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);
                    startBtn.setEnabled(true);

                    //Popup message saying the user has won
                    BlackjackGUI.infoBox("Congratulations, you have won the game!", "WINNER");

                    //Adds 1 to the totalWins updates the win/loss/draw record and displays the dealers total
                    totalWins = totalWins + 1;
                    recordTxtArea.setText(name + "'s record\n Wins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    blackjackTxtArea.append("Congratulations, you have won!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue please\nclear your wins, draws and losses and exit the program.\n");
                }
                // Checks if the dealersTotal = 21 to find out if the user has lost
                else if (dealersTotal == 21) {
                    //Enables start button and disables the hit and stand button
                    startBtn.setEnabled(true);
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);

                    //Popup message saying the user has lost
                    BlackjackGUI.infoBox("Unfortunately, you have lost the game!", "LOSS");

                    //Displays dealers total and adds one to totalLosses and updates the win/loss/draw record.
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    totalLosses = totalLosses + 1;
                    recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("You have lost!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue, please\nclear your wins, draws and losses and exit the program.\n");
                }
                //If statement to check if the total and dealersTotal are equal, if true then it adds the Draw jpanel to the parent panel
                else if (dealersTotal == total && dealersTotal < 21) {
                    //Disables the hit and stand button
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);
                    startBtn.setEnabled(true);

                    //Popup message saying the user has tied the game
                    BlackjackGUI.infoBox("You have tied the game!", "DRAW");


                    //Adds 1 to totalDraws, updates the win/loss/draw record and displays the dealers total
                    totalDraws = totalDraws + 1;
                    recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    blackjackTxtArea.append("You have drawn the game!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue please\nclear your wins, draws and losses and exit the program.\n");
                }
                // Checks if the total < dealersTotal whilst the dealersTotal < 21 to find out if the user has lost
                else if (total < dealersTotal && dealersTotal < 21) {
                    //Enables start button and disables the hit and stand button
                    startBtn.setEnabled(true);
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);

                    //Popup message saying the user has lost
                    BlackjackGUI.infoBox("Unfortunately, you have lost the game!", "LOSS");

                    //Displays dealers total and adds one to totalLosses and updates the win/loss/draw record.
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    totalLosses = totalLosses + 1;
                    recordTxtArea.setText(name + "'s records\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("You have lost!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue, please\nclear your wins, draws and losses and exit the program.\n");
                }
                // Checks if the total > dealersTotal whilst total < 21 to find out if the user has won
                else if (total > dealersTotal && total < 21) {
                    //Disables stand and hit button and enables hit button
                    hitBtn.setEnabled(false);
                    standBtn.setEnabled(false);
                    startBtn.setEnabled(true);

                    //Popup message saying the user has won
                    BlackjackGUI.infoBox("Congratulations, you have won the game!", "WINNER");

                    //Adds 1 to the totalWins updates the win/loss/draw record and displays the dealers total
                    totalWins = totalWins + 1;
                    recordTxtArea.setText(name + "'s record\n Wins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
                    blackjackTxtArea.append("The dealers total is " + dealersTotal + "\n");
                    blackjackTxtArea.append("Congratulations, you have won!\nPlease press start to begin a new round if you\nwant to continue.\nIf you do not want to continue please\nclear your wins, draws and losses and exit the program.\n");
                }
            }
        });
        //Clears the users win loss record for that session when clicked
        clearRecordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Resets the totalWins, totalLosses and totalDraws to 0 and displays them
                totalWins = 0;
                totalLosses = 0;
                totalDraws = 0;
                recordTxtArea.setText(name + "'s record\nWins: " + totalWins + "\nLoss: " + totalLosses + "\nDraws: " + totalDraws);
            }
        });
        //Closes the application down when clicked
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Clears the previous rounds totals when clicked
        clearGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blackjackTxtArea.setText("");
                //Enables start button and disables stand and hit button
                startBtn.setEnabled(true);
                hitBtn.setEnabled(false);
                standBtn.setEnabled(false);

            }
        });
        //Takes the user back to the welcome page when clicked
        backBtnBlackjack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears the background panel of everything and then adds welcomeName panel to the background panel
                Background.removeAll();
                Background.add(welcomeName);
                Background.repaint();
                Background.revalidate();
            }
        });

    }


}


