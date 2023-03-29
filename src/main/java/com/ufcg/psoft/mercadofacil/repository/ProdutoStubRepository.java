package com.ufcg.psoft.mercadofacil.repository;

public class ProdutoStubRepository<Produto, Long> implements ProdutoRepository<Produto, Long> {
    @Override
    public Produto find(Long l) {
        return null;
    }

    @Override
    public Produto update(Produto produto) {
        if (produto.getId() == 10L) {
            return Produto.builder()
                    .id(10L)
                    .codigoBarra("7899137500104")
                    .nome("Chiclete")
                    .fabricante("Empresa Dez Alterado")
                    .preco(450.00)
                    .build();
        }
    }
}
