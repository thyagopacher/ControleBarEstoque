/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import persistencia.PessoaPers;
import vo.Apartamento;
import vo.Bloco;
import vo.Pessoa;

/**
 *
 * @author Thyago H Pacher
 */
public class PessoaRN {

    PessoaPers pp;
    String msg = "";

    public PessoaRN() {
        pp = new PessoaPers();
    }

    public boolean valida_cpf(String strCpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.parseInt(strCpf.substring(nCount - 1, nCount));
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        }

        resto = (d1 % 11);

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;
        resto = (d2 % 11);

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        return nDigVerific.equals(nDigResult);
    }

    public String validaEmail(String email) {
        String msg = "";
        String email2[] = email.split("@");
        if (email == null || email.isEmpty()) {
            msg = "E-mail não pode ficar vazio!!!";
        } else if (email.length() < 5) {
            msg = "E-mail deve conter mais que 5 letras";
        } else if (!email.contains("@")) {
            msg = "E-mail deve conter @!";
        } else if (!email.contains(".")) {
            msg = "E-mail deve conter pontos (.) separadores!";
        } else if (email2.length != 2) {
            msg = "E-mail deve conter uma parte antes do @ e outro parte depois!";
        } else if (email2[0].length() < 3) {
            msg = "Primeira parte do e-mail deve conter pelo menos 3 letras!";
        } else if (email2[1].length() < 3) {
            msg = "Segunda parte do e-mail deve conter pelo menos 3 letras!";
        }
        return msg;
    }

    public String validaSenha(String senha) {
        String msg = "";
        if (senha == null || senha.isEmpty() || senha.trim().isEmpty()) {
            msg = "Senha não pode ficar em branco!";
        } else if (senha.length() < 5) {
            msg = "Senha não pode ser menor que 5 digitos!";
        }
        return msg;
    }

    public String valida(Pessoa objeto) {
        String msg2 = "";
        if (objeto.getNome() == null || objeto.getNome().isEmpty()) {
            msg2 += "\nNome não pode ficar em branco!";
        }
        if (objeto.getEmail() == null || objeto.getEmail().isEmpty()) {
            msg2 += "\nE-mail não pode ficar em branco!";
        }
        return msg2;
    }

    public String inserir(Pessoa objeto) {
        String res = this.valida(objeto);
        if (res == null || res.isEmpty()) {
            return pp.inserir(objeto);
        } else {
            return res;
        }
    }

    public String atualizar(Pessoa objeto) {
        String res = this.valida(objeto);
        if (res == null || res.isEmpty()) {
            return pp.atualizar(objeto);
        } else {
            return res;
        }
    }

    public String excluir(Pessoa objeto) {
        return pp.excluir(objeto);
    }

    public Pessoa procuraCodigo(int codigo) {
        return pp.procuraCodigo(codigo);
    }

    public List<Pessoa> procura(String nome) {
        return pp.procuraNomeParcial(nome);
    }

    public Pessoa login(String email, String senha) throws RemoteException, UnsupportedEncodingException {
        return pp.login1(email, senha);
    }

    public List<Bloco> procuraBlocos(int codempresa) throws RemoteException {
        return pp.procuraBlocos(codempresa);
    }

    public List<Apartamento> procuraApartamentos(String bloco, int codempresa) {
        return pp.procuraApartamentos(bloco, codempresa);
    }

    public List<Pessoa> procuraMorador(String bloco, String apartamento, int codempresa) {
        return pp.procuraMorador(bloco, apartamento, codempresa);
    }

    public Pessoa procuraMoradorCodigo(int codempresa, int codpessoa) {
        return pp.procuraMoradorCodigo(codempresa, codpessoa);
    }

    public String setObj(List<Pessoa> pessoas) {
        return pp.setObj(pessoas);
    }

    public List<Pessoa> getListaCache() {
        return pp.getListaCache();
    }

    public String setObjMorador(List<Pessoa> pessoas) {
        return pp.setObjMorador(pessoas);
    }

    public List<Pessoa> getListaCacheMorador() {
        return pp.getListaCacheMorador();
    }

    public List<Apartamento> procuraApartamentos2(int codempresa) {
        return pp.procuraApartamentos2(codempresa);
    }

    public List<Pessoa> procuraMoradorEmpresa(int codempresa) {
        return pp.procuraMoradorEmpresa(codempresa);
    }

}
