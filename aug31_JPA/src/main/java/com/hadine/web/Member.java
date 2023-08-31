package com.hadine.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "jmembers")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	
	@Column(length = 10)
	private String m_name;
	
	@Column(name="m_id", unique = true)
	private String m_id;
	
	
	private String m_pw;
	
	@Column(columnDefinition = "TIMESTAMP")
	private String m_joindate;
	
}
