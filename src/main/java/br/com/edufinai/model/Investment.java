package br.com.edufinai.model;
/**
 * Representa um investimento financeiro no sistema EduFinAI.
 *
 * Responsabilidades:
 * - Armazenar dados básicos do investimento (nome, valor inicial e taxa).
 * - Permitir a simulação de retorno financeiro em meses futuros.
 *
 * Observações:
 * - A taxa de retorno é informada em decimal (ex.: 0.05 = 5% ao mês).
 * - O cálculo utiliza juros compostos.
 *
 * Exemplo de uso:
 * - Criar um investimento de R$ 1000,00 com taxa de 5% ao mês.
 * - Simular o valor após 12 meses.
 */
public class Investment {
        private Long id;
        private String name;
        private double initialValue;
        private double rate;

    public Investment(Long id, String name, double initialValue, double rate) {
        this.id = id;
        this.name = name;
        this.initialValue = initialValue;
        this.rate = rate;
    }
    /**
     * Simula o retorno do investimento após um número de meses,
     * aplicando juros compostos.
     *
     * Fórmula: valorFinal = valorInicial * (1 + taxa) ^ meses
     *
     * @param months número de meses da simulação
     * @return valor projetado após os meses informados
     */
    public double simulateReturn(int months) {
        return initialValue * Math.pow(1 + rate, months);
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    /**
     * Retorna uma representação textual do investimento,
     * incluindo id, nome, valor inicial e taxa.
     *
     * @return string formatada com os dados principais
     */
    @Override
    public String toString() {
        return "Investment {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initialValue=" + initialValue +
                ", rate=" + rate +
                '}';
    }
}
