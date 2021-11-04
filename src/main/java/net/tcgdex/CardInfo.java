package net.tcgdex;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Full description of a card, including all information available about it
 *
 */
public class CardInfo extends CardResume {

	private final String illustrator;
	private final Rarities rarity;
	private final Categories category;
	private final boolean hasNormalVariant;
	private final boolean hasReverseVariant;
	private final boolean hasHolo;
	private final boolean hasFirstEditionPic;
	private final SetResume set;
	private final List<Integer> dexIDs;
	private final Integer hp;
	private final List<Types> types;
	private final String evolveFrom;
	private final String description;
	private final String level;
	private final String stage;
	private final String suffix;
	private final List<Attack> attacks;
	private final List<Weakness> weakness;
	private final List<Ability> abilities;
	private final Integer retreat;
	private final String regulationMark;

	CardInfo(JSONObject json) {
		super(json);
		this.illustrator = json.getString("illustrator");
		this.rarity = Rarities.parse(json.getString("rarity"));
		this.category = Categories.parse(json.getString("category"));
		JSONObject variantSection = json.getJSONObject("variants");
		this.hasNormalVariant = variantSection.getBoolean("normal");
		this.hasReverseVariant = variantSection.getBoolean("reverse");
		this.hasHolo = variantSection.getBoolean("holo");
		this.hasFirstEditionPic = variantSection.getBoolean("firstEdition");
		this.set = new SetResume(json.getJSONObject("set"));
		this.dexIDs = new ArrayList<>(1);
		JSONArray dexArray = json.optJSONArray("dexId");
		if (dexArray != null) {
			for (int i = 0; i < dexArray.length(); i++) {
				this.dexIDs.add(dexArray.getInt(i));
			}
		}
		this.hp = json.optInt("hp", -1) > 0 ? json.getInt("hp") : null;
		this.types = Types.parse(json.optJSONArray("types"));
		this.stage = json.optString("stage");
		this.suffix = json.optString("suffix");
		this.attacks = Attack.parse(json.optJSONArray("attacks"));
		this.weakness = Weakness.parse(json.optJSONArray("weaknesses"));
		this.retreat = json.optInt("retreat", -1) > 0 ? json.getInt("retreat") : null;
		this.regulationMark = json.optString("regulationMark");
		this.level = json.optString("level");
		this.evolveFrom = json.optString("evolveFrom");
		this.description = json.optString("effect");
		this.abilities = Ability.parse(json.optJSONArray("abilities"));
	}

	public CardInfo(String id, String localId, String name, String image, String illustrator, Rarities rarity,
			Categories category, boolean hasNormalVariant, boolean hasReverseVariant, boolean hasHolo,
			boolean hasFirstEditionPic, SetResume set, List<Integer> dexIDs, Integer hp, List<Types> types,
			String evolveFrom, String description, String level, String stage, String suffix, List<Attack> attacks,
			List<Weakness> weakness, List<Ability> abilities, Integer retreat, String regulationMark) {
		super(id, localId, name, image);
		this.illustrator = illustrator;
		this.rarity = rarity;
		this.category = category;
		this.hasNormalVariant = hasNormalVariant;
		this.hasReverseVariant = hasReverseVariant;
		this.hasHolo = hasHolo;
		this.hasFirstEditionPic = hasFirstEditionPic;
		this.set = set;
		this.dexIDs = dexIDs;
		this.hp = hp;
		this.types = types;
		this.evolveFrom = evolveFrom;
		this.description = description;
		this.level = level;
		this.stage = stage;
		this.suffix = suffix;
		this.attacks = attacks;
		this.weakness = weakness;
		this.abilities = abilities;
		this.retreat = retreat;
		this.regulationMark = regulationMark;
	}

	/**
	 * @return Pokemon's abilities. May be empty if it doesn't have any, but never
	 *         null
	 */
	public List<Ability> getAbilities() {
		return abilities;
	}

	/**
	 * @return Attacks the pokemon has. Empty for cards without attacks
	 */
	public List<Attack> getAttacks() {
		return attacks;
	}

	/**
	 * 
	 * @return Card category
	 */
	public Categories getCategory() {
		return category;
	}

	/**
	 * 
	 * @return List of the national pokedex IDs of the pokemon on the card (may be
	 *         multiple)
	 */
	public List<Integer> getDexIDs() {
		return dexIDs;
	}

	/**
	 * 
	 * @return Card effect/description, may be null
	 */
	public String getEffect() {
		return description;
	}

	/**
	 * 
	 * @return Name of the pokemon this one evolves from
	 */
	public String getEvolveFrom() {
		return evolveFrom;
	}

	/**
	 * @return HP of the pokemon, will be null if the card is not a pokemon
	 */
	public Integer getHp() {
		return hp;
	}

	/**
	 * 
	 * @return Card illustrator
	 */
	public String getIllustrator() {
		return illustrator;
	}

	/**
	 * 
	 * @return Pokemon level, may be 'X', hence not an integer
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 
	 * @return Card rarity
	 */
	public Rarities getRarity() {
		return rarity;
	}

	/**
	 * 
	 * @return Card's regulation mark. May be null if unknown or doesn't exist
	 */
	public String getRegulationMark() {
		return regulationMark;
	}

	/**
	 * @return Card's retreat. Will be null for cards without retreat
	 */
	public Integer getRetreat() {
		return retreat;
	}

	/**
	 * @return Resume of the set the card belongs to
	 */
	public SetResume getSet() {
		return set;
	}

	/**
	 * @return Pokemon's stage, like 'Basic'
	 */
	public String getStage() {
		return stage;
	}

	/**
	 * @return Suffix, like 'V', may be null
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @return Types of the pokemon
	 */
	public List<Types> getTypes() {
		return types;
	}

	/**
	 * @return Weaknesses the pokemon has. Empty for cards without attacks
	 */
	public List<Weakness> getWeakness() {
		return weakness;
	}

	/**
	 * 
	 * @return Does the card have a small first edition in the middle left
	 */
	public boolean hasFirstEditionPic() {
		return hasFirstEditionPic;
	}

	/**
	 * 
	 * @return Does the card have a holo variant (picture is shining)
	 */
	public boolean hasHoloVariant() {
		return hasHolo;
	}

	/**
	 * 
	 * @return Does the card have a normal variant without any shines
	 */
	public boolean hasNormalVariant() {
		return hasNormalVariant;
	}

	/**
	 * 
	 * @return Does the card have a reverse variant (colored background is shining)
	 */
	public boolean hasReverseVariant() {
		return hasReverseVariant;
	}

}
