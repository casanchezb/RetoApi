#Autor: Camilo Sanchez
#language:en

@Rest
Feature: Escenarios de las APIs REST

  @MetodosGET
  Scenario Outline: Validar funcionamiento GET
    Given consumo el servicio con la peticion
      | servicio   | peticion   | url   | endpoint   | metodo   | headers   | body   |
      | <servicio> | <peticion> | <url> | <endpoint> | <metodo> | <headers> | <body> |
    When  verifico el status code
      | statusCode   |
      | <statusCode> |
    Then  verifico la respuesta en el response
      | respuesta   |
      | <respuesta> |

    Examples:
      | servicio         | peticion | url                   | endpoint       | metodo         | headers                       | body | statusCode | respuesta                         |
      | Traer un miembro | OK       | http://localhost:5002 | /api/members/1 | GET BASIC AUTH | Content-Type:application/json |      | 200        | id~1#name~Monil#gender~Female     |
      | Traer un autor   | OK       | http://localhost:5002 | /api/authors/3 | GET BASIC AUTH | Content-Type:application/json |      | 200        | id~3#name~Ajay#age~35#gender~Male |

  @MetodosDELETE
  Scenario Outline: Validar funcionamiento DELETE
    Given consumo el servicio con la peticion
      | servicio   | peticion   | url   | endpoint   | metodo   | headers   | body   |
      | <servicio> | <peticion> | <url> | <endpoint> | <metodo> | <headers> | <body> |
    When  verifico el status code
      | statusCode   |
      | <statusCode> |
    Then  verifico la respuesta en el response
      | respuesta   |
      | <respuesta> |
    Examples:
      | servicio       | peticion   | url                   | endpoint       | metodo            | headers                       | body | statusCode | respuesta                                    |
      | Borrar Miembro | No Content | http://localhost:5002 | /api/members/8 | DELETE BASIC AUTH | Content-Type:application/json |      | 200        | msg~Member with id 8 is deleted successfully |

  @MetodosPUT
  Scenario Outline: Validar funcionamiento PUT Y PATCH
    Given consumo el servicio con la peticion
      | servicio   | peticion   | url   | endpoint   | metodo   | headers   | body   |
      | <servicio> | <peticion> | <url> | <endpoint> | <metodo> | <headers> | <body> |
    When  verifico el status code
      | statusCode   |
      | <statusCode> |
    Then  verifico la respuesta en el response
      | respuesta   |
      | <respuesta> |
    Examples:
      | servicio                     | peticion | url                   | endpoint        | metodo           | headers                       | body                                     | statusCode | respuesta                                     |
      | Actualizar Miembro via PUT   | OK       | http://localhost:5002 | /api/members/5  | PUT BASIC AUTH   | Content-Type:application/json | {"name": "Gabriela", "gender": "Female"} | 200        | msg~Member with id 5 is updated successfully  |
      | Actualizar Usuario via PATCH | OK       | http://localhost:5002 | /api/members/10 | PATCH BASIC AUTH | Content-Type:application/json | {"name": "morpheus"}                     | 200        | msg~Member with id 10 is updated successfully |

  @MetodosPOST
  Scenario Outline: Validar funcionamiento POST
    Given consumo el servicio con la peticion
      | servicio   | peticion   | url   | endpoint   | metodo   | headers   | body   |
      | <servicio> | <peticion> | <url> | <endpoint> | <metodo> | <headers> | <body> |
    When  verifico el status code
      | statusCode   |
      | <statusCode> |
    Then  verifico la respuesta en el response
      | respuesta   |
      | <respuesta> |
    Examples:
      | servicio      | peticion | url                   | endpoint     | metodo          | headers                       | body                                     | statusCode | respuesta                    |
      | Crear Miembro | Created  | http://localhost:5002 | /api/members | POST BASIC AUTH | Content-Type:application/json | {"name": "cristiana","gender": "female"} | 201        | name~cristiana#gender~female |
