# Tcgdex-java

This is a Java API for querying the Pokémon TCG database of [TCGdex](https://github.com/tcgdex/).

To use it, first initialize an API instance with the language you want results to be in
```java
TCGDexAPI api = new TCGDexAPI(TCGDexAPI.Language.EN);
```

Use it to obtain POJOs representing cards, sets and series. For all of these, there is a function listing all available including short info and a function to get detailed information regarding one.

```java
//all cards available
List<CardResume> allCards = api.getAllCards();
//detailed card info
CardInfo card = api.getCardInfo(allCards.get(23));

//all sets available
List<SetResume> allSets = getAllSets();
//Obtained set info either based on the listing of all sets
SetInfo set = getSetInfo(allSets.get(1));
//or based on some card, also works for CardInfo
SetInfo set2 = getSetInfo(allCards.get(10));

//all series available
List<SeriesResume> allSeries = getAllSeries();
//same possibilties for series
SeriesInfo series = getSeriesInfo(allSeries.get(2));
SeriesInfo series2 = getSeriesInfo(set);

```
