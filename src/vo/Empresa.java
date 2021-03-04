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
public class Empresa {
    
    private int codempresa;
    private String razao;
    private String logo;
    private String sitemorador;

    public Empresa(){
        
    }
    
    public Empresa(int codempresa) {
        this.codempresa = codempresa;
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

    /**
     * @return the razao
     */
    public String getRazao() {
        return razao;
    }

    /**
     * @param razao the razao to set
     */
    public void setRazao(String razao) {
        this.razao = razao;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the sitemorador
     */
    public String getSitemorador() {
        return sitemorador;
    }

    /**
     * @param sitemorador the sitemorador to set
     */
    public void setSitemorador(String sitemorador) {
        this.sitemorador = sitemorador;
    }
    
}
