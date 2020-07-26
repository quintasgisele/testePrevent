package br.com.gisele.prevent.controller;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.log.Log;

import br.com.gisele.prevent.domain.Logs;
import br.com.gisele.prevent.service.LogService;
import br.com.gisele.prevent.vo.LogsVo;

@Controller
@RequestMapping("/logs/")
public class PreventController {

	@Autowired
	private LogService logService;

	@PostMapping(value = "/inserirDados")
	public @ResponseBody String inserirDados(@RequestBody LogsVo logs_prevent) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date dataRetorno = sdf.parse(logs_prevent.getData_log());

		Logs log = new Logs();
		log.setDataLog(dataRetorno);
		log.setIp(logs_prevent.getIp());
		log.setRequest(logs_prevent.getRequest());
		log.setStatus_log(logs_prevent.getStatus_log());
		log.setUserAgent(logs_prevent.getUserAgent());

		logService.salvarLogs(log);
		return "dados inseridos com sucesso";
	}

	@GetMapping(value = "/lerDados")
	public String lerDados() throws IOException {
		return logService.lerLogs();
	}
	
//	@PostMapping("/listar")
//	public @ResponseBody List<Logs> filtrarLog(@RequestBody LogsVo logs_prevent) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date dataRetorno = sdf.parse(logs_prevent.getData_log());
//		
//		return logService.filtrarData(dataRetorno);
//	}
	
	@PostMapping("/listarPorIp")
	public @ResponseBody List<Logs> filtrarPorIp(@RequestBody LogsVo logs_prevent) throws ParseException {
				
		return logService.filtrarIp(logs_prevent.getIp());
	}

	@PostMapping("/listarPorUserAgent")
	public @ResponseBody List<Logs> filtrarPorUserAgent(@RequestBody LogsVo logs_prevent) throws ParseException {
				
		return logService.findByUserAgent(logs_prevent.getUserAgent());
	}
}
