package br.com.gsf.pre_dojo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.gsf.pre_dojo.enums.TypePlayer;
import br.com.gsf.pre_dojo.enums.TypeWeapon;
import br.com.gsf.pre_dojo.model.Player;
import br.com.gsf.pre_dojo.model.Weapon;
import br.com.gsf.pre_dojo.singleton.Ranking;

public class RankingTest {
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void test_RANKING_AWAR_SUCESS() {
	
		Player player =  getPlayer();
		player.setAward(true);
		Ranking.getIntance().setAwardPlayer(player);
		
		assertEquals(Ranking.getIntance().getAwardPlayer().isAward(), true);
	}

	@Test
	public void test_RANKING_AWAR_ERROR() {
		Player player =  getPlayer();
		Ranking.getIntance().setAwardPlayer(player);
		
		assertEquals(Ranking.getIntance().getAwardPlayer().isAward(), false);
	}
	
	private Player getPlayer() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon(TypeWeapon.AK47));
		Player player = new Player("GIL", weapons, TypePlayer.BASIC);
		
		return player;
	}
	
}
