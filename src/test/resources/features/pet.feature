# language: pt

Funcionalidade: Gerenciamento de um pet da PetSore

  Alguma contexto de negócio


  Cenario: Lista somente pets disponíveis para a venda
    Dado que eu possua pets available
    Quando eu pesquiso por todos os pets available
    Então eu recebo a lista com 7 pets
    E possuo 3 animais available com o nome Lion

  Cenario: Lista somente pets pending
    Dado que eu possua pets pending
    Quando eu pesquiso por todos os pets pending
    Então eu recebo a lista com 2 pets

  Cenario: Lista somente pets sold
    Dado que eu não possua pet sold
    Quando eu pesquiso por todos os pets sold
    Então eu recebo a lista com 0 pet

  Esquema do Cenario: Pesquisa pelo status do pet
    Quando eu pesquiso por pets <estado>
    Então eu recebo status <httpStatus>

    Exemplos: Pesquisa válida
      | estado    | httpStatus |
      | available | 400        |
      | pending   | 200        |
      | sold      | 200        |

    Exemplos: Pesquisa inválida
      | estado        | httpStatus |
      | qualquercoisa | 400        |
      | &*ˆˆ#         | 400        |
