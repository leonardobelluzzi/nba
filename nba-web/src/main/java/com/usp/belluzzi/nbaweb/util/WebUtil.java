package com.usp.belluzzi.nbaweb.util;

import org.json.JSONObject;

import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;



public class WebUtil {


	public static JSONObject statsToJSON (StatsSeason stats){	
		JSONObject json = new JSONObject();

		json.put("team", stats.getTeam().toString());
		json.put("assist", stats.getAssist());
		json.put("block", stats.getBlock());
		json.put("defensiveRebound", stats.getDefensiveRebound());
		json.put("freeThrow", stats.getFreeThrow());
		json.put("freeThrowAttempt", stats.getFreeThrowAttempt());
		json.put("offensiveRebound", stats.getOffensiveRebound());
		json.put("personalFoul", stats.getPersonalFoul());
		json.put("point", stats.getPoint());
		json.put("steal", stats.getSteal());
		json.put("threePoint", stats.getThreePoint());
		json.put("threePointAttempt", stats.getThreePointAttempt());
		json.put("turnover", stats.getTurnover());
		json.put("twoPoint", stats.getTwoPoint());
		json.put("twoPointAttempt", stats.getTwoPointAttempt());

		return json;
	}
	
	public static JSONObject statsToJSONSimplify (StatsSeason stats){	
		JSONObject json = new JSONObject();

		json.put("team", stats.getTeam().toString());


		return json;
	}
	
}
