/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author Thyago H Pacher
 */
public class Compra {
    
    private int codcompra;
    private Produto produto;
    private Pessoa pessoa;
    private Date dtcadastro;
    private String formaPgto;
    private int qtd;
    private double precoUnitario;
    
    /**
     * @return the codcompra
     */
    public int getCodcompra() {
        return codcompra;
    }

    /**
     * @param codcompra the codcompra to set
     */
    public void setCodcompra(int codcompra) {
        this.codcompra = codcompra;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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
     * @return the formaPgto
     */
    public String getFormaPgto() {
        return formaPgto;
    }

    /**
     * @param formaPgto the formaPgto to set
     */
    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the precoUnitario
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * @param precoUnitario the precoUnitario to set
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
}
