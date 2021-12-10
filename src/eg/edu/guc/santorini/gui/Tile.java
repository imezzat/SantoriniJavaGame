//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eg.edu.guc.santorini.gui;

import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Tile extends JLabel {
    private int layer;
    private Piece p;
    private Location location;

    public Tile() {
    }

    public Tile(Icon ico) {
        super(ico);
        this.layer = 0;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return this.layer;
    }

    public void setP(Piece p) {
        this.p = p;
    }

    public Piece getP() {
        return this.p;
    }

    public void setL(Location l) {
        this.location = l;
    }

    public Location getL() {
        return this.location;
    }
}
