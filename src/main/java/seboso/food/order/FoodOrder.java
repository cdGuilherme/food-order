// Main

package seboso.food.order;

public class FoodOrder {
    public static void main(String[] args) {
        // Objeto para armazenar as variáveis globais e funcionamento da state machine
        EstadoApp estado = new EstadoApp();

        // Loop principal de execução do programa e suas telas
        while (estado.telaAtual != EstadoApp.Tela.SAIR) {
            switch (estado.telaAtual) {
                case TELA_INICIAL -> Telas.TelaInicial(estado);
                case NOVO_PEDIDO -> Telas.NovoPedido(estado);
                case TELA_ENDERECO -> Telas.TelaEndereco(estado);
                case TELA_CARDAPIO -> Telas.TelaCardapio(estado);
                case VER_PEDIDO -> Telas.VerPedido(estado);
                case TELA_PAGAMENTO -> Telas.TelaPagamento(estado);
                case LISTA_PEDIDOS -> Telas.ListaPedidos(estado);
                case DETALHES_PEDIDO -> Telas.DetalhesPedido(estado);
                case COZINHA -> Telas.Cozinha(estado);
                case DETALHES_COZINHA -> Telas.DetalhesCozinha(estado);
            }
        }
    }
}
