package com.star.sud.paging;
/*created by Sudarshan on 19-09-17*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarPageResultList {

	protected int end;

	protected int page = 1;

	protected int totalRecords = 0;

	protected int totalPages = 1;

	protected int recordsPerPage = 10;

	protected List<Object> entityList;

	protected String currentFilter;

	protected Map<String, StarFilter> filters = new HashMap<String, StarFilter>();

	protected List<StarFilter> filterList = new ArrayList<StarFilter>();

	protected String auditableFilter = "";

	protected String sortField;

	protected String sort = "ASC";

	protected int start = 1;

	public String getCurrentFilter() {
		return currentFilter;
	}

	public void setCurrentFilter(String currentFilter) {
		this.currentFilter = currentFilter;
	}

	public Map<String, StarFilter> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, StarFilter> filters) {
		this.filters = filters;
	}

	public Map<String, StarFilter> getFilterListAsMap() {
		Map<String, StarFilter> filterMap = filters;
		for (StarFilter filter : filterList) {
			filterMap.put(filter.getKey(), filter);
		}
		return filterMap;

	}

	public List<StarFilter> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<StarFilter> filterList) {
		this.filterList = filterList;
	}

	public String getAuditableFilter() {
		return auditableFilter;
	}

	public void setAuditableFilter(String auditableFilter) {
		this.auditableFilter = auditableFilter;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		if (totalRecords > 0) {
			int tmp = totalRecords / this.recordsPerPage;
			int rem = totalRecords % this.recordsPerPage;
			if (rem > 0)
				tmp++;
			setTotalPages(tmp);
			setEndVal();
		}

	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	private void setEndVal() {
		int rec = this.page * this.recordsPerPage;
		if (this.totalRecords < rec)
			setEnd(this.totalRecords);
		else
			setEnd(rec);
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Boolean getHasNext() {
		Boolean hashNext = Boolean.FALSE;
		if (this.totalPages > this.page)
			hashNext = Boolean.TRUE;
		return hashNext;

	}

	public Boolean getHasFirst() {
		Boolean hashFirst = Boolean.FALSE;
		if (this.page > 1)
			hashFirst = Boolean.TRUE;
		return hashFirst;
	}

	public Boolean getHasPrevious() {

		Boolean hasPrevious = Boolean.FALSE;
		if (this.page > 1)
			hasPrevious = Boolean.TRUE;

		return hasPrevious;

	}

	public Boolean getHasLast() {
		Boolean hasLast = Boolean.FALSE;
		if (this.totalPages > this.page)
			hasLast = Boolean.TRUE;
		return hasLast;

	}

	public List<Object> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Object> entityList) {
		this.entityList = entityList;
	}

}
