package terra.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import terra.board.Board;
import terra.player.PlayerAccess;
import terra.round.Round;

public class UserInterface extends JFrame {

    public UserInterface() {

        initWelcomeScreen();
    
    }

    private void initWelcomeScreen() {
        List<JComponent> buttons = new ArrayList<JComponent> ();

        JLabel welcomeLabel = new JLabel("Welcome to Terra Mystica!");
        buttons.add(welcomeLabel);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setMnemonic(KeyEvent.VK_N);
        newGameButton.setPreferredSize(new Dimension(100,30));
        newGameButton.addActionListener((ActionEvent e) -> {initNewGameScreen();});
        buttons.add(newGameButton);
 
        JButton loadGameButton = new JButton("Load Game");
        loadGameButton.setMnemonic(KeyEvent.VK_L);
        newGameButton.setPreferredSize(new Dimension(100,30));
        buttons.add(loadGameButton);

        JButton donateButton = new JButton("Donate");
        donateButton.setMnemonic(KeyEvent.VK_D);
        newGameButton.setPreferredSize(new Dimension(100,30));
        buttons.add(donateButton);

        JButton quitButton = new JButton("Quit");
        quitButton.setMnemonic(KeyEvent.VK_Q);
        quitButton.addActionListener((ActionEvent e) -> {System.exit(0);});
        newGameButton.setPreferredSize(new Dimension(100,30));
        buttons.add(quitButton);
        
        createLayoutWelcome(buttons.toArray(new JComponent[buttons.size()]));

        this.setTitle("Terra Mystica");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 

    }
        
    private void createLayoutWelcome(JComponent... arg) {

        Container panel = getContentPane();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.linkSize(SwingConstants.HORIZONTAL, arg[0], arg[1], arg[2], arg[3], arg[4]);
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );
    }
    
    private void initNewGameScreen() {
        List<JComponent> buttons = new ArrayList<JComponent> ();

        JLabel welcomeLabel = new JLabel("Kindly select the number of players!");
        buttons.add(welcomeLabel);

        JButton button2 = new JButton("2");
        button2.setMnemonic(KeyEvent.VK_2);
        button2.addActionListener((ActionEvent e) -> {initStartGameScreen(2);});
        buttons.add(button2);

        JButton button3 = new JButton("3");
        button3.setMnemonic(KeyEvent.VK_3);
        button3.addActionListener((ActionEvent e) -> {initStartGameScreen(3);});
        buttons.add(button3);

        JButton button4 = new JButton("4");
        button4.setMnemonic(KeyEvent.VK_4);
        button4.addActionListener((ActionEvent e) -> {initStartGameScreen(4);});
        buttons.add(button4);

        JButton button5 = new JButton("5");
        button5.setMnemonic(KeyEvent.VK_5);
        button5.addActionListener((ActionEvent e) -> {initStartGameScreen(5);});
        buttons.add(button5);
        
        createLayoutNewGame(buttons.toArray(new JComponent[buttons.size()]));

    }

    private void createLayoutNewGame(JComponent[] arg) {

        Container panel = getContentPane();
        GroupLayout layout = new GroupLayout(panel);
        panel.removeAll();
        panel.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.linkSize(SwingConstants.HORIZONTAL, arg[0], arg[1], arg[2], arg[3], arg[4]);
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );
        
    }

    private void initStartGameScreen(int numPlayers) {
        List<JComponent> labels = new ArrayList<JComponent> ();

        Board board = Board.getInstance();
        Round round = Round.getInstance();
        PlayerAccess playerAccess = PlayerAccess.getInstance(numPlayers);

       for(int i = 0; i < numPlayers; i++) {
           JLabel label = new JLabel();
           label.setIcon(new ImageIcon(playerAccess.getPlayer().getFactionImage()));
           playerAccess.incrementCurrentPlayer();
           labels.add(label);
       }
       creatLayoutStartGame(labels.toArray(new JComponent[labels.size()]));
    }

    private void creatLayoutStartGame(JComponent[] arg) {
        Container panel = getContentPane();
        GroupLayout layout = new GroupLayout(panel);
        panel.removeAll();
        panel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.linkSize(SwingConstants.HORIZONTAL, arg[0], arg[1], arg[2], arg[3], arg[4]);
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
                );

    }

    private void initUI() {
        
        List<JButton> buttons = new ArrayList<JButton> ();
        JButton transformAndBuildButton = new JButton("Quit");
        transformAndBuildButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        transformAndBuildButton.setMnemonic(KeyEvent.VK_Q);
        transformAndBuildButton.setMinimumSize(new Dimension(100,30));
        buttons.add(transformAndBuildButton);

        ImageIcon saveIcon = new ImageIcon("images/fakirs.png");
        ImageIcon rollIcon = new ImageIcon("images/fakirs_over.png");
        ImageIcon pressIcon = new ImageIcon("images/fakirs_pressed.png");
        ImageIcon disabledIcon = new ImageIcon("images/fakirs_disabled.png");
        JButton saveButton = new JButton();
        saveButton.setBorderPainted(false);
        saveButton.setBorder(null);
        saveButton.setIcon(new ImageIcon("images/fakirs.png"));
        saveButton.setRolloverIcon(rollIcon);
        saveButton.setPressedIcon(pressIcon);
        saveButton.setDisabledIcon(disabledIcon);
        saveButton.addActionListener((ActionEvent e) -> {
            System.out.println("The game is saved.");
        });

        saveButton.setMnemonic(KeyEvent.VK_S);
        saveButton.setMinimumSize(new Dimension(100,30));
        buttons.add(saveButton);

        createLayout(buttons.toArray(new JButton[buttons.size()]));

        setTitle("Terra Mystica");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(false);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1]))

                
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1]))
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            UserInterface ex = new UserInterface();
            ex.setVisible(true);
        });
    }
}