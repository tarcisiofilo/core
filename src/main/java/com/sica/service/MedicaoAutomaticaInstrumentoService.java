package com.sica.service;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sica.domain.MedicaoInstrumento;
import com.sica.repository.InstrumentoMonitoramentoRepository;
import com.sica.repository.MedicaoInstrumentoRepository;

@Service
public class MedicaoAutomaticaInstrumentoService {

	@Autowired
	private InstrumentoMonitoramentoRepository instrumentoMonitoramentoRepository;

	@Autowired
	private MedicaoInstrumentoRepository medicaoInstrumentoRepository;

	@Transactional
	public void salvarMedicao(Double valor, String identificador) {
		MedicaoInstrumento medicaoInstrumento = new MedicaoInstrumento();
		medicaoInstrumento
				.setInstrumentoMonitoramento(instrumentoMonitoramentoRepository.findByIdentificao(identificador));
		medicaoInstrumento.setValor(valor);
		medicaoInstrumento.setData(ZonedDateTime.now());
		medicaoInstrumentoRepository.save(medicaoInstrumento);
	}

}
