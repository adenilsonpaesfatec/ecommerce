package br.com.ecommerce.repository;

import br.com.ecommerce.model.MetodoPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamentoModel, Long> {
}
