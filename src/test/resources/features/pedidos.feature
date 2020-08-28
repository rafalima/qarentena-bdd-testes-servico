# language: pt

Funcionalidade: Gerenciamento de pedidos

  @DeletaPetsExtra @sanidade
  Cenario: Cliente cria um pedido na loja
    Dado que eu possua pet available para compra
    Quando faço o pedido de um pet
    Então o pedido é aprovado