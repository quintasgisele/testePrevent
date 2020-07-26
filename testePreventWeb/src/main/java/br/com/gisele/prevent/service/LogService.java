package br.com.gisele.prevent.service;

import java.util.List;

import br.com.gisele.prevent.domain.Logs;

public interface LogService {
	
	String lerLogs();
	
	void salvarLogs(Logs logsPrevent);

//	List<Logs> filtrarData(Date data_log);

	Logs filtrarLog(Integer id);

	List<Logs> filtrarIp(String ip);
		
	List<Logs> findByUserAgent(String userAgent);
}
