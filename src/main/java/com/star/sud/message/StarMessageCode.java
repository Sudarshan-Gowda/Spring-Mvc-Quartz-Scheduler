package com.star.sud.message;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StarMessageCode {

	private static final Map<String, StarMessageCode> TYPES = new LinkedHashMap<String, StarMessageCode>();

	public static final StarMessageCode INFORMATION = new StarMessageCode("INFORMATION", " Information.");

	public StarMessageCode() {
	}

	public static StarMessageCode getInstance(final String type) {
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

	public StarMessageCode(String type, String friendlyType) {
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
		StarMessageCode other = (StarMessageCode) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static List<StarMessageCode> getList() {
		List<StarMessageCode> list = new ArrayList<StarMessageCode>(TYPES.values());
		return list;
	}
}
