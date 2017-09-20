package com.star.sud.paging;
/*created by Sudarshan on 19-09-17*/
import java.io.Serializable;

public class StarFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String key;

	protected Object value;

	protected String type;

	protected StarOperator operator;

	protected Object valueKey;

	public Object getValueKey() {
		return valueKey;
	}

	public void setValueKey(Object valueKey) {
		this.valueKey = valueKey;
	}

	public StarOperator getOperator() {
		return operator;
	}

	public void setOperator(StarOperator operator) {
		this.operator = operator;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public StarFilter() {

	}

	public StarFilter(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public StarFilter(String key, Object value, String fieldType) {
		this.key = key;
		this.value = value;
		this.type = fieldType;
	}

	public StarFilter(String key, Object value, String fieldType, StarOperator operator) {
		this.key = key;
		this.value = value;
		this.type = fieldType;
		this.operator = operator;
	}

	public StarFilter(String key, Object value, Object valueKey, String fieldType, StarOperator operator) {
		this.key = key;
		this.value = value;
		this.valueKey = valueKey;
		this.type = fieldType;
		this.operator = operator;
	}

	public StarFilter key(String key) {
		this.key = key;
		return this;
	}

	public StarFilter value(Object value) {
		this.value = value;
		return this;
	}

	public StarFilter valueKey(String valueKey) {
		this.valueKey = valueKey;
		return this;
	}

	public StarFilter type(String type) {
		this.type = type;
		return this;
	}

	public StarFilter operator(StarOperator operator) {
		this.operator = operator;
		return this;
	}
}
