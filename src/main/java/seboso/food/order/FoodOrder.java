// Main //
// ///////

package seboso.food.order;

public class FoodOrder {
    public static void main(String[] args) {
        EstadoApp estado = new EstadoApp();

        while (estado.telaAtual != EstadoApp.Tela.SAIR) {
            switch (estado.telaAtual) {
                case TELA_INICIAL -> Telas.TelaInicial(estado);
                case NOVO_PEDIDO -> Telas.NovoPedido(estado);
                case LISTA_PEDIDOS -> Telas.ListaPedidos(estado);
                case TELA_CARDAPIO -> Telas.TelaCardapio(estado);
                case VER_PEDIDO -> Telas.VerPedido(estado);
                case TELA_PAGAMENTO -> Telas.TelaPagamento(estado);
            }
        }
    }
}
