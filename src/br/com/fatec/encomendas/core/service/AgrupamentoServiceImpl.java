package br.com.fatec.encomendas.core.service;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.ViewAgruparDAO;
import br.com.fatec.encomendas.api.dto.AgruparDTO;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.fatec.encomendas.api.entity.Ocorrencia;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.fatec.encomendas.api.service.AgrupamentoService;
import br.com.fatec.encomendas.api.service.EncomendaService;
import br.com.fatec.encomendas.api.service.OcorrenciaService;
import br.com.fatec.encomendas.api.service.VeiculoService;
import br.com.fatec.encomendas.api.service.ViagemService;
import br.com.fatec.encomendas.core.converter.AgruparDTOConverter;
import br.com.fatec.encomendas.core.converter.EncomendaDTOConverter;
import br.com.fatec.encomendas.core.converter.OcorrenciaDTOConverter;
import br.com.fatec.encomendas.core.converter.VeiculoDTOConverter;
import br.com.fatec.encomendas.core.converter.ViagemDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class AgrupamentoServiceImpl implements AgrupamentoService {

	private EncomendaService encomendaService;
	private EncomendaDTOConverter encomendaDTOConverter;
	private ViagemService viagemService;
	private ViagemDTOConverter viagemDTOConverter;
	private VeiculoService veiculoService;
	private VeiculoDTOConverter veiculoDTOConverter;
	private AgruparDTOConverter agruparDTOConverter;
	private ViewAgruparDAO viewAgruparDAO;
	private OcorrenciaService ocorrenciaService;
	private OcorrenciaDTOConverter ocorrenciaDTOConverter;

	public AgrupamentoServiceImpl() {
		this.encomendaService = ImplFinder.getImpl(EncomendaService.class);
		this.viagemService = ImplFinder.getImpl(ViagemService.class);
		this.encomendaDTOConverter = ImplFinder.getFinalImpl(EncomendaDTOConverter.class);
		this.viagemDTOConverter = ImplFinder.getFinalImpl(ViagemDTOConverter.class);
		this.veiculoService = ImplFinder.getImpl(VeiculoService.class);
		this.veiculoDTOConverter = ImplFinder.getFinalImpl(VeiculoDTOConverter.class);
		this.agruparDTOConverter = ImplFinder.getFinalImpl(AgruparDTOConverter.class);
		this.viewAgruparDAO = ImplFinder.getImpl(ViewAgruparDAO.class);
		this.ocorrenciaService = ImplFinder.getImpl(OcorrenciaService.class);
		this.ocorrenciaDTOConverter = ImplFinder.getFinalImpl(OcorrenciaDTOConverter.class);
	}

	// importante voltar com agrupar para tela
	public boolean agrupar() {
		List<Viagem> viagens = Lists.newArrayList();
		List<Ocorrencia> ocorrenciasSalvar = Lists.newArrayList();
		List<Veiculo> veiculos = veiculoDTOConverter.toEntity(veiculoService.listar());
		boolean viagemExistente = false;
		int encomendasAguardando = 0;
		for (Encomenda e : encomendaDTOConverter.toEntity(encomendaService.listar())) {
			if (e.getStatus().equals("aguardando")) {
				encomendasAguardando++;
				for (Viagem v : viagens) {
					if (e.getUsuario().getEndereco().getZona().equals(v.getVeiculo().getZona())) {
						ocorrenciasSalvar.add(criarOcorrencia(e, v));
						viagemExistente = true;
					}
				}
				if (!viagemExistente) {
					for (Veiculo v : veiculos) {
						if (e.getUsuario().getEndereco().getZona().getId().equals(v.getZona().getId())) {
							Viagem viagem = criarViagem(v);
							ocorrenciasSalvar.add(criarOcorrencia(e, viagem));
						}
					}
				}
				viagemExistente = false;
				e.setStatus("viagem");
				encomendaService.atualizar(encomendaDTOConverter.toDTO(e));
			}
		}
		if (encomendasAguardando == 0)
			return false;
		return true;
	}

	private Viagem criarViagem(Veiculo veiculo) {
		Viagem viagem = new Viagem(null, veiculo, new Date());
		return viagemDTOConverter.toEntity(viagemService.salvar(viagemDTOConverter.toDTO(viagem)));
	}

	private Ocorrencia criarOcorrencia(Encomenda encomenda, Viagem viagem) {
		Ocorrencia ocorrencia = new Ocorrencia(null, encomenda, viagem, "Encomenda separada para transporte",
				new Date(), "viagem");
		return ocorrenciaDTOConverter.toEntity(ocorrenciaService.salvar(ocorrenciaDTOConverter.toDTO(ocorrencia)));
	}

	@Override
	public List<AgruparDTO> listar() {
		return this.agruparDTOConverter.toDTO(this.viewAgruparDAO.findAll());
	}
}
