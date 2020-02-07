package com.sica.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.sica.domain.AreaSusceptivel;
import com.sica.domain.Ativo;
import com.sica.domain.Familia;
import com.sica.domain.Funcionario;
import com.sica.domain.Incidente;
import com.sica.domain.Pessoa;
import com.sica.repository.FuncionarioRepository;
import com.sica.service.dto.NotificacaoEmailDTO;

@Service
public class NotificacaoService {

	private final FuncionarioRepository funcionarioRepository;

	private final RabbitTemplate rabbitTemplate;

	private final Queue notificacaoEmailQueue;

	public NotificacaoService(FuncionarioRepository funcionarioRepository, RabbitTemplate rabbitTemplate,
			Queue notificacaoEmailQueue) {
		this.funcionarioRepository = funcionarioRepository;
		this.rabbitTemplate = rabbitTemplate;
		this.notificacaoEmailQueue = notificacaoEmailQueue;
	}

	public void notificarFuncionarios(Incidente incidente) {
		for (Funcionario funcionario : funcionarioRepository.findAll()) {
			this.rabbitTemplate.convertAndSend(notificacaoEmailQueue.getName(),
					new NotificacaoEmailDTO(funcionario.getPessoa().getEmail(), incidente.getMensagem()));
		}
	}

	public void notificarFamiliasAreasSusceptiveis(Incidente incidente) {
		for (Ativo ativo : incidente.getAtivos()) {
			for (AreaSusceptivel areaSusceptivel : ativo.getAreaSusceptivels()) {
				for (Familia familia : areaSusceptivel.getFamilias()) {
					for (Pessoa pessoa : familia.getPessoas()) {
						if (incidente.getNivelIncidente().isNotificaEmail()) {
							this.rabbitTemplate.convertAndSend(notificacaoEmailQueue.getName(),
									new NotificacaoEmailDTO(pessoa.getEmail(), incidente.getMensagem()));
						}
					}
				}
			}
		}
	}

}
