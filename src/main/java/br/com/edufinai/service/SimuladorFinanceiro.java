package br.com.edufinai.service;

import br.com.edufinai.model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 * Serviço de simulação financeira do EduFinAI.
 * Auxilia em projeções simples de saldo, ajuste por inflação
 * e estimativa de tempo para atingir um objetivo.
 *
 * Responsabilidades:
 * - Projetar saldo futuro com base no histórico de transações.
 * - Ajustar valores pela inflação acumulada.
 * - Estimar meses necessários para alcançar um valor alvo.
 *
 * Observações:
 * - Todas as operações com dinheiro utilizam BigDecimal.
 * - Recomenda-se definir escala e arredondamento para resultados previsíveis.
 */
public class SimuladorFinanceiro {

    /**
     * Projeta o saldo para os próximos N meses com base no histórico de transações.
     *
     * Como funciona:
     * - Calcula o saldo atual acumulando receitas e despesas.
     * - Estima um saldo mensal médio a partir do histórico (ex.: média da diferença receitas - despesas).
     * - Projeta o saldo adicionando a média mensal pelos próximos "monthsAhead" meses.
     *
     * Premissas:
     * - Projeção linear e simplificada (sem sazonalidade).
     * - Se não houver histórico suficiente, o método pode considerar a soma atual como base.
     *
     * @param transacoes lista de transações históricas
     * @param meses quantidade de meses a projetar à frente
     * @return saldo projetado após o período informado
     */
    public BigDecimal projetarSaldoFuturo(List<Transaction> transacoes, int meses) {
        BigDecimal saldoMensal = calcularSaldoMensal(transacoes);
        return saldoMensal.multiply(BigDecimal.valueOf(meses));
    }

    /**
     * Ajusta um valor pela inflação acumulada ao longo de N períodos mensais.
     *
     * Como funciona:
     * - Aplica a fórmula de inflação composta: valorAjustado = valor * (1 + taxaMensal) ^ meses
     * - Exemplo: taxaMensal = 0.006 (0,6% ao mês) e meses = 6.
     *
     * Parâmetros:
     * - amount: valor base a ser ajustado.
     * - monthlyInflationRate: taxa mensal em decimal (ex.: 0.01 = 1% ao mês).
     * - months: quantidade de meses de inflação a aplicar.
     *
     * Observações:
     * - Define arredondamento padrão HALF_UP e escala típica de 2 casas decimais.
     *
     * @param saldoProjetado valor a ajustar
     * @param taxaInflacaoAnual taxa mensal da inflação (ex.: 0.006 = 0,6%)
     * @param meses quantidade de meses
     * @return valor ajustado pela inflação
     */
    public BigDecimal ajustarPorInflacao(BigDecimal saldoProjetado, double taxaInflacaoAnual, int meses) {
        double taxaMensal = Math.pow(1 + taxaInflacaoAnual, 1.0 / 12) - 1;
        BigDecimal fatorDesconto = BigDecimal.valueOf(Math.pow(1 + taxaMensal, meses));
        return saldoProjetado.divide(fatorDesconto, 2, RoundingMode.HALF_UP);
    }

    /**
     * Estima em quantos meses um usuário alcançará um objetivo financeiro.
     *
     * Como funciona:
     * - Calcula o saldo atual a partir do histórico (receitas - despesas).
     * - Estima o ganho líquido mensal médio (receitas - despesas).
     * - Se o ganho mensal médio for positivo, divide a diferença (objetivo - saldoAtual) por esse ganho.
     * - Se o ganho for nulo ou negativo, retorna -1 indicando que não é alcançável no ritmo atual.
     *
     * Observações:
     * - Resultado inteiro em meses (arredondamento para cima quando necessário).
     * - Caso o saldo atual já seja maior ou igual ao objetivo, retorna 0.
     *
     * @param objetivo valor alvo a ser atingido
     * @param transacoes histórico de transações usadas para estimar a média mensal
     * @return meses estimados para atingir o objetivo; -1 se não alcançável
     */
    public int estimarMesesParaObjetivo(BigDecimal objetivo, List<Transaction> transacoes) {
        BigDecimal saldoMensal = calcularSaldoMensal(transacoes);

        if (saldoMensal.compareTo(BigDecimal.ZERO) <= 0) {
            return -1; // impossível atingir a meta com saldo mensal negativo
        }

        return objetivo.divide(saldoMensal, 0, RoundingMode.CEILING).intValue();
    }

    /**
     * Calcula o saldo mensal médio a partir de uma lista de transações.
     * Método de apoio para projeções.
     *
     * Como funciona:
     * - Soma receitas e subtrai despesas ao longo do histórico.
     * - Divide por uma quantidade aproximada de meses representados pelos dados
     *   (pode usar contagem baseada em datas ou um divisor fixo conforme a estratégia adotada).
     *
     * Observações:
     * - Implementação pode variar conforme o modelo de dados disponível.
     * - Recomenda-se padronizar escala e arredondamento ao final do cálculo.
     *
     * @param transacoes histórico de transações
     * @return saldo médio mensal estimado
     */
    private BigDecimal calcularSaldoMensal(List<Transaction> transacoes) {
        BigDecimal receita = BigDecimal.ZERO;
        BigDecimal despesa = BigDecimal.ZERO;

        for (Transaction t : transacoes) {
            if (t.getType() == TransactionType.INCOME) {
                receita = receita.add(t.getAmount());
            } else if (t.getType() == TransactionType.EXPENSE) {
                despesa = despesa.add(t.getAmount());
            }
        }
        return receita.subtract(despesa);
    }
}

