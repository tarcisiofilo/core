package com.sica.service.dto;

import java.io.Serializable;

public class NotificacaoWhatsappDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707337646630036960L;

	private String to;

	private String msg;

	public NotificacaoWhatsappDTO(String to, String msg) {
		super();
		this.to = to;
		this.msg = msg;
	}

	public NotificacaoWhatsappDTO() {
		super();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
