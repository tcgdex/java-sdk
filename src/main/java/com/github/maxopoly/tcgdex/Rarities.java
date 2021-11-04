package com.github.maxopoly.tcgdex;

public enum Rarities {
	
	RARE, COMMON, NONE, ULTRA_RARE, UNCOMMON, AMAZING, SECRET_RARE;
	
	static Rarities parse(String raw) {
		return Rarities.valueOf(raw.toUpperCase().replace(" ", "_"));
	}
	
	public String toPrettyString() {
		return Utils.prettifyEnumName(this);
	}
	

}
