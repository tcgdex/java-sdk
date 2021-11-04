package net.tcgdex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.JSONObject;

/**
 * Detailed information regarding a set
 *
 */
public class SetInfo extends SetResume {

	private static final DateTimeFormatter timeParser = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private final int holo;
	private final int normal;
	private final int firstEd;
	private final int reverse;
	private final SeriesResume series;
	private final String tcgOnlineCode;
	private final LocalDate releaseDate;
	private final boolean legalInStandard;
	private final boolean legalInExpanded;
	private final List<CardResume> cards;

	SetInfo(JSONObject json) {
		super(json);
		JSONObject count = json.getJSONObject("cardCount");
		this.holo = count.getInt("holo");
		this.firstEd = count.getInt("firstEd");
		this.reverse = count.getInt("reverse");
		this.normal = count.getInt("normal");
		this.series = new SeriesResume(json.getJSONObject("serie"));
		this.tcgOnlineCode = json.getString("tcgOnline");
		this.releaseDate = LocalDate.parse(json.getString("releaseDate"), timeParser);
		JSONObject legality = json.getJSONObject("legal");
		this.legalInExpanded = legality.getBoolean("expanded");
		this.legalInStandard = legality.getBoolean("standard");
		this.cards = CardResume.parse(json.getJSONArray("cards"));

	}

	SetInfo(String id, String name, String logo, String symbol, int officialCardCount, int totalCardCount, int holo,
			int normal, int firstEd, int reverse, SeriesResume series, String tcgOnlineCode, LocalDate releaseDate,
			boolean legalInStandard, boolean legalInExpanded, List<CardResume> cards) {
		super(id, name, logo, symbol, officialCardCount, totalCardCount);
		this.holo = holo;
		this.normal = normal;
		this.firstEd = firstEd;
		this.reverse = reverse;
		this.series = series;
		this.tcgOnlineCode = tcgOnlineCode;
		this.releaseDate = releaseDate;
		this.legalInStandard = legalInStandard;
		this.legalInExpanded = legalInExpanded;
		this.cards = cards;
	}

	/**
	 * @return All cards part of the set
	 */
	public List<CardResume> getCards() {
		return cards;
	}

	/**
	 * @return Amount of first edition cards the set has
	 */
	public int getFirstEdCardCount() {
		return firstEd;
	}

	/**
	 * @return Amount of holo cards the set has
	 */
	public int getHoloCardCount() {
		return holo;
	}

	/**
	 * @return Amount of normal cards the set has
	 */
	public int getNormalCardCount() {
		return normal;
	}

	/**
	 * @return When the set was released
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @return Amount of reverse cards the set has
	 */
	public int getReverseCardCount() {
		return reverse;
	}

	/**
	 * @return Series the set is part of
	 */
	public SeriesResume getSeries() {
		return series;
	}

	/**
	 * @return Pokémon TCG Online Set code
	 */
	public String getTcgOnlineCode() {
		return tcgOnlineCode;
	}

	/**
	 * @return Ability to use this set in Expanded competitions
	 */
	public boolean isLegalInExpanded() {
		return legalInExpanded;
	}

	/**
	 * @return Ability to use this set in standard competitions
	 */
	public boolean isLegalInStandard() {
		return legalInStandard;
	}
}
