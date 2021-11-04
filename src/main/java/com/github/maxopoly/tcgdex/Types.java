package com.github.maxopoly.tcgdex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;

public enum Types {

	PSYCHIC, FIGHTING, COLORLESS, LIGHTNING, GRASS, DRAGON, METAL, FIRE, WATER, DARKNESS, FAIRY;

	static List<Types> parse(JSONArray array) {
		if (array == null) {
			return Collections.emptyList();
		}
		List<Types> result = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			Types type = parse(array.getString(i));
			if (type != null) {
				result.add(type);
			}
		}
		return result;
	}
	
	static Types parse(String raw) {
		try {
			return Types.valueOf(raw.toUpperCase().replace(" ", "_"));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public String toPrettyString() {
		return Utils.prettifyEnumName(this);
	}

}
