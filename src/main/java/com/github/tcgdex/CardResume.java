package com.github.tcgdex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Core information to describe a single card
 *
 */
public class CardResume {
	
	static List<CardResume> parse(JSONArray array) {
		if (array == null) {
			return Collections.emptyList();
		}
		List<CardResume> result = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			result.add(new CardResume(array.getJSONObject(i)));
		}
		return result;
	}
	
	private final String id;
	private final String localId;
	private final String name;
	private final String image;
	
	CardResume(JSONObject json) {
		this(json.getString("id"), json.getString("localId"), json.getString("name"), json.optString("image"));
	}
	
	CardResume(String id, String localId, String name, String image) {
		this.id = id;
		this.localId = localId;
		this.name = name;
		this.image = image;
	}
	
	/**
	 * @return Globally unique card ID based on the set ID and the cards ID within the set
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @return Card image, can be null
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * @return ID indexing this card within its set, usually just its number
	 */
	public String getLocalId() {
		return localId;
	}
	
	/**
	 * 
	 * @return Card name
	 */
	public String getName() {
		return name;
	}
}
