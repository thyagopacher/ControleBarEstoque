// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;


public class GestaoCondominioPortType_login_RequestStruct {
    protected java.lang.String email;
    protected java.lang.String senha;
    protected java.lang.String enderecoip;
    protected java.lang.String entrada;
    
    public GestaoCondominioPortType_login_RequestStruct() {
    }
    
    public GestaoCondominioPortType_login_RequestStruct(java.lang.String email, java.lang.String senha, java.lang.String enderecoip, java.lang.String entrada) {
        this.email = email;
        this.senha = senha;
        this.enderecoip = enderecoip;
        this.entrada = entrada;
    }
    
    public java.lang.String getEmail() {
        return email;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    public java.lang.String getSenha() {
        return senha;
    }
    
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }
    
    public java.lang.String getEnderecoip() {
        return enderecoip;
    }
    
    public void setEnderecoip(java.lang.String enderecoip) {
        this.enderecoip = enderecoip;
    }
    
    public java.lang.String getEntrada() {
        return entrada;
    }
    
    public void setEntrada(java.lang.String entrada) {
        this.entrada = entrada;
    }
}