package com.sydevelop.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.sydevelop.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}


