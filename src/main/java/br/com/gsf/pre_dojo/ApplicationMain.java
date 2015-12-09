package br.com.gsf.pre_dojo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.com.gsf.pre_dojo.controller.MatchController;
import br.com.gsf.pre_dojo.enums.TypePlayer;
import br.com.gsf.pre_dojo.enums.TypeWeapon;
import br.com.gsf.pre_dojo.model.Match;
import br.com.gsf.pre_dojo.model.Player;
import br.com.gsf.pre_dojo.model.Weapon;

public class ApplicationMain {
	
	private Scanner scanner = new Scanner(System.in);
	private MatchController matchController = new MatchController();

	public static void main(String[] args) {
		new ApplicationMain();
	}

	public ApplicationMain() {
		init();
	}

	private void init() {

		msg("Enter number of players >>");

		Random gerador = new Random();
		long code = gerador.nextInt(99999999);
		int numberOfPlayers = scanner.nextInt();

		Match match = new Match(numberOfPlayers, code);

		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();

		// get players
		for (int i = 0; i < match.getNumberOfPlayers(); i++) {
			msg("Enter nickname player #" + (i + 1) + " >>");
			String nickname = scanner.next();
			msg("Enter type player (BASIC=1, ADVANCED=2) >>");
			TypePlayer typePlayer;
			if (scanner.nextInt() == 2) {
				typePlayer = TypePlayer.ADVANCED;
			} else {
				typePlayer = TypePlayer.BASIC;
			}

			// get weapons
			for (int j = 0; j < typePlayer.weapons(); j++) {
				msg("Enter weapon (M16=1, AK47=2, M4A1=3) #" + (j + 1) + " >>");
				TypeWeapon weapon;
				switch (scanner.nextInt()) {
				case 1:
					weapon = TypeWeapon.M16;
					break;
				case 2:
					weapon = TypeWeapon.AK47;
					break;
				case 3:
					weapon = TypeWeapon.M4A1;
					break;

				default:
					weapon = TypeWeapon.M16;
					break;
				}

				weapons.add(new Weapon(weapon));
			}

			Player player = new Player(nickname, weapons, typePlayer);

			players.add(player);

		}

		match.setPlayers(players);
		
		matchController.setMatch(match);
		matchController.execute();

		scanner.close();
		
	}

	private void msg(String msg) {
		System.out.print(msg);
	}

}
