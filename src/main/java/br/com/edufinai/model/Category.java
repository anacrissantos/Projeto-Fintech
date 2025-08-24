package br.com.edufinai.model;

/**
 * Representa uma categoria de transação (ex.: Salário, Mercado).
 * Auxilia na classificação e nos relatórios.
 */
public class Category {
    private Long id;
    private String name;

    /**
     * Construtor padrão.
     */
    public Category() {
    }

    /**
     * Construtor completo.
     *
     * @param id   identificador único da categoria
     * @param name nome da categoria
     */
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return id da categoria
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id define o id da categoria
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nome da categoria
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define o nome da categoria
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "'}";
    }
}
