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
public class Apartamento implements Comparable<Apartamento> {
    
    private String bloco;
    private String apartamento;

    public Apartamento(){
        
    }
    
    public Apartamento(String bloco, String apartamento){
        this.bloco = bloco;
        this.apartamento = apartamento;
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

    /**
     * @return the apartamento
     */
    public String getApartamento() {
        return apartamento;
    }

    /**
     * @param apartamento the apartamento to set
     */
    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public int compareTo(Apartamento o) {
        if (Integer.valueOf(this.apartamento) < Integer.valueOf(o.getApartamento())) {
            return -1;
        }
        if (Integer.valueOf(this.apartamento) > Integer.valueOf(o.getApartamento())) {
            return 1;
        }
        return 0;
    }
    
}
