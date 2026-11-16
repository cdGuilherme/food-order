# food-order

## Classes principais do sistema

Classe:

Comanda - qtd Produto e produto, mesa ou delivery, sobremesa, adicionais, num do pedido
Cliente - nome, endereço
Cozinha - Setor


Produto - Classe abstrata que representa os produtos do cardápio.
PratoPrincipa - Representa pratos principais, como hambúrgueres e pizzas.
Bebida - Representa bebidas e seus tamanhos (P, M e G).
Sobremesa -	Representa sobremesas e opções sem açúcar.
Adicional -	Representa adicionais dos pratos, como bacon e queijo.
2. Classes de pedidos
Classe - Responsabilidade
Pedido - Armazena os itens solicitados pelo cliente.
ItemPedido - Representa um produto dentro do pedido e sua quantidade.
Comanda - Gera e organiza as informações do pedido para a cozinha.
Cliente - Armazena os dados do cliente.
3. Classes de preparo e cozinha
Classe - Responsabilidade
SetorCozinha -	Classe abstrata que representa um setor de preparo.
Grelha - Responsável pelo preparo dos pratos principais.
Bar - Responsável pelo preparo das bebidas.
Confeitaria - Responsável pelo preparo das sobremesas.
InstrucaoPreparo -	Gera as instruções específicas para cada produto.
4. Classes de entrega e pagamento
Classe	Responsabilidade
Entrega	Armazena informações da entrega e distância.
Pagamento	Representa as informações do pagamento.