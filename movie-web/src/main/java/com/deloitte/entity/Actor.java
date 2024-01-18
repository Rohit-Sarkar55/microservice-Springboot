package com.deloitte.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "actors")
public class Actor {
	
	@Id
	@Column(name = "actorId")
	@TableGenerator(name = "act_seq",table="act_seq_tab", pkColumnName = "act_pk",
	valueColumnName = "act-val", pkColumnValue = "act", 
	initialValue = 1001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE , generator = "act_seq")
	private int actorId;
	private String name;
	private int height;
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + name + ", height=" + height + "]";
	}
	
	
	
	
}
