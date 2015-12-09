package br.com.gsf.pre_dojo.observer;

import br.com.gsf.pre_dojo.model.Player;
import br.com.gsf.pre_dojo.singleton.Ranking;

public class DeathObserver extends Observer {

	public DeathObserver(RankingObserver subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update(Player player) {
		Ranking.getIntance().updateDeaths(player);
	}

}