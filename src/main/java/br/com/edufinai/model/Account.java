package br.com.edufinai.model;

/**
 * Representa uma conta financeira (ex.: Carteira, Banco).
 * Usada para agrupar transações e calcular saldos.
 */
public class Account {
    private Long id;
    private String name;

    /**
     * Construtor padrão.
     */
    public Account() {
    }

    /**
     * Construtor completo.
     *
     * @param id   identificador único da conta
     * @param name nome da conta (ex.: Carteira, Banco)
     */
    public Account(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return id da conta
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id define o id da conta
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nome da conta
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define o nome da conta
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{id=" + id + ", name='" + name + "'}";
    }
}
