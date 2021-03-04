// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package servico_web;

import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;

public class GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct_SOAPSerializer extends ObjectSerializerBase implements Initializable {
    private static final javax.xml.namespace.QName ns1_coditem_QNAME = new QName("", "coditem");
    private static final javax.xml.namespace.QName ns2_int_TYPE_QNAME = SchemaConstants.QNAME_TYPE_INT;
    private CombinedSerializer ns2_myns2__int__int_Int_Serializer;
    private static final javax.xml.namespace.QName ns1_codempresa_QNAME = new QName("", "codempresa");
    private static final int myCODITEM_INDEX = 0;
    private static final int myCODEMPRESA_INDEX = 1;
    
    public GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct_SOAPSerializer(QName type, boolean encodeType, boolean isNullable, String encodingStyle) {
        super(type, encodeType, isNullable, encodingStyle);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws java.lang.Exception {
        ns2_myns2__int__int_Int_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, int.class, ns2_int_TYPE_QNAME);
    }
    
    public java.lang.Object doDeserialize(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct instance = new servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct();
        java.lang.Object member;
        boolean isComplete = true;
        javax.xml.namespace.QName elementName;
        
        reader.nextElementContent();
        for (int i=0; i<2; i++) {
            elementName = reader.getName();
            if (reader.getState() == XMLReader.END) {
                break;
            }
            if (elementName.equals(ns1_coditem_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_coditem_QNAME, reader, context);
                instance.setCoditem(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_codempresa_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_codempresa_QNAME, reader, context);
                instance.setCodempresa(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
                continue;
            } else {
                throw new DeserializationException("soap.unexpectedElementName", new Object[] {ns1_codempresa_QNAME, elementName});
            }
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (isComplete ? (java.lang.Object)instance : (java.lang.Object)state);
    }
    
    public void doSerializeAttributes(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct instance = (servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct)obj;
        
    }
    
    public void doSerializeInstance(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct instance = (servico_web.GestaoCondominioPortType_procurarItemCodigoPedido_RequestStruct)obj;
        
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getCoditem()), ns1_coditem_QNAME, null, writer, context);
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getCodempresa()), ns1_codempresa_QNAME, null, writer, context);
    }
}
