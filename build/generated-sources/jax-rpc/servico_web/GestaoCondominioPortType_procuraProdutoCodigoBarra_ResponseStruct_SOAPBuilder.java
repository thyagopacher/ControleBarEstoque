// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.util.exception.LocalizableExceptionAdapter;

public class GestaoCondominioPortType_procuraProdutoCodigoBarra_ResponseStruct_SOAPBuilder implements SOAPInstanceBuilder {
    private servico_web.GestaoCondominioPortType_procuraProdutoCodigoBarra_ResponseStruct _instance;
    private java.lang.String retorno;
    private static final int myRETORNO_INDEX = 0;
    
    public GestaoCondominioPortType_procuraProdutoCodigoBarra_ResponseStruct_SOAPBuilder() {
    }
    
    public void setRetorno(java.lang.String retorno) {
        this.retorno = retorno;
    }
    
    public int memberGateType(int memberIndex) {
        switch (memberIndex) {
            case myRETORNO_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void construct() {
    }
    
    public void setMember(int index, java.lang.Object memberValue) {
        try {
            switch(index) {
                case myRETORNO_INDEX:
                    _instance.setRetorno((java.lang.String)memberValue);
                    break;
                default:
                    throw new java.lang.IllegalArgumentException();
            }
        }
        catch (java.lang.RuntimeException e) {
            throw e;
        }
        catch (java.lang.Exception e) {
            throw new DeserializationException(new LocalizableExceptionAdapter(e));
        }
    }
    
    public void initialize() {
    }
    
    public void setInstance(java.lang.Object instance) {
        _instance = (servico_web.GestaoCondominioPortType_procuraProdutoCodigoBarra_ResponseStruct)instance;
    }
    
    public java.lang.Object getInstance() {
        return _instance;
    }
}
