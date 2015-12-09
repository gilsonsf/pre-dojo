package br.com.gsf.pre_dojo.observer;

import br.com.gsf.pre_dojo.model.Player;

public abstract class Observer {
	
	   protected RankingObserver subject;
	   
	   public abstract void update(Player player);
	}
