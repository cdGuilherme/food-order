# food-order

## Classes principais do sistema

Classe:

pessoa abstract - nome, endereço, tipo

pessoa - cliente(chamarGarçom), garçom(anotarPedido), cozinheiro(CozinharProximoPedido)

produto abstract - nome, preço, tamanho

produto - lanche, bebida, adicionais

Classe cozinha - cozinheiro, setor(grelha, bar, confeitaria)

interface comanda;

Comanda - cliente, produto e qtd, mesa ou delivery

ArrayList(<comandas>)
