package com.github.tcgdex;

import java.util.List;

import org.json.JSONObject;

/**
 * Detailed info regarding a series, including which sets it includes
 *
 */
public class SeriesInfo extends SeriesResume {
	
	private final List<SetResume> sets;
	
	SeriesInfo(JSONObject json) {
		super(json);
		this.sets = SetResume.parse(json.optJSONArray("sets"));
	}

	SeriesInfo(String id, String name, List<SetResume> sets) {
		super(id, name);
		this.sets = sets;
	}

	/**
	 * @return Resumes of the sets part of this series
	 */
	public List<SetResume> getSets() {
		return sets;
	}
}
