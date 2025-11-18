import javax.swing.JOptionPane;

public class MainGUI {
    public static void main(String[] args) {
        Frota frota = new Frota();
        
        // Tenta carregar dados antigos ao abrir o programa
        String statusInicial = frota.recuperarEstado();
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema!\n" + statusInicial);

        // Opções do Menu Principal
        String[] opcoes = {
            "Adicionar Veículo", 
            "Listar (Por Preço)", 
            "Remover Antigos", 
            "Salvar & Sair"
        };

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma operação:", 
                "Gestão de Frota (Prova POO)",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opcoes, 
                opcoes[0]
            );

            // Opção 0: Adicionar
            if (escolha == 0) {
                try {
                    String placa = JOptionPane.showInputDialog("Digite a Placa:");
                    if (placa == null || placa.trim().isEmpty()) continue;

                    String modelo = JOptionPane.showInputDialog("Digite o Modelo:");
                    
                    String anoStr = JOptionPane.showInputDialog("Digite o Ano:");
                    int ano = Integer.parseInt(anoStr);
                    
                    String valorStr = JOptionPane.showInputDialog("Valor da Diária (Ex: 100.50):");
                    double valor = Double.parseDouble(valorStr);

                    // O mecânico é transient, não será salvo no .ser
                    Veiculo v = new Veiculo(placa, modelo, ano, valor, "UsuarioLogado");
                    
                    frota.adicionar(v);
                    JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Digite apenas números válidos para Ano e Valor.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } 
            // Opção 1: Listar
            else if (escolha == 1) {
                String relatorio = frota.listarPorPreco();
                JOptionPane.showMessageDialog(null, relatorio);
            } 
            // Opção 2: Remover
            else if (escolha == 2) {
                try {
                    String anoStr = JOptionPane.showInputDialog("Remover veículos anteriores ao ano:");
                    if (anoStr != null) {
                        int ano = Integer.parseInt(anoStr);
                        String resultado = frota.removerVeiculosAntigos(ano);
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ano inválido.");
                }
            } 
            // Opção 3 ou Fechar Janela: Salvar e Sair
            else if (escolha == 3 || escolha == -1) {
                try {
                    frota.salvarEstadoCompleto(); // Serialização
                    frota.gerarRelatorioTexto();  // Arquivo Texto
                    JOptionPane.showMessageDialog(null, "Dados salvos em disco. Encerrando...");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro crítico ao salvar: " + e.getMessage());
                }
                System.exit(0);
            }
        }
    }
}