# language: pt

Funcionalidade: Gerenciamento de um pet da PetSore

  Alguma contexto de négocio

  @wip
  Cenario: Lista somente pets disponíveis para a venda
    Dado que eu possua pets available para a venda
    Quando eu pesquiso por todos os pets available
    Então eu recebo a lista de pets disponíveis

  Cenario: Lista somente pets pending
    Dado que eu possua pets pending para a venda
    Quando eu pesquiso por todos os pets pending
    Então eu recebo a lista com 2 pets


#    Adicionar esquema de cenário para o dois testes acima
#    Um teste que tem um hashmap de <Status, Qnt>, assim não precisa colocar a quantidade no Então
#    Criar pets (usar json no feature ou builder)
#   Create pets com tags como setup e testar as tags (mostrar isso)
#  Delete Pet e mostrar que alguns testes vão falhar (mostrar uso de hooks com tags)
#  Colocar API KEY
#