#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@featureTest
Feature: Uso de cucumber en el que se va a probar el funcionamiento 
de una red social.

@Scenario1
Scenario: Login correcto de un usuario
Given Un usuario y password 
When usuario correcto y password correcta
Then se loguea

@Scenario2
Scenario: Login incorrecto de un usuario
Given Un usuario y password
When Usuario incorrecto y una password incorrecta
Then no se loguea

@Scenario3
Scenario: Registro correcto de un usuario
Given Un nombre, un email, una pwduno y una pwddos
When pwduno es igual a pwddos
Then se registra

@Scenario4
Scenario: Registro incorrecto de un usuario
Given Un nombre, un email, una pwduno y una pwddos
When pwduno es distinto a pwddos
Then no se registra

@Scenario5
Scenario: Registro incorrecto de un usuario
Given Un nombre, un email, una pwduno y una pwddos
When email ya esta en la base de datos
Then no se registra
