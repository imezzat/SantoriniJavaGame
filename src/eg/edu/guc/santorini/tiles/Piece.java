package eg.edu.guc.santorini.tiles;

import eg.edu.guc.santorini.utilities.Location;
import java.util.ArrayList;

public abstract class Piece implements PieceInterface {

  private Location currentLocation;
  private boolean justMoved = false;

  public Piece() {

  }

  public abstract ArrayList<Location> possibleMoves();

  public ArrayList<Location> possiblePlacements() {
    ArrayList<Location> possiblePlacements = new ArrayList<Location>();
    int y = getCurrentLocation().getY();
    int x = getCurrentLocation().getX();
    if (x > 0) {
      Location l1 = new Location(y, x - 1);
      possiblePlacements.add(l1);
    }
    if (x < 4) {
      Location l2 = new Location(y, x + 1);
      possiblePlacements.add(l2);
    }
    if (y > 0) {
      Location l3 = new Location(y - 1, x);
      possiblePlacements.add(l3);
    }
    if (y < 4) {
      Location l4 = new Location(y + 1, x);
      possiblePlacements.add(l4);
    }
    if (y < 4 && x > 0) {
      Location l5 = new Location(y + 1, x - 1);
      possiblePlacements.add(l5);
    }
    if (y < 4 && x < 4) {
      Location l6 = new Location(y + 1, x + 1);
      possiblePlacements.add(l6);
    }
    if (y > 0 && x < 4) {
      Location l7 = new Location(y - 1, x + 1);
      possiblePlacements.add(l7);
    }
    if (y > 0 && x > 0) {
      Location l8 = new Location(y - 1, x - 1);
      possiblePlacements.add(l8);
    }

    return possiblePlacements;
  }

  public Location getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
  }

  public void setJustMoved(boolean justMoved) {
    this.justMoved = justMoved;
  }

  public boolean hasJustMoved() {
    return justMoved;
  }


}
