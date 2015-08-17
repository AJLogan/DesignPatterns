package demos.enums;

public enum GameType {
	SHOOTER("A 'just blast em!' type game"),
	STRATEGY("A game that involves thought"),
	SIMULATION("A game that mimics driving or flying");
	
	GameType(String description) {
		this.description = description;
	}
	public String description() {
		return description;
	}
	private String description;
	
	
}
