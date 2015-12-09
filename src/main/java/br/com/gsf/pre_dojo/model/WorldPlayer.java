package br.com.gsf.pre_dojo.model;

import java.util.ArrayList;
import java.util.List;

public class WorldPlayer {
	
	public static List<TypeDeath> TYPES_OF_DEATH = new ArrayList<TypeDeath>();
	
	public static String NAME = "<WORLD>";
	
	static {
		TYPES_OF_DEATH.add(TypeDeath.DROWN);
		TYPES_OF_DEATH.add(TypeDeath.HURRICANE);
		TYPES_OF_DEATH.add(TypeDeath.FLOOD);
		TYPES_OF_DEATH.add(TypeDeath.FIRE);
	}
	
	enum TypeDeath {
		DROWN, HURRICANE, FLOOD, FIRE;
	}


}
