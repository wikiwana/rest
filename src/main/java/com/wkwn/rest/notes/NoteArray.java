package com.wkwn.rest.notes;

import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;


public class NoteArray {
	public static HashMap<String, Note> notes = new HashMap<>();
		
	public static JsonArray toJsonArray() {
		JsonArrayBuilder jsonArray = Json.createArrayBuilder();
		for (Note n : notes.values()) {
			jsonArray.add(n.toJsonObject());
		}
		return jsonArray.build();
    }
	
	public static boolean removeNoteById(String id) { return (notes.remove(id) != null); }
	
	public static boolean updNoteById(String id, String title, String text) {
		if (notes.containsKey(id)) {
			Note n = notes.get(id);
			n.setTitle(title);
			n.setText(text);
			n.refreshUpdateDate();
			return true;
		}
		return false;
	}
}
