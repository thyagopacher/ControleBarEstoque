// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.client.ServiceExceptionImpl;
import com.sun.xml.rpc.util.exception.*;
import com.sun.xml.rpc.soap.SOAPVersion;
import com.sun.xml.rpc.client.HandlerChainImpl;
import javax.xml.rpc.*;
import javax.xml.rpc.encoding.*;
import javax.xml.rpc.handler.HandlerChain;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.namespace.QName;

public class GestaoCondominio_Impl extends com.sun.xml.rpc.client.BasicService implements GestaoCondominio {
    private static final QName serviceName = new QName("urn:server.GestaoCondominio", "GestaoCondominio");
    private static final QName ns1_GestaoCondominioPort_QNAME = new QName("urn:server.GestaoCondominio", "GestaoCondominioPort");
    private static final Class gestaoCondominioPortType_PortClass = servico_web.GestaoCondominioPortType.class;
    
    public GestaoCondominio_Impl() {
        super(serviceName, new QName[] {
                        ns1_GestaoCondominioPort_QNAME
                    },
            new servico_web.GestaoCondominio_SerializerRegistry().getRegistry());
        
    }
    
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, java.lang.Class serviceDefInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (portName.equals(ns1_GestaoCondominioPort_QNAME) &&
                serviceDefInterface.equals(gestaoCondominioPortType_PortClass)) {
                return getGestaoCondominioPort();
            }
        } catch (Exception e) {
            throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(e));
        }
        return super.getPort(portName, serviceDefInterface);
    }
    
    public java.rmi.Remote getPort(java.lang.Class serviceDefInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serviceDefInterface.equals(gestaoCondominioPortType_PortClass)) {
                return getGestaoCondominioPort();
            }
        } catch (Exception e) {
            throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(e));
        }
        return super.getPort(serviceDefInterface);
    }
    
    public servico_web.GestaoCondominioPortType getGestaoCondominioPort() {
        java.lang.String[] roles = new java.lang.String[] {};
        HandlerChainImpl handlerChain = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_GestaoCondominioPort_QNAME));
        handlerChain.setRoles(roles);
        servico_web.GestaoCondominioPortType_Stub stub = new servico_web.GestaoCondominioPortType_Stub(handlerChain);
        try {
            stub._initialize(super.internalTypeRegistry);
        } catch (JAXRPCException e) {
            throw e;
        } catch (Exception e) {
            throw new JAXRPCException(e.getMessage(), e);
        }
        return stub;
    }
}
