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
public class TipoPagamento  implements java.io.Serializable  {
    private int codtipo;
    private String nome;
    private int codempresa;
    
    public TipoPagamento(){

    }
    
    public TipoPagamento(int codtipo, int codempresa){
        this.codtipo = codtipo;
        this.codempresa = codempresa;
    }
    
    public TipoPagamento(int codtipo, String nome){
        this.codtipo = codtipo;
        this.nome = nome;
    }
    /**
     * @return the codtipo
     */
    public int getCodtipo() {
        return codtipo;
    }

    /**
     * @param codtipo the codtipo to set
     */
    public void setCodtipo(int codtipo) {
        this.codtipo = codtipo;
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
     * @return the codempresa
     */
    public int getCodempresa() {
        return codempresa;
    }

    /**
     * @param codempresa the codempresa to set
     */
    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }
}
