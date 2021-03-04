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
public class Pedido {
    private int codpedido;
    private Pessoa morador;
    private Empresa empresa;
    private Pessoa funcionario;
    private TipoPagamento tipo;
    private double  valor;
    private int codstatus;
    private Date dtpedido;
    
    public Pedido(){
        
    }
    
    public Pedido(int codpedido){
        this.codpedido = codpedido;
    }
    
    public Pedido(int codpedido, Pessoa morador, Empresa empresa, Pessoa funcionario, TipoPagamento tipo, double valor){
        this.codpedido   = codpedido;
        this.morador     = morador;
        this.empresa     = empresa;
        this.funcionario = funcionario;
        this.tipo        = tipo;
        this.valor       = valor;
    }
    /**
     * @return the codpedido
     */
    public int getCodpedido() {
        return codpedido;
    }

    /**
     * @param codpedido the codpedido to set
     */
    public void setCodpedido(int codpedido) {
        this.codpedido = codpedido;
    }

    /**
     * @return the morador
     */
    public Pessoa getMorador() {
        return morador;
    }

    /**
     * @param morador the morador to set
     */
    public void setMorador(Pessoa morador) {
        this.morador = morador;
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
     * @return the tipo
     */
    public TipoPagamento getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the codstatus
     */
    public int getCodstatus() {
        return codstatus;
    }

    /**
     * @param codstatus the codstatus to set
     */
    public void setCodstatus(int codstatus) {
        this.codstatus = codstatus;
    }

    /**
     * @return the dtpedido
     */
    public Date getDtpedido() {
        return dtpedido;
    }

    /**
     * @param dtpedido the dtpedido to set
     */
    public void setDtpedido(Date dtpedido) {
        this.dtpedido = dtpedido;
    }
    
}
