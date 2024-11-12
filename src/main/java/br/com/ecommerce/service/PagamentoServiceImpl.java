package br.com.ecommerce.service;

import br.com.ecommerce.dto.PagamentoDTO;
import br.com.ecommerce.model.PagamentoModel;
import br.com.ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public PagamentoDTO salvar(PagamentoDTO pagamentoDTO) {
        PagamentoModel pagamentoModel = toPagamentoModel(pagamentoDTO);
        PagamentoModel savedPagamento = pagamentoRepository.save(pagamentoModel);
        return toPagamentoDTO(savedPagamento);
    }

    @Override
    public Optional<PagamentoDTO> buscarPorId(Long id) {
        return pagamentoRepository.findById(id).map(this::toPagamentoDTO);
    }

    @Override
    public List<PagamentoDTO> listarTodos() {
        return pagamentoRepository.findAll().stream().map(this::toPagamentoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    private PagamentoDTO toPagamentoDTO(PagamentoModel pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(pagamento.getId());
        dto.setValor(pagamento.getValor());
        dto.setData(pagamento.getData());
        dto.setStatus(pagamento.getStatus());
        return dto;
    }

    private PagamentoModel toPagamentoModel(PagamentoDTO dto) {
        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setId(dto.getId());
        pagamento.setValor(dto.getValor());
        pagamento.setData(dto.getData());
        pagamento.setStatus(dto.getStatus());
        return pagamento;
    }
}
