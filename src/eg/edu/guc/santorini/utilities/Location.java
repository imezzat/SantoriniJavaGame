package eg.edu.guc.santorini.utilities;
public class Location {
private int y, x;
private int level = 0;
private boolean empty = true;
private boolean killed = false;
public Location(int y, int x) {
	this.setY(y);
	this.setX(x);
	}
public boolean equals(Location l) {
	  if (l.getX() == this.getX() && l.getY() == this.getY()) {
	   return true;
	  }
	  return false;
	 }
public void setY(int y) {
	this.y = y;
}
public int getY() {
	return y;
}
public void setX(int x) {
	this.x = x;
}
public int getX() {
	return x;
}
public void setEmpty(boolean empty) {
	this.empty = empty;
}
public boolean isEmpty() {
	return empty;
}
public void setLevel(int level) {
	this.level = level;
}
public int getLevel() {
	return level;
}
public void setKilled(boolean killed) {
	this.killed = killed;
}
public boolean isKilled() {
	return killed;
}
}
