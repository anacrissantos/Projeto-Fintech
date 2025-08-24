package br.com.edufinai.service;

import br.com.edufinai.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço central de regras de negócio para esta Etapa do projeto.
 * Mantém dados em memória (listas) e expõe operações para contas,
 * categorias, transações e usuários.
 *
 * <p>Em Etapas seguintes, estas listas serão substituídas por repositórios em Banco de Dados.</p>
 */
public class GerenciadorFinanceiroService {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();

    // ===== Usuários =====

    /**
     * Adiciona um usuário à coleção em memória.
     *
     * @param usuario instância a ser adicionada
     */
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Lista todos os usuários em memória.
     *
     * @return lista de usuários
     */
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // ===== Accounts =====

    /**
     * Adiciona uma conta à coleção em memória.
     *
     * @param account conta a ser adicionada
     */
    public void adicionarAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Lista todas as contas.
     *
     * @return lista de contas
     */
    public List<Account> listarAccounts() {
        return new ArrayList<>(accounts);
    }

    // ===== Categories =====

    /**
     * Adiciona uma categoria à coleção em memória.
     *
     * @param category categoria a ser adicionada
     */
    public void adicionarCategory(Category category) {
        categories.add(category);
    }

    /**
     * Lista todas as categorias.
     *
     * @return lista de categorias
     */
    public List<Category> listarCategories() {
        return new ArrayList<>(categories);
    }

    // ===== Transactions =====

    /**
     * Adiciona uma transação à coleção em memória.
     *
     * @param tx transação a ser adicionada
     */
    public void adicionarTransaction(Transaction tx) {
        transactions.add(tx);
    }

    /**
     * Lista todas as transações em memória.
     *
     * @return lista de transações
     */
    public List<Transaction> listarTransactions() {
        return new ArrayList<>(transactions);
    }

    /**
     * Lista as transações vinculadas a uma conta específica.
     *
     * @param accountId id da conta
     * @return lista de transações da conta
     */
    public List<Transaction> listarTransactionsPorConta(Long accountId) {
        List<Transaction> out = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAccountId() != null && t.getAccountId().equals(accountId)) {
                out.add(t);
            }
        }
        return out;
    }

    /**
     * Calcula o saldo de uma conta somando receitas e subtraindo despesas.
     *
     * @param accountId id da conta
     * @return saldo calculado
     */
    public BigDecimal calcularSaldoDaConta(Long accountId) {
        BigDecimal saldo = BigDecimal.ZERO;
        for (Transaction t : transactions) {
            if (t.getAccountId() != null && t.getAccountId().equals(accountId)) {
                if (t.getType() == TransactionType.INCOME) {
                    saldo = saldo.add(t.getAmount());
                } else if (t.getType() == TransactionType.EXPENSE) {
                    saldo = saldo.subtract(t.getAmount());
                }
            }
        }
        return saldo;
    }
}