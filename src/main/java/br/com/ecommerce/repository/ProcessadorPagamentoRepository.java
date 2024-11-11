package br.com.ecommerce.repository;

import br.com.ecommerce.model.ProcessadorPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessadorPagamentoRepository extends JpaRepository<ProcessadorPagamentoModel, Long> {
}
