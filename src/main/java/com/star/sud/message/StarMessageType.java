package com.star.sud.message;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StarMessageType {
	/*created by Sudarshan on 19-09-17*/
	private static final Map<String, StarMessageType> TYPES = new LinkedHashMap<String, StarMessageType>();

	public static final StarMessageType INFO = new StarMessageType("INFO", "info");
	public static final StarMessageType ERROR = new StarMessageType("ERROR", "danger");
	public static final StarMessageType WARNING = new StarMessageType("WARNING", "warning");
	public static final StarMessageType SUCCESS = new StarMessageType("SUCCESS", "success");

	
	public StarMessageType() {
	}

	public static StarMessageType getInstance(final String type) {
		return TYPES.get(type);
	}

	protected String friendlyType;
	protected String type;

	public String getType() {
		return type;
	}

	private void setType(final String type) {
		this.type = type;
		if (!TYPES.containsKey(type)) {
			TYPES.put(type, this);
		}
	}

	public StarMessageType(String type, String friendlyType) {
		this.friendlyType = friendlyType;
		setType(type);
	}

	public String getFriendlyType() {
		return friendlyType;
	}

	public void setFriendlyType(String friendlyType) {
		this.friendlyType = friendlyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().isAssignableFrom(obj.getClass()))
			return false;
		StarMessageType other = (StarMessageType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static List<StarMessageType> getList() {
		List<StarMessageType> list = new ArrayList<StarMessageType>(TYPES.values());
		return list;
	}
}
