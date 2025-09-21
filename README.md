# AULA 3
##### *Fotos de comprovação de cada atividade estão na pasta 'FotosComprovaçãoAula3'*
---
### Exercicio 1:
1. Primeiramente criei no **repositório** o método **findByNomeContainingIgnoreCase** que ensina o programa a buscar no banco de dados todos os contatos com um nome específico.
*Obs: Eu usei o método findByNomeContainingIgnoreCase porque ele deixa a busca mais inteligente, diferente do findByNome normal, afinal ele não liga para letras maiusculas e minusculas e permite pesquisar por partes do nome.*
2. Ai, no **controller**, criei o método **@GetMapping("/search")** cria a URL pública para essa busca, pegando o nome do usuário digitado na URL e usando o repositorio para encontra-lo.
##### Resumindo: O Controller cria a URL, e o Repositório faz a busca.
---
### Exercicio 2:
1. Eu criei o método **@PatchMapping("/{id}")** que inicialmente pega o id da URL com **findById** para achar o contato que já está salvo no banco/repositório.
2. Em seguida vem 3 if's, que cuidam de cada situação dependendo do que o usuário mandar, atualizando parcialmente o usuário em questão(caso seja o caso) .
3. por fim, **save(existingContact)** para salvar as alterações.
---
### Exercicio 3:
##### 1. Diferença REST vs. SOAP:
O REST é um jeito mais simples de fazer APIs, usando JSON e os comandos da web (GET, POST). O SOAP é um protocolo mais antigo e burocrático que obriga o uso de XML.
##### 2. Onde o SOAP ainda é usado:
O SOAP ainda é usado em sistemas que precisam de segurança e regras muito rígidas, como bancos ou sistemas antigos do governo.
##### 3. Vantagens do REST:
A vantagem do REST é que ele é mais leve, rápido e fácil. A desvantagem é que nós temos que montar a segurança, diferente do SOAP que já vem com mais coisas prontas.
*Obs: Para web e mobile, REST é o padrão porque é mais simples.*
##### 4. WS-Security vs. Segurança REST:
O WS-Security é o padrão de segurança que já vem embutido no SOAP. No REST, a gente combina outras ferramentas para ter segurança, como HTTPS e Tokens.
*Obs: A segurança do SOAP vem "de fábrica", a do REST a gente "monta".*
##### 5. Modelo de Richardson:
É um modelo que classifica o "nível de qualidade" de uma API REST, indo do 0 ao 3.
Funcionando assim:
A gente sai de um "túnel" único (Nível 0), passa a organizar em "gavetas" (Nível 1), depois usa "etiquetas" de ação (GET, POST) nessas gavetas (Nível 2), e por fim, a própria gaveta te dá um "mapa" do que fazer a seguir (Nível 3).
##### 6. O que é GraphQL:
###### É uma alternativa ao REST. Em vez de vários endpoints, o GraphQL tem um só, e é o cliente que decide quais campos ele quer receber na resposta.
######*Obs: No REST, o servidor sempre manda o contato inteiro. No GraphQL, o cliente pode pedir "me manda só o nome", e o servidor manda só o nome.*
---
### Desafio 1:
1. Primeiro, eu criei o Model **Address.java** com todos os seus campos. A parte mais importante foi configurar a relação entre as tabelas:
- Na classe Address, usei a anotação *@ManyToOne* pra dizer que muitos endereços podem pertencer a um contato.
- Na classe Contact, usei *@OneToMany* pra dizer que um contato pode ter uma lista de endereços.
2. Depois, criei o **AddressRepository**, que herda do JpaRepository, para o programa saber como salvar, buscar e apagar os endereços no banco de dados.
3. Por fim, criei os novos endpoints. A parte principal foi no ContactController, onde adicionei as rotas para gerenciar os endereços de um contato específico:
- **GET /api/contacts/{id}/addresses:** Para listar todos os endereços daquele contato.
- **POST /api/contacts/{id}/addresses:** Para adicionar um endereço novo para aquele contato.
4. Também criei um **AddressController** novo para gerenciar endereços de forma geral (como listar todos), separando bem as responsabilidades da API.
---
### Desafio 2:
