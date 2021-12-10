package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;
import eg.edu.guc.santorini.utilities.Location;

public class Cube extends Piece {
	public ArrayList<Location> possibleMoves() {
		  ArrayList<Location> possibleMoves = new ArrayList<Location>();
		  int y = getCurrentLocation().getY();
		  int x = getCurrentLocation().getX(); 
		  if (x != 0) {
		   Location l1 = new Location(y, x - 1);
		   possibleMoves.add(l1);
		  }
		  if (x != 4) {
		   Location l2 = new Location(y, x + 1);
		   possibleMoves.add(l2);
		  }
		  if (y != 0) {
		   Location l3 = new Location(y - 1, x);
		   possibleMoves.add(l3);
		  }
		  if (y != 4) {
		   Location l4 = new Location(y + 1, x);
		   possibleMoves.add(l4);
		  }

		  return possibleMoves;
		 }
}
