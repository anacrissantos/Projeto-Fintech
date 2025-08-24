package br.com.edufinai.model;

/**
 * Representa um usuário do sistema EduFinAI
 * Contém informações básicas para identificação e autenticação
 */
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senhaHash;

    /** Construtor padrão. */
    public Usuario() {}
    /**
     * Construtor completo.
     *
     * @param id        identificador único
     * @param nome      nome do usuário
     * @param email     email do usuário
     * @param senhaHash senha criptografada (hash)
     */
    public Usuario(Long id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    /**
     * @return id único do usuário
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id define o id único do usuário
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome define o nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email define o email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return senha criptografada (hash)
     */
    public String getSenhaHash() {
        return senhaHash;
    }

    /**
     * @param senhaHash define a senha criptografada (hash)
     */
    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nome + "', email='" + email + "'}";
    }
}
