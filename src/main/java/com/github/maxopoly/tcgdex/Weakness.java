package com.github.maxopoly.tcgdex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Describes the weakness of a single pokemon, for example: 2x to Fire
 *
 */
public class Weakness {
	
	static List<Weakness> parse(JSONArray array) {
		if (array == null) {
			return Collections.emptyList();
		}
		List<Weakness> result = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			result.add(new Weakness(array.getJSONObject(i)));
		}
		return result;
	}
	
	private final Types type;
	private final String value;
	
	
	Weakness(Types type, String value) {
		this.type = type;
		this.value = value;
	}
	
	Weakness(JSONObject json) {
		this(Types.parse(json.getString("type")), json.getString("value"));
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Weakness)) {
			return false;
		}
		Weakness other = (Weakness) o;
		return Objects.deepEquals(new Object[] { this.type, this.value},
				new Object[] { other.type, other.value});
	}
	
	public int hashCode() {
		return Objects.hash(this.type, this.value);
	}
	
	public String toString() {
		return String.format("%s %s", this.type, this.value);
	}
	
	/**
	 * @return Type the weakness is to
	 */
	public Types getType() {
		return type;
	}
	
	/**
	 * @return Descriptor of the weakness multiplier, including a leading x, for example 'x2'
	 */
	public String getValue() {
		return value;
	}
	
	

}
