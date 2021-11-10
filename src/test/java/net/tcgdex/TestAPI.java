package net.tcgdex;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.tcgdex.TCGDexAPI.ImageResolution;
import net.tcgdex.TCGDexAPI.Language;

public class TestAPI {

	private TCGDexAPI api;

	@Before
	public void initAPI() {
		this.api = new TCGDexAPI(Language.EN);
	}

	@Test
	public void testRarities() {
		assertEquals("Rare", Rarities.RARE.toPrettyString());
		assertEquals("Ultra Rare", Rarities.ULTRA_RARE.toPrettyString());
		assertEquals("Secret Rare", Rarities.SECRET_RARE.toPrettyString());
		assertEquals("Common", Rarities.COMMON.toPrettyString());
	}

	@Test
	public void compareRarityEnumToAPI() throws IOException {
		List<String> rarities = api.loadRarities();
		assertNotNull(rarities);
		assertEquals(rarities.size(), Rarities.values().length);
		for (String rawRarity : rarities) {
			Rarities rarity = Rarities.parse(rawRarity);
			assertNotNull(rarity);
			assert (rarity.toPrettyString().equals(rawRarity));
		}
	}

	@Test
	public void compareCategoryEnumToAPI() throws IOException {
		List<String> categories = api.loadCategories();
		assertNotNull(categories);
		assertEquals(categories.size(), Categories.values().length);
		for (String rawCategory : categories) {
			Categories category = Categories.parse(rawCategory);
			assertNotNull(category);
			assert (category.toPrettyString().equals(rawCategory));
		}
	}

	@Test
	public void compareTypeEnumToAPI() throws IOException {
		List<String> types = api.loadTypes();
		assertNotNull(types);
		assertEquals(types.size(), Types.values().length);
		for (String rawType : types) {
			Types type = Types.parse(rawType);
			assertNotNull(type);
			assert (type.toPrettyString().equals(rawType));
		}
	}

	@Test
	public void testHPAPI() throws IOException {
		List<Integer> hp = api.getAllPossibleHPValues();
		assertNotNull(hp);
		assert (hp.size() > 30);
		assert (hp.contains(60));
		assert (hp.contains(140));
		assert (hp.contains(320));
	}

	@Test
	public void testFullCardInfo() throws IOException {
		CardInfo info = api.getCardInfo("base4", "1");
		assertNotNull(info);
		assertEquals(Categories.POKEMON, info.getCategory());
		assertEquals("base4-1", info.getId());
		assertEquals("Ken Sugimori", info.getIllustrator());
		assertEquals("1", info.getLocalId());
		assertEquals("Alakazam", info.getName());
		assertEquals(Rarities.RARE, info.getRarity());
		SetResume resume = info.getSet();
		assertNotNull(resume);
		assertEquals(130, resume.getOfficialCardCount());
		assertEquals(130, resume.getTotalCardCount());
		assertEquals("base4", resume.getId());
		assertEquals("Base Set 2", resume.getName());
		assertFalse(info.hasFirstEditionPic());
		assertTrue(info.hasHoloVariant());
		assertTrue(info.hasNormalVariant());
		assertTrue(info.hasReverseVariant());
		assertArrayEquals(new Integer[] { 65 }, info.getDexIDs().toArray());
		Attack attack = new Attack(Arrays.asList(Types.PSYCHIC, Types.PSYCHIC, Types.PSYCHIC), "Confuse Ray",
				"Flip a coin. If heads, the Defending Pokémon is now Confused.", "30");
		assertArrayEquals(new Attack[] { attack }, info.getAttacks().toArray());
		assertEquals(80, (int) info.getHp());
		assertArrayEquals(new Types[] { Types.PSYCHIC }, info.getTypes().toArray());
		Ability ability = new Ability("Poke-POWER", "Damage Swap",
				"As often as you like during your turn (before your attack), you may move 1 damage counter from 1 of your "
						+ "Pokémon to another as long as you don't Knock Out that Pokémon. This power can't be used if Alakazam is Asleep, "
						+ "Confused, or Paralyzed.");
		assertArrayEquals(new Ability[] { ability }, info.getAbilities().toArray());
		assertEquals("Stage2", info.getStage());
		assertEquals("Kadabra", info.getEvolveFrom());
		assertArrayEquals(new Weakness[] { new Weakness(Types.PSYCHIC, "×2") }, info.getWeakness().toArray());

		// fetch a few more cards of different types to make sure there are no
		// exceptions due to weird combinations of fields missing
		assertNotNull(api.getCardInfo("sm10-183"));
		assertNotNull(api.getCardInfo("ex8-90"));
		assertNotNull(api.getCardInfo("swsh3-84"));
		assertNotNull(api.getCardInfo("swsh4-98"));
		assertNotNull(api.getCardInfo("ex13-96"));
		assertEquals("ex13", api.getSetInfo(api.getCardInfo("ex13-96")).getId());
	}

	@Test
	public void testSets() throws IOException {
		SetInfo set = api.getSetInfo("sm10");
		assertNotNull(set);
		assertEquals(234, set.getCards().size());
		assertEquals(234, set.getOfficialCardCount());
		assertEquals(0, set.getReverseCardCount());
		assertEquals(0, set.getHoloCardCount());
		assertEquals(0, set.getFirstEdCardCount());
		assertEquals("Unbroken Bonds", set.getName());
		assertEquals(3, set.getReleaseDate().getDayOfMonth());
		assertEquals(Month.MAY, set.getReleaseDate().getMonth());
		assertEquals("UNB", set.getTcgOnlineCode());
		assertEquals("Sun & Moon", set.getSeries().getName());
		assertTrue(set.isLegalInExpanded());
		assertFalse(set.isLegalInStandard());
	}
	
	@Test
	public void testSeries() throws IOException {
		SeriesInfo info = api.getSeriesInfo("sm");
		assertEquals("sm", info.getId());
		assertEquals("Sun & Moon", info.getName());
		assertEquals(18, info.getSets().size());
		assertEquals("Shining Legends", info.getSets().get(4).getName());
	}

	@Test
	public void testImage() throws IOException {
		CardInfo info = api.getCardInfo("base4", "1");
		BufferedImage high = api.getImage(info, ImageResolution.HIGH);
		assertNotNull(high);
		assertEquals(825, high.getHeight());
		assertEquals(600, high.getWidth());
		BufferedImage low = api.getImage(info, ImageResolution.LOW);
		assertNotNull(low);
		assertEquals(337, low.getHeight());
		assertEquals(245, low.getWidth());
	}

}
