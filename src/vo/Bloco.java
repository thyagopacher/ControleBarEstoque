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
public class Bloco  implements Comparable<Bloco> {
    private String bloco;

    public Bloco(String nome){
        this.bloco = nome;
    }

    public Bloco() {
       
    }
    /**
     * @return the bloco
     */
    public String getBloco() {
        return bloco;
    }

    /**
     * @param bloco the bloco to set
     */
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    @Override
    public int compareTo(Bloco o) {
        return this.bloco.compareTo(o.getBloco());
    }    
}
