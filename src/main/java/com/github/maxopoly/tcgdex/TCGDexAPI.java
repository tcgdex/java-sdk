package com.github.maxopoly.tcgdex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class TCGDexAPI {

	public enum Language {
		DE, EN, ES, FR, IT, PT;

		public String getAPIID() {
			return toString().toLowerCase();
		}
	}

	private static final String API_URL = "https://api.tcgdex.net/v2/%s/%s";

	private Language language;

	/**
	 * Construct a new API instance. Does not do any networking, merely initialized
	 * the local state. Multiple instances of this class may be held and used at the
	 * same time without issue
	 * 
	 * @param language Language to use for all queries
	 */
	public TCGDexAPI(Language language) {
		this.language = language;
	}

	/**
	 * Gets a list containing the core information for every core
	 * 
	 * @return Resume of every card available
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public List<CardResume> getAllCards() throws IOException {
		String data = Utils.doGet(buildURL("cards"));
		return CardResume.parse(new JSONArray(data));
	}

	/**
	 * Gets detailed information of a card based on a sets identifier and the
	 * identifier/index of a card within this set. Note that for example 'base4-1'
	 * is already a combined identifier, here the correct setID would be 'base4' and
	 * the cardID '1'
	 * 
	 * @param setID  Unique ID of the set
	 * @param cardID ID/index describing the card within the set
	 * @return Card info obtained
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public CardInfo getCardInfo(String setID, String cardID) throws IOException {
		String data = Utils.doGet(buildURL("sets", setID, cardID));
		return new CardInfo(new JSONObject(data));
	}

	/**
	 * Gets detailed information of a card based on its globally unique identifier,
	 * for example 'base4-1'
	 * 
	 * @param globalCardID Globally unique ID of the card
	 * @return Card info obtained
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public CardInfo getCardInfo(String globalCardID) throws IOException {
		String data = Utils.doGet(buildURL("cards", globalCardID));
		return new CardInfo(new JSONObject(data));
	}

	/**
	 * Gets detailed information of a card based on its resume
	 * 
	 * @param card Card to get info for
	 * @return Card info obtained
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public CardInfo getCardInfo(CardResume card) throws IOException {
		return getCardInfo(card.getId());
	}

	/**
	 * Gets a list containing the core information regarding all series
	 * 
	 * @return Resume of each series
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public List<SeriesResume> getAllSeries() throws IOException {
		String data = Utils.doGet(buildURL("series"));
		JSONArray json = new JSONArray(data);
		List<SeriesResume> result = new ArrayList<>();
		for (int i = 0; i < json.length(); i++) {
			result.add(new SeriesResume(json.getJSONObject(i)));
		}
		return result;
	}

	/**
	 * Gets a list containing the core information regarding all sets
	 * 
	 * @return Resume of each set
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public List<SetResume> getAllSets() throws IOException {
		String data = Utils.doGet(buildURL("sets"));
		return SetResume.parse(new JSONArray(data));
	}

	/**
	 * Gets detailed information of a series based on its ID
	 * 
	 * @param seriesID ID of the series
	 * @return Detailed information of the series
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public SeriesInfo getSeriesInfo(String seriesID) throws IOException {
		String data = Utils.doGet(buildURL("series", seriesID));
		return new SeriesInfo(new JSONObject(data));
	}
	
	/**
	 * Gets detailed information of a series based on a set belonging to it
	 * 
	 * @param set Set the series belongs to
	 * @return Detailed information of the series
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public SeriesInfo getSeriesInfo(SetInfo set) throws IOException {
		String data = Utils.doGet(buildURL("series", set.getSeries().getId()));
		return new SeriesInfo(new JSONObject(data));
	}

	/**
	 * Gets detailed information of a set based on its ID
	 * 
	 * @param setID ID of the set
	 * @return Detailed information of the set
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public SetInfo getSetInfo(String setID) throws IOException {
		String data = Utils.doGet(buildURL("sets", setID));
		return new SetInfo(new JSONObject(data));
	}
	
	/**
	 * Gets detailed information of a set based on a card belonging to it
	 * 
	 * @param setID ID of the set
	 * @return Detailed information of the set
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public SetInfo getSetInfo(CardResume card) throws IOException {
		String id = card.getId();
		String data = Utils.doGet(buildURL("sets", id.substring(0, id.lastIndexOf("-"))));
		return new SetInfo(new JSONObject(data));
	}

	List<String> loadRarities() throws IOException {
		return loadStringArrayFrom("rarities");
	}

	List<String> loadCategories() throws IOException {
		return loadStringArrayFrom("categories");
	}

	List<String> loadTypes() throws IOException {
		return loadStringArrayFrom("types");
	}

	/**
	 * Gets a list of all known card illustrators
	 * 
	 * @return List of all illustrators
	 * @throws IOException Thrown in response to any kind of networking error
	 */
	public List<String> getAllIllustrators() throws IOException {
		return loadStringArrayFrom("illustrators");
	}

	public List<Integer> getAllPossibleHPValues() throws IOException {
		String data = Utils.doGet(buildURL("hp"));
		JSONArray json = new JSONArray(data);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < json.length(); i++) {
			result.add(json.getInt(i));
		}
		return result;
	}

	private List<String> loadStringArrayFrom(String path) throws IOException {
		String data = Utils.doGet(buildURL(path));
		JSONArray json = new JSONArray(data);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < json.length(); i++) {
			result.add(json.getString(i));
		}
		return result;
	}

	private String buildURL(String path, String... optional) {
		String result = String.format(API_URL, this.language.getAPIID(), path);
		// not gonna do a string builder here, because we intend this array to be of
		// length 1 in almost all cases
		for (String opt : optional) {
			result += "/" + opt;
		}
		return result;
	}

}
