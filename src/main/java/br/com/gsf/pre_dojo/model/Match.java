package br.com.gsf.pre_dojo.model;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import br.com.gsf.pre_dojo.enums.TypePlayer;
import br.com.gsf.pre_dojo.enums.TypeWeapon;
import br.com.gsf.pre_dojo.observer.AwardObserver;
import br.com.gsf.pre_dojo.observer.DeathObserver;
import br.com.gsf.pre_dojo.observer.MurderObserver;
import br.com.gsf.pre_dojo.observer.RankingObserver;
import br.com.gsf.pre_dojo.singleton.Ranking;

public class Match implements Runnable {

	private static final int HAS_ONLY_ONE_PLAYER = 1;

	private static final int LAST_ONE = 1;

	private final static Logger LOGGER = Logger.getLogger(Match.class);

	private final long INTERVAL = 500;

	private List<Player> players;

	private long code;

	private int numberOfPlayers;

	private RankingObserver observer = new RankingObserver();
	
	public Match(int numberOfPlayers, long code) {
		this.numberOfPlayers = numberOfPlayers;
		this.code = code;
		
		new MurderObserver(observer);
		new DeathObserver(observer);
		new AwardObserver(observer);
	}
	
	public void execute() {
		begin();
	}

	@Override
	public void run() {
		boolean hasPlayers = true;

		while (hasPlayers) {
			
			if(players.size() == HAS_ONLY_ONE_PLAYER) {
				break;
			}
			
			Random rd = new Random();
			int randomMurder = rd.nextInt(players.size() + 1);
			Player murder = null;
			TypeWeapon weapon = null;
			
			if(randomMurder != players.size()) {
				murder = players.get(randomMurder);
				
				if (murder.getType() == TypePlayer.ADVANTAGE) {
					weapon = murder.getWeapons().get(rd.nextInt(3)).getType();
				} else {
					weapon = murder.getWeapons().get(0).getType();
				}
				
			}
			
			int randomDeath = rd.nextInt(players.size());
			while(randomDeath == randomMurder) {
				randomDeath = rd.nextInt(players.size());
			}
			Player death = players.get(randomDeath);
			
			if(randomMurder != players.size()) {
				LOGGER.info(murder.getNickname() + " killed " + death.getNickname() + " using " + weapon);
				murder.setMurders(murder.getMurders() + 1);
				observer.setState(murder);
			} else {
				LOGGER.info(WorldPlayer.NAME + " killed " + death.getNickname() + " by " + WorldPlayer.TYPES_OF_DEATH.get(rd.nextInt(4)));
			}

			death.setDeaths(death.getDeaths() + 1);
			observer.setState(death);
			
			if(death.getDeaths() == death.getType().lives()) {
				players.remove(randomDeath);
			}
			
			if(players.size() == LAST_ONE) {
				hasPlayers = false;
				//get winner
				Player winner = players.get(0);
				winner.setAward(true);
				observer.setState(winner);
			}
			
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		
		finish();

	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	private void begin() {
		LOGGER.info("New match " + code + " has started");
		Thread threadMatch = new Thread(this);
		threadMatch.start();
	}

	private void finish() {
		LOGGER.info("Match " + code + " has ended");
		Ranking.getIntance().logRanking();
		
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
