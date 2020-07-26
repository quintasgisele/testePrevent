package br.com.gisele.prevent.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gisele.prevent.domain.Logs;
import br.com.gisele.prevent.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository repLog;

	@Override
	public String lerLogs() {
		File arqLog = new File("access.log");

		try {
			FileReader fr = new FileReader(arqLog);
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
				String[] logRetorno = linha.split("\\|");
				
				Logs logs = new Logs();
				
				Date dataRetorno;
				try {
					dataRetorno = sdf.parse(logRetorno[0]);
					logs.setDataLog(dataRetorno);
					logs.setIp(logRetorno[1]);
					logs.setRequest(logRetorno[2]);
					logs.setStatus_log(Integer.parseInt(logRetorno[3]));
					logs.setUserAgent(logRetorno[4]);
					salvarLogs(logs);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}

			fr.close();
			br.close();
			return "procOk";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@Override
	public void salvarLogs(Logs logsPrevent) {
		repLog.save(logsPrevent);
	}
		
	@Override
	public Logs filtrarLog(Integer id) {
		throw new IllegalArgumentException("Identificador inválido:" + id);
	}

//	@Override
//	public List<Logs> filtrarData(Date dataLog) {
//		return repLog.findByDataLog(dataLog);
//	}
	
	@Override
	public List<Logs> filtrarIp(String ip) {
		return repLog.findByIp(ip);
	}

	@Override
	public List<Logs> findByUserAgent(String userAgent) {
		return repLog.findByUserAgent("\""+userAgent+"\"");
	}
}
