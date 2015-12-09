package br.com.gsf.pre_dojo.observer;

import br.com.gsf.pre_dojo.model.Player;
import br.com.gsf.pre_dojo.singleton.Ranking;

public class MurderObserver extends Observer {

	public MurderObserver(RankingObserver subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update(Player player) {
		Ranking.getIntance().updateMurder(player);
	}

}