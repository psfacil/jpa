package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado(String uf) {
		return em.createNativeQuery(
			"select * from cidade where uf = :e",
			Cidade.class)
			.setParameter("e", uf)
			.getResultList();
	}

}






