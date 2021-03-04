/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author ThyagoHenrique
 */
public class FilaEmail {
    private int codfila;
    private Pessoa pessoa;
    private Date dtcadastro;
    private Pessoa funcionario;
    private String situacao;
    private Empresa empresa;
    private String assunto;
    private String texto;
    private String tipo;
    private int codpagina;

    /**
     * @return the codfila
     */
    public int getCodfila() {
        return codfila;
    }

    /**
     * @param codfila the codfila to set
     */
    public void setCodfila(int codfila) {
        this.codfila = codfila;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the dtcadastro
     */
    public Date getDtcadastro() {
        return dtcadastro;
    }

    /**
     * @param dtcadastro the dtcadastro to set
     */
    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    /**
     * @return the funcionario
     */
    public Pessoa getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the codpagina
     */
    public int getCodpagina() {
        return codpagina;
    }

    /**
     * @param codpagina the codpagina to set
     */
    public void setCodpagina(int codpagina) {
        this.codpagina = codpagina;
    }
    
}
