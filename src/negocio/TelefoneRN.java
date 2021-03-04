/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.TelefonePers;
import vo.Telefone;
/**
 *
 * @author Thyago H Pacher
 */
public class TelefoneRN {

    TelefonePers pp;
    String msg = "";

    public TelefoneRN() {
        pp = new TelefonePers();
    }

    public String inserir(Telefone objeto) {
        return pp.inserir(objeto);
    }

    public String atualizar(Telefone objeto) {
        return pp.atualizar(objeto);
    }

    public String excluir(Telefone objeto) {
        return pp.excluir(objeto);
    }

    public Telefone procuraCodigo(int codigo) {
        return pp.procuraCodigo(codigo);
    }

    public List<Telefone> procuraTodos() {
        return pp.procuraTodos();
    }

}
