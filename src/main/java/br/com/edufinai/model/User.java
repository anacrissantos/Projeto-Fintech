package br.com.edufinai.model;
/**
 * Representa um usuário do sistema EduFinAI.
 * Armazena dados pessoais e implementa a lógica de autenticação.
 *
 * Responsabilidades:
 * - Identificar o usuário por id, nome e e-mail.
 * - Gerenciar credenciais de acesso de forma segura.
 * - Validar a senha informada por meio de autenticação.
 *
 * Exemplo de uso:
 * - Criar usuário e definir senha.
 * - Autenticar usuário em operações financeiras.
 */
public class User {
    private Long id;
    private String name;
    private String email;
    private String passwordHash;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Define a senha do usuário gerando e armazenando um hash seguro.
     * A senha em texto puro não é mantida.
     *
     * @param password senha em texto simples
     */
    public void setPassword(String password) {
        this.passwordHash = gerarHash(password);
    }

    /**
     * Autentica o usuário verificando a senha informada
     * contra o hash armazenado.
     *
     * @param password senha em texto simples
     * @return true se a senha for válida, false caso contrário
     */
    public boolean authenticate(String password) {
        return passwordHash != null && passwordHash.equals(gerarHash(password));
    }

    /**
     * Gera um hash a partir de uma senha em texto simples.
     * Implementação interna simplificada.
     *
     * @param password senha em texto simples
     * @return string hash correspondente
     */
    private String gerarHash(String password) {
        return Integer.toHexString(password.hashCode());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}