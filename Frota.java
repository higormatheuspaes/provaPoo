import java.io.*;
import java.util.*;

public class Frota {
    // Mapa para busca rápida por Placa (PDF 24)
    private Map<String, Veiculo> mapaVeiculos;
    private final String PASTA_DADOS = "dados_frota";

    public Frota() {
        this.mapaVeiculos = new HashMap<>();
        prepararDiretorio();
    }

    // Garante que a pasta de arquivos exista (PDF 26)
    private void prepararDiretorio() {
        File diretorio = new File(PASTA_DADOS);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    public void adicionar(Veiculo v) throws Exception {
        if (mapaVeiculos.containsKey(v.getPlaca())) {
            throw new Exception("Erro: Veículo com esta placa já existe!");
        }
        mapaVeiculos.put(v.getPlaca(), v);
    }

    // Remove itens usando Iterator para evitar erro de concorrência (PDF 22)
    public String removerVeiculosAntigos(int anoCorte) {
        int removidos = 0;
        Iterator<Veiculo> it = mapaVeiculos.values().iterator();
        
        while (it.hasNext()) {
            Veiculo v = it.next();
            if (v.getAno() < anoCorte) {
                it.remove();
                removidos++;
            }
        }
        return removidos + " veículos antigos removidos com sucesso.";
    }

    // Ordenação Artificial por Preço usando Comparator (PDF 23)
    public String listarPorPreco() {
        if (mapaVeiculos.isEmpty()) return "A frota está vazia.";

        List<Veiculo> lista = new ArrayList<>(mapaVeiculos.values());
        
        // Expressão Lambda para o Comparator
        Collections.sort(lista, (v1, v2) -> Double.compare(v1.getValorDiaria(), v2.getValorDiaria()));

        StringBuilder sb = new StringBuilder();
        sb.append("--- Frota Ordenada (Menor Preço) ---\n");
        for (Veiculo v : lista) {
            sb.append(v.toString()).append("\n");
        }
        return sb.toString();
    }

    // Persistência em Texto (PDF 28)
    public void gerarRelatorioTexto() throws FileNotFoundException {
        File arquivo = new File(PASTA_DADOS, "relatorio.txt");
        try (PrintWriter writer = new PrintWriter(arquivo)) {
            writer.println("RELATÓRIO GERAL DA FROTA");
            writer.println("------------------------");
            for (Veiculo v : mapaVeiculos.values()) {
                writer.println(v.toString());
            }
        }
    }

    // Serialização: Salva o objeto MAP inteiro (PDF 27)
    public void salvarEstadoCompleto() throws IOException {
        File arquivo = new File(PASTA_DADOS, "frota.ser");
        try (FileOutputStream fos = new FileOutputStream(arquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(mapaVeiculos);
        }
    }

    // Desserialização: Recupera o objeto MAP (PDF 27)
    @SuppressWarnings("unchecked")
    public String recuperarEstado() {
        File arquivo = new File(PASTA_DADOS, "frota.ser");
        if (!arquivo.exists()) return "Nenhum backup encontrado. Iniciando nova frota.";

        try (FileInputStream fis = new FileInputStream(arquivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            this.mapaVeiculos = (HashMap<String, Veiculo>) ois.readObject();
            return "Dados recuperados! Total de veículos: " + mapaVeiculos.size();
            
        } catch (Exception e) {
            return "Falha ao recuperar backup: " + e.getMessage();
        }
    }
}