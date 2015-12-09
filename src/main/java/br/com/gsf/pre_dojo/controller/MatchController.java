package br.com.gsf.pre_dojo.controller;

import br.com.gsf.pre_dojo.model.Match;

public class MatchController {
	
	private Match match;
	
	public void execute() {
		match.execute();
	}
	
	//getter and setters
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
}
