package com.edu.abhi.algorithm.linkedlist.my2;

public class DLink {
	private Integer id;
	private String name;
	private DLink nextLink;
	private DLink preLink;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public DLink getNextLink() {
		return nextLink;
	}
	public void setNextLink(DLink nextLink) {
		this.nextLink = nextLink;
	}
	public DLink getPreLink() {
		return preLink;
	}
	public void setPreLink(DLink preLink) {
		this.preLink = preLink;
	}
	public DLink(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "DLink [id=" + id + ", name=" + name + "]";
	}
	
	
}
