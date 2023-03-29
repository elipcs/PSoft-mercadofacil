package com.ufcg.psoft.mercadofacil.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de Produto")
public class ProdutoV1Controller {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    Produto produto;

    @BeforeEach
    void setup() {
        produto = Produto.builder()
                .id(10L)
                .codigoBarra("7899137500104")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build();
    }

    @Test
    @DisplayName("Quando altero o nome do produto com nome válido")
    void alterarNomeDoProdutoValido() throws JsonProcessingException {
        produto.setNome("Chiclete");
        // Act
        String produtoAlteradoJSONString = mockMvc.perform(put("/produtos/" + 10)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn());
        // Assert
        Produto produtoAlterado = objectMapper.readValue(produtoAlteradoJSONString, Produto.nome);
        assertEquals("Chiclete", produtoAlterado.getNome());
        );
    }
}
