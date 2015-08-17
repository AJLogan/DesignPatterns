package demos.enums;

public enum Direction {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	public void print() {
		if(this == WEST) {
			System.out.println("W<--");
		} else if(this == EAST) {
			System.out.println("E-->");
		} else if(this == NORTH) {
			System.out.println("N /\\");
		} else {
			System.out.println("S \\/");
		}
	}
}
