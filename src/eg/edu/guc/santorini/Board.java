//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eg.edu.guc.santorini;

import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;
import java.util.ArrayList;

public class Board implements BoardInterface {
	private Player p1;
	private Player p2;
	private Player turn;
	private Location[][] board = new Location[5][5];

	public Board() {
	}

	public Board(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		p1.getT1().setCurrentLocation(new Location(0, 0));
		p1.getT2().setCurrentLocation(new Location(4, 1));
		p2.getT1().setCurrentLocation(new Location(0, 3));
		p2.getT2().setCurrentLocation(new Location(4, 4));
		p1.getT1().getCurrentLocation().setEmpty(false);
		p1.getT2().getCurrentLocation().setEmpty(false);
		p2.getT1().getCurrentLocation().setEmpty(false);
		p2.getT2().getCurrentLocation().setEmpty(false);
		this.board[0][0] = p1.getT1().getCurrentLocation();
		this.board[4][1] = p1.getT2().getCurrentLocation();
		this.board[0][3] = p2.getT1().getCurrentLocation();
		this.board[4][4] = p2.getT2().getCurrentLocation();
		this.setTurn(p1);
	}

	public Player getP2() {
		return this.p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public void a(ArrayList<Location> as) {
		for(int i = 0; i < as.size(); ++i) {
			System.out.println(as.get(i));
		}

	}

	public static void main(String[] args) throws InvalidMoveException {
		Player p1 = new Player("Player 1", 2);
		Player p2 = new Player("Player 2", 2);
		BoardInterface board1 = new Board(p1, p2);
		board1.move(p1.getT2(), new Location(3, 0));
		System.out.println(p1.getT2().possiblePlacements());
	}

	public String[][] display() {
		String[][] s = new String[5][5];
		char c = 'C';
		char d = 'C';
		if (this.getP1().getPieceType() == 2) {
			c = 'P';
		}

		if (this.p2.getPieceType() == 2) {
			d = 'P';
		}

		for(int i = 0; i < s.length; ++i) {
			for(int j = 0; j < s[i].length; ++j) {
				if (this.board[i][j] != null) {
					s[i][j] = "" + this.board[i][j].getLevel();
				} else {
					s[i][j] = "0";
				}

				if (i == this.getP1().getT1().getCurrentLocation().getY() && this.getP1().getT1().getCurrentLocation().getX() == j || i == this.getP1().getT2().getCurrentLocation().getY() && this.getP1().getT2().getCurrentLocation().getX() == j) {
					s[i][j] = s[i][j] + c + "1";
				}

				if (i == this.p2.getT1().getCurrentLocation().getY() && this.p2.getT1().getCurrentLocation().getX() == j || i == this.p2.getT2().getCurrentLocation().getY() && this.p2.getT2().getCurrentLocation().getX() == j) {
					s[i][j] = s[i][j] + d + "2";
				}
			}
		}

		return s;
	}

	public boolean locationinPossible(ArrayList<Location> l, Location location) {
		for(int i = 0; i < l.size(); ++i) {
			if (((Location)l.get(i)).equals(location)) {
				return true;
			}
		}

		return false;
	}

	public boolean canMove(Piece piece, Location location) {
		if (this.board[location.getY()][location.getX()] == null) {
			this.board[location.getY()][location.getX()] = location;
		}

		return this.board[location.getY()][location.getX()].getLevel() <= this.board[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].getLevel() + 1 && this.board[location.getY()][location.getX()].isEmpty() && !this.board[location.getY()][location.getX()].isKilled() && this.locationinPossible(piece.possibleMoves(), location);
	}

	public void move(Piece piece, Location newLocation) throws InvalidMoveException {
		if (this.canMove(piece, newLocation) && !piece.hasJustMoved() && this.turn(piece) && !this.getOtherPiece(piece).hasJustMoved() && !this.isGameOver()) {
			this.board[piece.getCurrentLocation().getY()][piece.getCurrentLocation().getX()].setEmpty(true);
			piece.setCurrentLocation(this.board[newLocation.getY()][newLocation.getX()]);
			piece.setJustMoved(true);
			this.board[newLocation.getY()][newLocation.getX()].setEmpty(false);
		} else {
			throw new InvalidMoveException("Invalid game");
		}
	}

	public Piece getOtherPiece(Piece p) {
		if (p.equals(this.getP1().getT1())) {
			return this.getP1().getT2();
		} else if (p.equals(this.getP1().getT2())) {
			return this.getP1().getT1();
		} else {
			return p.equals(this.p2.getT1()) ? this.p2.getT2() : this.p2.getT1();
		}
	}

	public boolean canPlace(Piece piece, Location location) {
		if (this.board[location.getY()][location.getX()] == null) {
			this.board[location.getY()][location.getX()] = location;
		}

		return this.board[location.getY()][location.getX()].isEmpty() && !this.board[location.getY()][location.getX()].isKilled() && this.locationinPossible(piece.possiblePlacements(), location);
	}

	public void place(Piece piece, Location newLocation) throws InvalidPlacementException {
		if (piece.hasJustMoved() && this.canPlace(piece, newLocation) && !this.isGameOver()) {
			this.board[newLocation.getY()][newLocation.getX()].setLevel(this.board[newLocation.getY()][newLocation.getX()].getLevel() + 1);
			if (this.board[newLocation.getY()][newLocation.getX()].getLevel() == 4) {
				this.board[newLocation.getY()][newLocation.getX()].setKilled(true);
			}

			if (this.getTurn() == this.getP1()) {
				this.setTurn(this.p2);
			} else {
				this.setTurn(this.getP1());
			}

			piece.setJustMoved(false);
		} else {
			throw new InvalidPlacementException("Invalid Placement");
		}
	}

	public boolean turn(Piece p) {
		return this.getTurn().getT1().equals(p) || this.getTurn().getT2().equals(p);
	}

	public boolean hasNoMoves(Player player) {
		int i;
		for(i = 0; i < player.getT1().possibleMoves().size(); ++i) {
			if (this.canMove(player.getT1(), (Location)player.getT1().possibleMoves().get(i))) {
				return false;
			}
		}

		for(i = 0; i < player.getT2().possibleMoves().size(); ++i) {
			if (this.canMove(player.getT2(), (Location)player.getT2().possibleMoves().get(i))) {
				return false;
			}
		}

		return true;
	}

	public boolean isWinner(Player player) {
		return this.otherPlayer(player).equals(this.getTurn()) && this.hasNoMoves(this.otherPlayer(player)) || this.board[player.getT1().getCurrentLocation().getY()][player.getT1().getCurrentLocation().getX()].getLevel() == 3 || this.board[player.getT2().getCurrentLocation().getY()][player.getT2().getCurrentLocation().getX()].getLevel() == 3;
	}

	public Player otherPlayer(Player p) {
		return p.equals(this.getP1()) ? this.p2 : this.getP1();
	}

	public boolean isGameOver() {
		return this.isWinner(this.getP1()) || this.isWinner(this.p2);
	}

	public Player getWinner() {
		if (this.isWinner(this.getP1())) {
			return this.getP1();
		} else {
			return this.isWinner(this.p2) ? this.p2 : null;
		}
	}

	public void setBoard(Location[][] board) {
		this.board = board;
	}

	public Location[][] getBoard() {
		return this.board;
	}

	public void setTurn(Player turn) {
		this.turn = turn;
	}

	public Player getTurn() {
		return this.turn;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP1() {
		return this.p1;
	}
}
