Tabela unidade_hotel:
id_unidade (chave primária)
nome_hotel

Tabela endereco_hotel:
id_endereco (chave primária)
id_unidade (chave estrangeira referenciando unidade_hotel)
pais
cep
estado
bairro

Tabela tipo_quarto:
id_tipo_quarto (chave primária)
descricao (solteiro, casal, etc.)

Tabela quarto:
id_quarto (chave primária)
id_unidade (chave estrangeira referenciando unidade_hotel)
id_tipo_quarto (chave estrangeira referenciando tipo_quarto)
quantidade_total

Tabela acomodacao:
id_acomodacao (chave primária)
id_quarto (chave estrangeira referenciando quarto)
numero_quarto
status (disponível, ocupado, etc.)

Tabela reserva:
id_reserva (chave primária)
id_acomodacao (chave estrangeira referenciando acomodacao)
id_cliente (chave estrangeira referenciando cliente)
data_inicio
data_fim
valor_total

Tabela Cliente
id_cliente (chave primária)
nome
email
cpf
descricao

{
 "nomeCliente":"Edson  belem",
 "checkout":"2024-05-16T14:20:00",
 "formato_acomodacao":"INDIVIDUAL",
 "numeroQuartoReserva":"12",
 "tipo_pagamento":"cartao",
  "quarto":{
     "id_quarto":12,
   "numero_quarto":12,
   "status_acomodacao":"DISPONIVEL"
 }
}
