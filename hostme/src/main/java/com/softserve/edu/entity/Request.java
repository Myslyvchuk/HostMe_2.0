package com.softserve.edu.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * This class represents request for <code>hosting</code> and is created by <code>author</code>.
 * 
 * @author Lv-117
 */
@Entity
@Table(name = "REQUEST", uniqueConstraints = { @UniqueConstraint(columnNames = { "request_id"}) })
public class Request {
	@Id
	@GeneratedValue
	@Column(name = "request_id", unique = true, nullable = false)
	private Long requestId;
	@Column(name = "status", nullable = false)
	private Status status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "begin_date", nullable = false)
	private Calendar beginDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false)
	private Calendar endDate;
	@Column(name = "notes", length = 800)
	private String notes;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hosting_fk", nullable = false)
	private Hosting hosting;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_fk", nullable = false)
	private User author;

	public Request() {
	}

	public Request(Status status, Calendar beginDate, Calendar endDate, String notes) {
		super();
		this.status = status;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.notes = notes;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Hosting getHosting() {
		return hosting;
	}

	public void setHosting(Hosting hosting) {
		if (this.hosting != hosting)
			this.hosting = hosting;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		if (this.author != author)
			this.author = author;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", status=" + status + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", notes=" + notes + "]";
	}

}
