package br.com.gsf.pre_dojo.observer;

import java.util.ArrayList;
import java.util.List;

import br.com.gsf.pre_dojo.model.Player;

public class RankingObserver {
   
	
	private List<Observer> observers = new ArrayList<Observer>();
	   private Player playerState;

	   public Player getState() {
	      return playerState;
	   }

	   public void setState(Player state) {
	      this.playerState = state;
	      notifyAllObservers();
	   }

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update(playerState);
	      }
	   } 	
}
