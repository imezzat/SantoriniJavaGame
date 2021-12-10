package eg.edu.guc.santorini.players;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.tiles.Pyramid;
public class Player {
private String name;
private int pieceType;
private Piece t1, t2;
public Player(String name, int pieceType) {
	this.setName(name);
	this.pieceType = pieceType;
	if (pieceType == 1) {
		t1 = new Cube();
		t2 = new Cube();
	}
	if (pieceType == 2) {
		t1 = new Pyramid();
		t2 = new Pyramid();
	}
}
public void setT1(Piece t1) {
	this.t1 = t1;
}
public Piece getT1() {
	return t1;
}
public void setT2(Piece t2) {
	this.t2 = t2;
}
public Piece getT2() {
	return t2;
}
public int getPieceType() {
	return pieceType;
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
}
