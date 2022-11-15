package com.example.demo.handler;

public class CampoObrigatorioException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException(String campo) {
		super("O campo %s é obrigatório!", campo);
	}
}
