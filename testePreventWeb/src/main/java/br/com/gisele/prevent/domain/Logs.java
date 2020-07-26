package br.com.gisele.prevent.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prevent_log")
public class Logs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prevent")
	private Integer id_prevent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_log")
	private Date dataLog;

	@Column(name = "ip")
	private String ip;

	@Column(name = "request")
	private String request;

	@Column(name = "status_log")
	private Integer status_log;

	@Column(name = "user_agent")
	private String userAgent;

	public Integer getId_prevent() {
		return id_prevent;
	}

	public void setId_prevent(Integer id_prevent) {
		this.id_prevent = id_prevent;
	}

	public Date getDataLog() {
		return dataLog;
	}

	public void setDataLog(Date dataLog) {
		this.dataLog = dataLog;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Integer getStatus_log() {
		return status_log;
	}

	public void setStatus_log(Integer status_log) {
		this.status_log = status_log;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
