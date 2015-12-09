package br.com.gsf.pre_dojo.model;

import java.util.List;

import br.com.gsf.pre_dojo.enums.TypePlayer;

public class Player {
	
	private String nickname;
	private int murders;
	private int deaths;
	private List<Weapon> weapons;
	private TypePlayer type;
	private boolean award;
	
	public Player() {}
	
	public Player(String nickname, List<Weapon> weapons, TypePlayer type) {
		this.nickname = nickname;
		this.weapons = weapons;
		this.type = type;
	}
	
	//getters and setters
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMurders() {
		return murders;
	}
	public void setMurders(int murders) {
		this.murders = murders;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public TypePlayer getType() {
		return type;
	}
	public void setType(TypePlayer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(nickname);
		return builder.toString();
	}

	public boolean isAward() {
		return award;
	}

	public void setAward(boolean award) {
		this.award = award;
	}

	
	
	
	

}
