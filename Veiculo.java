import java.io.Serializable;
import java.util.Objects;

// [PDF 27] Implementa Serializable para permitir persistência de objetos
// [PDF 23] Implementa Comparable para definir a Ordenação Natural
public class Veiculo implements Serializable, Comparable<Veiculo> {
    
    // [PDF 27] Versionamento da classe serializada (boa prática)
    private static final long serialVersionUID = 1L;

    private String placa;
    private String modelo;
    private int ano;
    private double valorDiaria;
    
    // [PDF 27] 'transient' indica que este campo será ignorado na serialização
    private transient String ultimoMecanico; 

    public Veiculo(String placa, String modelo, int ano, double valorDiaria, String mecanico) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.ultimoMecanico = mecanico;
    }

    // Getters necessários para os comparators e relatórios
    public String getPlaca() { return placa; }
    public double getValorDiaria() { return valorDiaria; }
    public int getAno() { return ano; }
    public String getModelo() { return modelo; }

    // [PDF 25] Sobrescrita do equals() para Igualdade Lógica baseada na PLACA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Igualdade de referência
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    // [PDF 25] Sempre que sobrescreve equals, sobrescreva hashCode
    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    // [PDF 23] compareTo define a ordem natural (pela Placa)
    @Override
    public int compareTo(Veiculo outro) {
        return this.placa.compareTo(outro.placa);
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Modelo: " + modelo + " | R$ " + valorDiaria + 
               " | Mecânico: " + (ultimoMecanico == null ? "N/A" : ultimoMecanico);
    }
}