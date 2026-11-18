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

## Checklist obrigatório:

- **Abstração & Encapsulamento Rígido:** Todos os atributos de todas as classes devem ter visibilidade private ou protected. Obrigatoriedade de métodos Getters e Setters com validações ativas de integridade (rejeição de valores nulos, vazios ou negativos) e construtores parametrizados.
- **Herança & Classes Abstratas:** Criação de pelo menos uma Superclasse Abstrata (abstract class) atuando como entidade ancestral, e no mínimo 2 Subclasses Concretas derivando dessa superclasse via palavra-chave extends.
- **Polimorfismo (Sobreposição & Sobrecarga):** Uso obrigatório da anotação @Override para reescrever métodos da classe mãe com comportamentos específicos nas subclasses, e criação de métodos sobrecarregados (Overloading) com múltiplas assinaturas.
- **Interfaces (Contratos):** Definição de pelo menos 1 Interface declarando um contrato formal de serviços (ex: Autenticavel, Tributavel, Promocional, Manutenivel, etc.).
- **Agregação & Coleções Dinâmicas:** Implementação do relacionamento de Agregação ('Tem Um') através de uma classe gerenciadora contendo uma lista dinâmica (ArrayList<Superclasse>).
- **Interface de Usuário no Console:** Menu interativo via linha de comando utilizando Scanner e laços de repetição (while/switch) permitindo o cadastro, consulta e execução polimórfica das regras de negócio.
