package com.edu.abhi.algorithm.linkedlist.my2;

public class Link {
	private Integer id;
	private String name;
	private Link nextLink;
	
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
	public Link getNextLink() {
		return nextLink;
	}
	public void setNextLink(Link nextLink) {
		this.nextLink = nextLink;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + "]";
	}
	public Link(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
