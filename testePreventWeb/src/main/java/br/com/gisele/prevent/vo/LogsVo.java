package br.com.gisele.prevent.vo;

public class LogsVo {

	private Integer id_prevent;
	private String data_log;
	private String ip;
	private String request;
	private Integer status_log;
	private String userAgent;

	public Integer getId_prevent() {
		return id_prevent;
	}

	public void setId_prevent(Integer id_prevent) {
		this.id_prevent = id_prevent;
	}


	public String getData_log() {
		return data_log;
	}

	public void setData_log(String data_log) {
		this.data_log = data_log;
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

}
