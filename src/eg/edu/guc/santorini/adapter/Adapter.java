//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eg.edu.guc.santorini.adapter;

import eg.edu.guc.santorini.Board;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.gui.Tile;
import eg.edu.guc.santorini.gui.Window;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Adapter {

  private Board b;
  private Player p1 = new Player(Window.getS1(), Window.getpType1());
  private Player p2 = new Player(Window.getS2(), Window.getpType2());

  public Adapter() {
    Board b = new Board(this.p1, this.p2);
    this.setB(b);
  }

  public static void main(String[] args) {
    new Adapter();
  }

  public boolean canMove(Piece piece, Location newLocation) {
    return this.canMove(piece, newLocation) && !piece.hasJustMoved() && (
        this.getB().getTurn().getT1().equals(piece) || this.getB().getTurn().getT2()
            .equals(piece)) && !this.getB().getOtherPiece(piece).hasJustMoved() && !this.getB()
        .isGameOver();
  }

  public ArrayList<Location> possiblePlacements(Tile t) {
//        ArrayList<Location> l = new ArrayList();
      if (this.b.getP1().getT1().equals(t.getP())) {
          return this.b.getP1().getT1().possiblePlacements();
      }

      if (this.b.getP1().getT2().equals(t.getP())) {
          return this.b.getP1().getT2().possiblePlacements();
      }

      if (this.b.getP2().getT1().equals(t.getP())) {
          return this.b.getP2().getT1().possiblePlacements();
      }

      if (this.b.getP2().getT2().equals(t.getP())) {
          return this.b.getP2().getT2().possiblePlacements();
      }
    return null;
  }

  public void move(Piece piece, Tile t) throws InvalidMoveException {
    this.getB().move(piece, t.getL());
    new Tile(new ImageIcon("Hammer.png"));
  }

  public Board getB() {
    return this.b;
  }

  public void setB(Board b) {
    this.b = b;
  }

  public Player getP1() {
    return this.p1;
  }

  public void setP1(Player p1) {
    this.p1 = p1;
  }

  public Player getP2() {
    return this.p2;
  }

  public void setP2(Player p2) {
    this.p2 = p2;
  }
}
