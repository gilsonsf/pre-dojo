package br.com.gsf.pre_dojo.enums;

public enum TypePlayer {
	BASIC(3, 1), ADVANTAGE(5, 2);

	private final int lives;
	private final int weapons;

	TypePlayer(int lives, int weapons) {
		this.lives = lives;
		this.weapons = weapons;
	}

	public int lives() {
		return lives;
	}
	public int weapons() {
		return weapons;
	}
}
