# language: pt

Funcionalidade: Gerenciamento de um user da PetSore

  Algum contexto de négocio

  Cenario: Cria um user na loja
    Quando eu faço um POST para /v3/user com o seguintes valores:
      | id         | 10               |
      | username   | rafael           |
      | firstName  | Rafael           |
      | lastName   | Lima             |
      | email      | rafael@email.com |
      | password   | 12345            |
      | phone      | 12345            |
      | userStatus | 1                |
    Então quando faço um GET para /v3/user/rafael então o usuário criado é retornado

  Cenario: Cria um user na loja com docstring
    Quando eu faço um POST para /v3/user com o docstring:
      """json
      {
        "id": 10,
        "username": "theUser",
        "firstName": "John",
        "lastName": "James",
        "email": "john@email.com",
        "password": "12345",
        "phone": "12345",
        "userStatus": 1
      }
      """
    Então quando faço um GET para /v3/user/theUser então o usuário criado é retornado


  Cenario: Cria um user menos verboso
    Quando crio um user
    Então recebo status code 200
      E o user criado foi cadastrado