// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;


public class GestaoCondominioPortType_procurarItemPedido_RequestStruct {
    protected int codpedido;
    protected int codempresa;
    
    public GestaoCondominioPortType_procurarItemPedido_RequestStruct() {
    }
    
    public GestaoCondominioPortType_procurarItemPedido_RequestStruct(int codpedido, int codempresa) {
        this.codpedido = codpedido;
        this.codempresa = codempresa;
    }
    
    public int getCodpedido() {
        return codpedido;
    }
    
    public void setCodpedido(int codpedido) {
        this.codpedido = codpedido;
    }
    
    public int getCodempresa() {
        return codempresa;
    }
    
    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }
}
