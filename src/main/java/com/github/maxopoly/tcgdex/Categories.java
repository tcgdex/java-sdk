package com.github.maxopoly.tcgdex;

public enum Categories {
	
	POKEMON, ENERGY, TRAINER;
	
	static Categories parse(String raw) {
		return Categories.valueOf(raw.toUpperCase().replace(" ", "_"));
	}
	
	public String toPrettyString() {
		return Utils.prettifyEnumName(this);
	}

}
