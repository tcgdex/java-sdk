package net.tcgdex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Contains all information describing a set of cards
 *
 */
public class SetResume {
	
	static List<SetResume> parse(JSONArray array) {
		if (array == null) {
			return Collections.emptyList();
		}
		List<SetResume> result = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			result.add(new SetResume(array.getJSONObject(i)));
		}
		return result;
	}

	private final String id;
	private final String name;
	private final String logo;
	private final String symbol;
	private final int officialCardCount;
	private final int totalCardCount;

	public SetResume(JSONObject json) {
		this(json.getString("id"), json.getString("name"), json.optString("logo"), json.optString("symbol"),
				json.getJSONObject("cardCount").getInt("total"), json.getJSONObject("cardCount").getInt("official"));
	}

	SetResume(String id, String name, String logo, String symbol, int officialCardCount, int totalCardCount) {
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.symbol = symbol;
		this.officialCardCount = officialCardCount;
		this.totalCardCount = totalCardCount;
	}

	/**
	 * @return Set unique ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return Set logo URL, may be null
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @return Set name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Official amount of cards in this set
	 */
	public int getOfficialCardCount() {
		return officialCardCount;
	}

	/**
	 * @return Set symbol URL, may be null
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return Total amount of cards in this set
	 */
	public int getTotalCardCount() {
		return totalCardCount;
	}
}
