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

public class GestaoCondominioPortType_inserirItemPedido_ResponseStruct_SOAPSerializer extends ObjectSerializerBase implements Initializable {
    private static final javax.xml.namespace.QName ns1_retorno_QNAME = new QName("", "retorno");
    private static final javax.xml.namespace.QName ns2_int_TYPE_QNAME = SchemaConstants.QNAME_TYPE_INT;
    private CombinedSerializer ns2_myns2__int__int_Int_Serializer;
    private static final int myRETORNO_INDEX = 0;
    
    public GestaoCondominioPortType_inserirItemPedido_ResponseStruct_SOAPSerializer(QName type, boolean encodeType, boolean isNullable, String encodingStyle) {
        super(type, encodeType, isNullable, encodingStyle);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws java.lang.Exception {
        ns2_myns2__int__int_Int_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, int.class, ns2_int_TYPE_QNAME);
    }
    
    public java.lang.Object doDeserialize(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct instance = new servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct();
        java.lang.Object member;
        boolean isComplete = true;
        javax.xml.namespace.QName elementName;
        
        reader.nextElementContent();
        elementName = reader.getName();
        if (reader.getState() == XMLReader.START) {
            if (elementName.equals(ns1_retorno_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_retorno_QNAME, reader, context);
                instance.setRetorno(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
            } else {
                throw new DeserializationException("soap.unexpectedElementName", new Object[] {ns1_retorno_QNAME, elementName});
            }
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (isComplete ? (java.lang.Object)instance : (java.lang.Object)state);
    }
    
    public void doSerializeAttributes(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct instance = (servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct)obj;
        
    }
    
    public void doSerializeInstance(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct instance = (servico_web.GestaoCondominioPortType_inserirItemPedido_ResponseStruct)obj;
        
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getRetorno()), ns1_retorno_QNAME, null, writer, context);
    }
    protected void verifyName(XMLReader reader, javax.xml.namespace.QName expectedName) throws java.lang.Exception {
    }
}
