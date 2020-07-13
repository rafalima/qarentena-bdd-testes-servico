# language: pt

Funcionalidade: Gerenciamento de um user da PetSore

  Algum contexto de négocio

  Cenario: Cria um user na loja
    Quando eu faço um POST para /user com o seguintes valores:
      | id         | 10               |
      | username   | rafael           |
      | firstName  | Rafael           |
      | lastName   | Lima             |
      | email      | rafael@email.com |
      | password   | 12345            |
      | phone      | 12345            |
      | userStatus | 1                |
    Então quando faço um GET para /user/rafael então o usuário criado é retornado


  Cenario: Cria um user menos verboso
    Quando crio um user
    Então recebo status code 200
      E o user criado foi cadastrado