package br.com.gisele.prevent.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gisele.prevent.domain.Logs;

@Repository
public interface LogRepository extends JpaRepository<Logs, Integer> {
	
//	List<Logs> findByDataLog(Date dataLog);
	
	List<Logs> findByIp(String ip);
	
	List<Logs> findByUserAgent(String userAgent);
}
