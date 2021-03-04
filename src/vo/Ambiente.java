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
public class Ambiente {
    
    private int codambiente;
    private String nome;
    private double valor;
    private String imagem;
    private String tiporeserva;
    private String termo;
    private Empresa empresa;
    private int periodo;
    private String horainicial;
    private String horafinal;
    private double pctcobranca;
    private double vlseguranca;
    private Pessoa funcionario;
    private String geratermo;
    private int padraostatusreserva;
    private int qtdresapto;
    private int maxconvidado;
    private int qtdsegconvidado;
    private int maxdia;
    private Date dtcadastro;

    /**
     * @return the codambiente
     */
    public int getCodambiente() {
        return codambiente;
    }

    /**
     * @param codambiente the codambiente to set
     */
    public void setCodambiente(int codambiente) {
        this.codambiente = codambiente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the tiporeserva
     */
    public String getTiporeserva() {
        return tiporeserva;
    }

    /**
     * @param tiporeserva the tiporeserva to set
     */
    public void setTiporeserva(String tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    /**
     * @return the termo
     */
    public String getTermo() {
        return termo;
    }

    /**
     * @param termo the termo to set
     */
    public void setTermo(String termo) {
        this.termo = termo;
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
     * @return the periodo
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the horainicial
     */
    public String getHorainicial() {
        return horainicial;
    }

    /**
     * @param horainicial the horainicial to set
     */
    public void setHorainicial(String horainicial) {
        this.horainicial = horainicial;
    }

    /**
     * @return the horafinal
     */
    public String getHorafinal() {
        return horafinal;
    }

    /**
     * @param horafinal the horafinal to set
     */
    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }

    /**
     * @return the pctcobranca
     */
    public double getPctcobranca() {
        return pctcobranca;
    }

    /**
     * @param pctcobranca the pctcobranca to set
     */
    public void setPctcobranca(double pctcobranca) {
        this.pctcobranca = pctcobranca;
    }

    /**
     * @return the vlseguranca
     */
    public double getVlseguranca() {
        return vlseguranca;
    }

    /**
     * @param vlseguranca the vlseguranca to set
     */
    public void setVlseguranca(double vlseguranca) {
        this.vlseguranca = vlseguranca;
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
     * @return the geratermo
     */
    public String getGeratermo() {
        return geratermo;
    }

    /**
     * @param geratermo the geratermo to set
     */
    public void setGeratermo(String geratermo) {
        this.geratermo = geratermo;
    }

    /**
     * @return the padraostatusreserva
     */
    public int getPadraostatusreserva() {
        return padraostatusreserva;
    }

    /**
     * @param padraostatusreserva the padraostatusreserva to set
     */
    public void setPadraostatusreserva(int padraostatusreserva) {
        this.padraostatusreserva = padraostatusreserva;
    }

    /**
     * @return the qtdresapto
     */
    public int getQtdresapto() {
        return qtdresapto;
    }

    /**
     * @param qtdresapto the qtdresapto to set
     */
    public void setQtdresapto(int qtdresapto) {
        this.qtdresapto = qtdresapto;
    }

    /**
     * @return the maxconvidado
     */
    public int getMaxconvidado() {
        return maxconvidado;
    }

    /**
     * @param maxconvidado the maxconvidado to set
     */
    public void setMaxconvidado(int maxconvidado) {
        this.maxconvidado = maxconvidado;
    }

    /**
     * @return the qtdsegconvidado
     */
    public int getQtdsegconvidado() {
        return qtdsegconvidado;
    }

    /**
     * @param qtdsegconvidado the qtdsegconvidado to set
     */
    public void setQtdsegconvidado(int qtdsegconvidado) {
        this.qtdsegconvidado = qtdsegconvidado;
    }

    /**
     * @return the maxdia
     */
    public int getMaxdia() {
        return maxdia;
    }

    /**
     * @param maxdia the maxdia to set
     */
    public void setMaxdia(int maxdia) {
        this.maxdia = maxdia;
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
    
}
