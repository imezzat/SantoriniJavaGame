package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;
import eg.edu.guc.santorini.utilities.Location;

public class Pyramid extends Piece {
	public ArrayList<Location> possibleMoves() {
			   ArrayList<Location> possibleMoves = new ArrayList<Location>();
			   int y = getCurrentLocation().getY();
			   int x = getCurrentLocation().getX(); 
			   if (y != 4 && x != 4) {
			   Location l1 = new Location(y + 1, x + 1);
			   possibleMoves.add(l1);
			   }
			   if (y != 0 && x != 0) {
			   Location l2 = new Location(y - 1, x - 1);
			   possibleMoves.add(l2);
			   }
			   if (y != 0 && x != 4) {
			   Location l3 = new Location(y - 1, x + 1);
			   possibleMoves.add(l3);
			   }
			   if (y != 4 && x != 0) {
			   Location l4 = new Location(y + 1, x - 1);
			   possibleMoves.add(l4);
			   }
			   
			   return possibleMoves;
			 }

}