/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.VeiculoPers;
import vo.Veiculo;
/**
 *
 * @author Thyago H Pacher
 */
public class VeiculoRN {

    VeiculoPers pp;
    String msg = "";

    public VeiculoRN() {
        pp = new VeiculoPers();
    }

    public String inserir(Veiculo objeto) {
        return pp.inserir(objeto);
    }

    public String atualizar(Veiculo objeto) {
        return pp.atualizar(objeto);
    }

    public String excluir(Veiculo objeto) {
        return pp.excluir(objeto);
    }

    public Veiculo procuraCodigo(int codigo) {
        return pp.procuraCodigo(codigo);
    }

    public List<Veiculo> procuraTodos() {
        return pp.procuraTodos();
    }

}
