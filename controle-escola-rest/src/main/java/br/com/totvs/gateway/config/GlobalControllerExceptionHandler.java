package br.com.totvs.gateway.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({IllegalArgumentException.class})
	public Map<String, Object> IllegalArgumentException(Exception ex) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("erro", true);
		mapa.put("mensagem", ex.getMessage());
		return mapa;

	}

}
