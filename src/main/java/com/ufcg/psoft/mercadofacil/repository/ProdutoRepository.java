package com.ufcg.psoft.mercadofacil.repository;

public interface ProdutoRepository<T, ID> {
    T find(ID id);

    T update(T produto);
}
