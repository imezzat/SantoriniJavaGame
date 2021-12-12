//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eg.edu.guc.santorini.gui;

import eg.edu.guc.santorini.adapter.Adapter;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener, MouseListener {

  public static final Color PossiblePlacementColor = Color.magenta;
  private static final Color PossibleMovesColor = Color.CYAN;
  private static int pType1;
  private static int pType2;
  private static Piece piece;
  private static String s1;
  private static String s2;
  private final Tile[][] labels;
  private Tile tempLabel;
  private Tile tempLabel2;
  private JPanel gridPanel;
  private JPanel buttonPanel;
  private Adapter adapter;
  private JTextField jt1;
  private JTextField jt2;
  private JLabel l1;
  private JLabel l2;

  public Window() {
    this.setTitle("Santorini");
    this.setSize(1000, 600);
    this.setLocation(100, 75);
    Container content = this.getContentPane();
    content.setBackground(Color.blue);
    content.setLayout(new GridLayout(1, 10));
    this.labels = new Tile[5][5];
    this.createPanels2();
    this.createButtons2();
    this.setVisible(true);
  }

  public Window(int rows, int columns) {
    this.setTitle("Santorini");
    this.setSize(1200, 700);
    this.setLocation(100, 30);
    Container content = this.getContentPane();
    content.setBackground(Color.blue);
    content.setLayout(new BorderLayout());
    this.labels = new Tile[rows][columns];
    this.createPanels(rows, columns);
    this.createGrid(rows, columns);
    this.createButtons();
    this.setDefaultCloseOperation(3);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new Window();
  }

  public static Piece getPiece() {
    return piece;
  }

  public static void setPiece(Piece piece) {
    Window.piece = piece;
  }

  public static String getS1() {
    return s1;
  }

  public static void setS1(String s1) {
    Window.s1 = s1;
  }

  public static String getS2() {
    return s2;
  }

  public static void setS2(String s2) {
    Window.s2 = s2;
  }

  public static int getpType1() {
    return pType1;
  }

  public static void setpType1(int pType1) {
    Window.pType1 = pType1;
  }

  public static int getpType2() {
    return pType2;
  }

  public static void setpType2(int pType2) {
    Window.pType2 = pType2;
  }

  public void createPanels(int row, int column) {
    this.gridPanel = new JPanel(new GridLayout(row, column));
    this.gridPanel.setBackground(Color.LIGHT_GRAY);
    this.add(this.gridPanel, "Center");
    this.buttonPanel = new JPanel(new GridLayout(10, 1));
    this.buttonPanel.setBackground(Color.LIGHT_GRAY);
    this.add(this.buttonPanel, "East");
  }

  public void createPanels2() {
    this.buttonPanel = new JPanel(new GridLayout(15, 1));
    this.buttonPanel.setBackground(Color.LIGHT_GRAY);
    this.add(this.buttonPanel, "Center");
  }

  public void createGrid(int gridRows, int gridColumns) {
    Adapter a = new Adapter();
    this.setAdapter(a);

    for (int i = 0; i < this.labels.length; ++i) {
      for (int j = 0; j < this.labels.length; ++j) {
        if ((i != 0 || j != 0) && (i != 4 || j != 1) && (i != 0 || j != 3) && (i != 4 || j != 4)) {
          this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0.png"));
          this.labels[i][j].setL(new Location(i, j));
          this.labels[i][j].addMouseListener(this);
          this.gridPanel.add(this.labels[i][j]);
        } else {
          if (i == 0 && j == 0 && getpType1() == 1) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0c.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP1().getT1());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 0 && j == 0 && getpType1() == 2) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0p.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP1().getT1());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 4 && j == 1 && getpType1() == 1) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0c.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP1().getT2());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 4 && j == 1 && getpType1() == 2) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0p.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP1().getT2());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 0 && j == 3 && getpType2() == 1) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0cc.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP2().getT1());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 0 && j == 3 && getpType2() == 2) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0pp.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP2().getT1());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 4 && j == 4 && getpType2() == 1) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0cc.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP2().getT2());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }

          if (i == 4 && j == 4 && getpType2() == 2) {
            this.labels[i][j] = new Tile(new ImageIcon("Images/Layer0pp.png"));
            this.labels[i][j].setL(new Location(i, j));
            this.labels[i][j].setP(a.getP2().getT2());
            this.labels[i][j].addMouseListener(this);
            this.gridPanel.add(this.labels[i][j]);
          }
        }
      }
    }

  }

  public void createButtons() {
    this.l1 = new JLabel("      " + s1 + "      ");
    this.buttonPanel.add(this.l1);
    this.l2 = new JLabel("      " + s2 + "      ");
    this.buttonPanel.add(this.l2);
    this.l1.setBorder(BorderFactory.createLineBorder(Color.red));
    this.buttonPanel.add(this.l2);
  }

  public void createButtons2() {
    JLabel myLabel1 = new JLabel("Player 1 : ");
    this.buttonPanel.add(myLabel1);
    this.jt1 = new JTextField();
    this.jt1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Window.s1 = Window.this.jt1.getText();
        Window.this.add(new JLabel(Window.s1));
      }
    });
    this.buttonPanel.add(this.jt1);
    JLabel gap = new JLabel("         ");
    this.buttonPanel.add(gap);
    JLabel myLabel = new JLabel("Please choose your piece");
    this.buttonPanel.add(myLabel);
    this.buttonPanel.add(gap);
    JButton button1 = new JButton("Cube");
    button1.setActionCommand("Cube1");
    this.buttonPanel.add(button1);
    button1.setOpaque(false);
    button1.setFocusPainted(false);
    button1.setBackground(new Color(0, 0, 0, 0));
    button1.addActionListener(this);
    this.buttonPanel.add(gap);
    JButton button2 = new JButton("Pyramid");
    button2.setActionCommand("Pyramid1");
    this.buttonPanel.add(button2);
    button2.setOpaque(false);
    button2.setFocusPainted(false);
    button2.setBackground(new Color(0, 0, 0, 0));
    button2.addActionListener(this);
    this.buttonPanel.add(gap);
    JLabel myLabel2 = new JLabel("Player 2 : ");
    this.buttonPanel.add(myLabel2);
    this.jt2 = new JTextField();
    this.jt2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Window.s2 = Window.this.jt2.getText();
        Window.this.add(new JLabel(Window.s2));
      }
    });
    this.buttonPanel.add(this.jt2);
    JLabel myLabel3 = new JLabel("Please choose your piece");
    this.buttonPanel.add(myLabel3);
    this.buttonPanel.add(gap);
    JButton button3 = new JButton("Cube");
    button3.setActionCommand("Cube2");
    this.buttonPanel.add(button3);
    button3.setOpaque(false);
    button3.setFocusPainted(false);
    button3.setBackground(new Color(0, 0, 0, 0));
    button3.addActionListener(this);
    JButton button4 = new JButton("Pyramid");
    button4.setActionCommand("Pyramid2");
    this.buttonPanel.add(button4);
    button4.setOpaque(false);
    button4.setFocusPainted(false);
    button4.setBackground(new Color(0, 0, 0, 0));
    button4.addActionListener(this);
    this.buttonPanel.add(gap);
    JButton button5 = new JButton("Start");
    button5.setActionCommand("Start");
    this.buttonPanel.add(button5);
    button5.setOpaque(false);
    button5.setFocusPainted(false);
    button5.setBackground(new Color(0, 0, 0, 0));
    button5.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Cube1")) {
      setpType1(1);
    } else if (e.getActionCommand().equals("Pyramid1")) {
      setpType1(2);
    }

    if (e.getActionCommand().equals("Cube2")) {
      setpType2(1);
    } else if (e.getActionCommand().equals("Pyramid2")) {
      setpType2(2);
    }

    if (e.getActionCommand().equals("Start") && s1 != null && s2 != null) {
      new Window(5, 5);
    }

  }

  public void mouseClicked(MouseEvent e) {
    Tile tempLabel = (Tile) e.getSource();

//    clear_borders();

    /**
     *  tile has piece and it's a piece of the current player's turn
     */
    if (tempLabel.getP() != null && (this.getAdapter().getB().getTurn().getT1() == tempLabel.getP()
        || this.getAdapter().getB().getTurn().getT2() == tempLabel.getP())
        && !this.getAdapter().getB().getTurn().getPieces().stream().anyMatch(x -> x.hasJustMoved())
    ) {
      clear_borders();
      setPiece(tempLabel.getP());
      ArrayList<Location> l = getPossibleMoves(tempLabel);
      highlightPossibleMoves(l);
      /**
       * Highlight Possible Movements
       */

    }

    /**
     *    Highlights possible placements for The Piece that has Just moved.
     */
    else if (piece.hasJustMoved() && this.getAdapter().getB().canPlace(piece, tempLabel.getL())) {
      try {
        clear_borders();
        this.getAdapter().getB().place(piece, tempLabel.getL());
        this.labels[tempLabel.getL().getY()][tempLabel.getL().getX()].setLayer(
            this.labels[tempLabel.getL().getY()][tempLabel.getL().getX()].getLayer() + 1);

        /**
         *  checking if stack height reached 4 and then disable if so
         */
        if (this.labels[tempLabel.getL().getY()][tempLabel.getL().getX()].getLayer() == 4) {
          disable_level_4_tile();
        }

        /**
         *  Update Image to view new Stack size
         */
        else {
          this.labels[tempLabel.getL().getY()][tempLabel.getL().getX()].setIcon(new ImageIcon(
              "Images/Layer" + this.labels[tempLabel.getL().getY()][tempLabel.getL()
                  .getX()].getLayer() + ".png"));
        }

        highlight_current_player_turn();

//        clear_borders();
      } catch (InvalidPlacementException var8) {
        var8.printStackTrace();
      }
    } else if (this.getAdapter().getB().canMove(piece, tempLabel.getL()) && (
        this.getAdapter().getB().getTurn().getT1() == piece
            || this.getAdapter().getB().getTurn().getT2() == piece) && !piece.hasJustMoved()
        && !this.getAdapter().getB().getOtherPiece(piece).hasJustMoved() && !this.getAdapter()
        .getB().isGameOver()) {
      try {
        clear_borders();
        char c = 'p';
        if (piece instanceof Cube) {
          c = 'c';
        }
        String s = "";
        if (this.getAdapter().getB().getP2().getT1() == piece
            || this.getAdapter().getB().getP2().getT2() == piece) {
          if (this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation()
              .getX()].getP() instanceof Cube) {
            s = "c";
          } else if (this.getAdapter().getB().getP2().getT1() == piece
              || this.getAdapter().getB().getP2().getT2() == piece) {
            s = "p";
          }
        }

        this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].setIcon(
            new ImageIcon("Images/Layer" + this.labels[piece.getCurrentLocation()
                .getY()][piece.getCurrentLocation().getX()].getLayer() + ".png"));
        this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].setP(
            null);
        this.getAdapter().getB().move(piece, tempLabel.getL());
        this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].setIcon(
            new ImageIcon("Images/Layer" + this.labels[piece.getCurrentLocation()
                .getY()][piece.getCurrentLocation().getX()].getLayer() + c + s + ".png"));
        this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].setP(
            piece);

        if (this.getAdapter().getB().isGameOver()) {
//          clear_borders();
          gameOver();
        }

        ArrayList<Location> l = this.getAdapter().possiblePlacements(
            this.labels[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()]);

        for (int i = 0; i < l.size(); ++i) {
          if (this.getAdapter().getB().canPlace(piece, l.get(i))) {
            this.labels[l.get(i).getY()][l.get(i).getX()].setBorder(
                BorderFactory.createLineBorder(PossiblePlacementColor, 1));
          }
        }
      } catch (InvalidMoveException var9) {
        var9.printStackTrace();
      }
    }

  }

  /**
   * Highlights the current player's name whose turn it is to play on the right-hand side
   */
  private void highlight_current_player_turn() {
    if (this.getAdapter().getB().getTurn() == this.getAdapter().getB().getP1()) {
      this.l1.setBorder(BorderFactory.createLineBorder(Color.red));
      this.l2.setBorder(BorderFactory.createEmptyBorder());
    } else {
      this.l2.setBorder(BorderFactory.createLineBorder(Color.red));
      this.l1.setBorder(BorderFactory.createEmptyBorder());
    }
  }

  private void gameOver() {
    JFrame w = new JFrame("GAME OVER!!!!!");
    JLabel j = new JLabel(
        String.format("                              %s WON!!!!!!!!",
            this.getAdapter().getB().getWinner().getName().toUpperCase()
        ));
    w.setSize(400, 200);
    w.setLocation(200, 100);
    Container content = w.getContentPane();
    content.setBackground(Color.LIGHT_GRAY);
    content.setLayout(new BorderLayout());
    w.add(j, "Center");
    w.setVisible(true);
  }

  private void disable_level_4_tile() {

    this.labels[tempLabel.getL().getY()][tempLabel.getL().getX()].setEnabled(false);
  }

  private void highlightPossibleMoves(ArrayList<Location> l) {
    for (int i = 0; i < l.size(); ++i) {
      if (this.getAdapter().getB().canMove(piece, l.get(i))) {
        this.labels[(l.get(i)).getY()][(l.get(i)).getX()].setBorder(
            BorderFactory.createLineBorder(PossibleMovesColor));
      }
    }
  }

  /**
   * gets Possible moves using the clicked tile
   *
   * @param tempLabel
   * @return
   */
  private ArrayList<Location> getPossibleMoves(Tile tempLabel) {
    return tempLabel.getP().possibleMoves();
  }

  private void clear_borders() {
    for (int i = 0; i < this.labels.length; i++) {
      for (int j = 0; j < this.labels.length; j++) {
        this.labels[i][j]
//            .setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            .setBorder(BorderFactory.createEmptyBorder());

      }
    }
  }

  public void mouseEntered(MouseEvent arg0) {
  }

  public void mouseExited(MouseEvent arg0) {
  }

  public void mousePressed(MouseEvent e) {
    this.tempLabel = (Tile) e.getSource();
//    this.tempLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN));
  }

  public void mouseReleased(MouseEvent arg0) {
//    clear_borders();
//    this.tempLabel.setBorder(BorderFactory.createEmptyBorder());
  }

  public Tile getTempLabel2() {
    return this.tempLabel2;
  }

  public void setTempLabel2(Tile tempLabel2) {
    this.tempLabel2 = tempLabel2;
  }

  public Adapter getAdapter() {
    return this.adapter;
  }

  public void setAdapter(Adapter adapter) {
    this.adapter = adapter;
  }
}
