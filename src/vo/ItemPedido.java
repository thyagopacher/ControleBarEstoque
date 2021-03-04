/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author Thyago H Pacher
 */
public class ItemPedido  implements java.io.Serializable  {
    private int coditem;
    private Pedido  pedido;
    private Produto produto;
    private Pessoa funcionario;
    private double unitario;
    private int qtd;
    private Empresa empresa;
        
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
     * @return the unitario
     */
    public double getUnitario() {
        return unitario;
    }

    /**
     * @param unitario the unitario to set
     */
    public void setUnitario(double unitario) {
        this.unitario = unitario;
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
     * @return the coditem
     */
    public int getCoditem() {
        return coditem;
    }

    /**
     * @param coditem the coditem to set
     */
    public void setCoditem(int coditem) {
        this.coditem = coditem;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

}
