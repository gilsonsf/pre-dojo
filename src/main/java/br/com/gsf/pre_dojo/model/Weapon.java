package br.com.gsf.pre_dojo.model;

import br.com.gsf.pre_dojo.enums.TypeWeapon;

public class Weapon {
	
	private TypeWeapon type;

	public Weapon(TypeWeapon type) {
		this.type = type;
	}

	public TypeWeapon getType() {
		return type;
	}

	public void setType(TypeWeapon type) {
		this.type = type;
	}

}
