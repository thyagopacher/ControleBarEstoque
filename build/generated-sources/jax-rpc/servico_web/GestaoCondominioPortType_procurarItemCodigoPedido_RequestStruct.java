// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;


public class GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct {
    protected int coditem;
    protected int codempresa;
    
    public GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct() {
    }
    
    public GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct(int coditem, int codempresa) {
        this.coditem = coditem;
        this.codempresa = codempresa;
    }
    
    public int getCoditem() {
        return coditem;
    }
    
    public void setCoditem(int coditem) {
        this.coditem = coditem;
    }
    
    public int getCodempresa() {
        return codempresa;
    }
    
    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }
}
