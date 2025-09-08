package br.com.edufinai.service;

import br.com.edufinai.model.*;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de transações financeiras.
 *
 * Responsabilidades:
 * - Registrar transações associadas a usuários.
 * - Gerar relatórios mensais agregando receitas e despesas.
 * - Fornecer acesso à lista de transações registradas.
 *
 * Fluxo típico:
 * - Chamar {@link #registerTransaction(Transaction)} para registrar lançamentos.
 * - Consultar {@link #generateMonthlyReport(User)} para obter relatório textual.
 */
public class GerenciadorFinanceiroService {

    private List<Transaction> transactions = new ArrayList<>();
    /**
     * Registra uma nova transação no sistema.
     *
     * @param t transação a ser registrada
     */
    public void registerTransaction(Transaction t) {
        transactions.add(t);
    }
    /**
     * Gera um relatório mensal das transações de um usuário.
     * O relatório é agrupado por mês/ano e apresenta receitas, despesas e saldo.
     *
     * Regras:
     * - Filtra apenas as transações do usuário informado.
     * - Agrupa pelo mês/ano da data da transação.
     * - Calcula totais de receitas e despesas em cada mês.
     * - Apresenta o saldo (receitas - despesas).
     *
     * Exemplo de saída:
     * <pre>
     * Relatório mensal de Ana:
     *
     * 📅 Mês: 09/2025
     *   ✅ Receitas: R$ 3000.00
     *   ❌ Despesas: R$ 250.00
     *   💰 Saldo: R$ 2750.00
     * </pre>
     *
     * @param user usuário dono das transações
     * @return relatório formatado em String
     */
    public String generateMonthlyReport(User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");

        // Filtrar as transações do usuário e agrupar por mês/ano
        Map<String, List<Transaction>> transacoesPorMes = transactions.stream()
                .filter(t -> t.getUserId().equals(user.getId()))
                .collect(Collectors.groupingBy(t -> t.getDate().format(formatter)));

        // Montar o relatório em String
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório mensal de ").append(user.getName()).append(":\n\n");

        for (String mes : transacoesPorMes.keySet()) {
            relatorio.append("📅 Mês: ").append(mes).append("\n");

            BigDecimal totalReceitas = BigDecimal.ZERO;
            BigDecimal totalDespesas = BigDecimal.ZERO;

            for (Transaction t : transacoesPorMes.get(mes)) {
                if (t.getType() == TransactionType.INCOME) {
                    totalReceitas = totalReceitas.add(t.getAmount());
                } else if (t.getType() == TransactionType.EXPENSE) {
                    totalDespesas = totalDespesas.add(t.getAmount());
                }
            }
            relatorio.append("  ✅ Receitas: R$ ").append(totalReceitas).append("\n");
            relatorio.append("  ❌ Despesas: R$ ").append(totalDespesas).append("\n");
            relatorio.append("  💰 Saldo: R$ ").append(totalReceitas.subtract(totalDespesas)).append("\n\n");
        }
        return relatorio.toString();
    }
    /**
     * Retorna a lista de transações registradas no sistema.
     * O retorno é a lista interna usada pelo serviço.
     *
     * @return lista de transações
     */
    public List<Transaction> getTransacoes() {
        return transactions;
    }
}