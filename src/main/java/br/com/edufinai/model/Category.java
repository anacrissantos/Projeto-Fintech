package br.com.edufinai.model;
/**
 * Representa uma categoria de transação (ex.: Salário, Mercado).
 * Auxilia na classificação e na geração de relatórios.
 *
 * Responsabilidades:
 * - Identificar a categoria por meio de id.
 * - Nomear a categoria (ex.: "Transporte").
 * - Associar um ícone ilustrativo.
 *
 * Exemplos de uso:
 * - Categoria "Alimentação" para agrupar despesas de restaurante e mercado.
 * - Categoria "Renda" para agrupar salários e bonificações.
 */
public class Category {
    private Long id;
    private String name;
    private String icon;

    /**
     * Construtor padrão.
     * Cria uma categoria vazia que pode ser preenchida por setters.
     */
    public Category() {
    }

    /**
     * Construtor completo.
     *
     * @param id   identificador único da categoria
     * @param name nome da categoria
     * @param icon ícone associado à categoria
     */
    public Category(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    /**
     * Retorna o ícone associado à categoria.
     * Pode ser usado em interfaces gráficas para exibir o símbolo correspondente.
     *
     * @return ícone da categoria
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Define o ícone da categoria.
     * Útil para associar representações visuais em relatórios ou dashboards.
     *
     * @param icon ícone representativo
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "', icon='" + icon + "'}";
    }
}