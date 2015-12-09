package br.com.gsf.pre_dojo.singleton;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import br.com.gsf.pre_dojo.model.Player;

public class Ranking {
	
	//Singleton
	private static Ranking instance;
	private Map<String, Integer> murders = new HashMap<String, Integer>();
	private Map<String, Integer> deaths = new HashMap<String, Integer>();
	private Player awardPlayer;
	private final static Logger LOGGER = Logger.getLogger(Ranking.class);
	
	private Ranking() {}
	
	
	public static Ranking getIntance() {
		if(instance == null) {
			instance = new Ranking();
		}
		return instance;
	}
	
	public void updateMurder(Player player) {
		murders.put(player.getNickname(), player.getMurders());
	}

	public void updateDeaths(Player player) {
		deaths.put(player.getNickname(), player.getDeaths());
	}
	

	public Map<String, Integer> getMurders() {
		return murders;
	}


	public Map<String, Integer> getDeaths() {
		return deaths;
	}
	
	public void setAwardPlayer(Player awardPlayer) {
		if(awardPlayer.isAward()) {
			this.awardPlayer = awardPlayer;
		}
	}
	
	public void logRanking() {
		LOGGER.info("Ranking --------------------------------------");
		for (Map.Entry<String, Integer> entry : murders.entrySet())	{
			LOGGER.info("nickName: "+ entry.getKey() + " - murders: " + entry.getValue());
		}
		for (Map.Entry<String, Integer> entry : deaths.entrySet())	{
			LOGGER.info("nickName: "+ entry.getKey() + " - deaths: " + entry.getValue());
		}
		LOGGER.info("nickName: "+ awardPlayer.getNickname() + " has won an award");
		LOGGER.info("----------------------------------------------");
	}


	
}
