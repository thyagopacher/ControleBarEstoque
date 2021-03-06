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

public class GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPSerializer extends ObjectSerializerBase implements Initializable {
    private static final javax.xml.namespace.QName ns1_nome_QNAME = new QName("", "nome");
    private static final javax.xml.namespace.QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
    private CombinedSerializer ns2_myns2_string__java_lang_String_String_Serializer;
    private static final javax.xml.namespace.QName ns1_valor_QNAME = new QName("", "valor");
    private static final javax.xml.namespace.QName ns1_codigobarra_QNAME = new QName("", "codigobarra");
    private static final javax.xml.namespace.QName ns1_quantidade_QNAME = new QName("", "quantidade");
    private static final javax.xml.namespace.QName ns2_int_TYPE_QNAME = SchemaConstants.QNAME_TYPE_INT;
    private CombinedSerializer ns2_myns2__int__int_Int_Serializer;
    private static final javax.xml.namespace.QName ns1_codempresa_QNAME = new QName("", "codempresa");
    private static final javax.xml.namespace.QName ns1_codproduto_QNAME = new QName("", "codproduto");
    private static final javax.xml.namespace.QName ns1_status_QNAME = new QName("", "status");
    private static final int myNOME_INDEX = 0;
    private static final int myVALOR_INDEX = 1;
    private static final int myCODIGOBARRA_INDEX = 2;
    private static final int myQUANTIDADE_INDEX = 3;
    private static final int myCODEMPRESA_INDEX = 4;
    private static final int myCODPRODUTO_INDEX = 5;
    private static final int mySTATUS_INDEX = 6;
    
    public GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPSerializer(QName type, boolean encodeType, boolean isNullable, String encodingStyle) {
        super(type, encodeType, isNullable, encodingStyle);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws java.lang.Exception {
        ns2_myns2_string__java_lang_String_String_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, java.lang.String.class, ns2_string_TYPE_QNAME);
        ns2_myns2__int__int_Int_Serializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, int.class, ns2_int_TYPE_QNAME);
    }
    
    public java.lang.Object doDeserialize(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct instance = new servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct();
        servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPBuilder builder = null;
        java.lang.Object member;
        boolean isComplete = true;
        javax.xml.namespace.QName elementName;
        
        reader.nextElementContent();
        for (int i=0; i<7; i++) {
            elementName = reader.getName();
            if (reader.getState() == XMLReader.END) {
                break;
            }
            if (elementName.equals(ns1_nome_QNAME)) {
                member = ns2_myns2_string__java_lang_String_String_Serializer.deserialize(ns1_nome_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myNOME_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setNome((java.lang.String)member);
                }
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_valor_QNAME)) {
                member = ns2_myns2_string__java_lang_String_String_Serializer.deserialize(ns1_valor_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myVALOR_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setValor((java.lang.String)member);
                }
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_codigobarra_QNAME)) {
                member = ns2_myns2_string__java_lang_String_String_Serializer.deserialize(ns1_codigobarra_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, myCODIGOBARRA_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setCodigobarra((java.lang.String)member);
                }
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_quantidade_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_quantidade_QNAME, reader, context);
                instance.setQuantidade(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_codempresa_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_codempresa_QNAME, reader, context);
                instance.setCodempresa(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_codproduto_QNAME)) {
                member = ns2_myns2__int__int_Int_Serializer.deserialize(ns1_codproduto_QNAME, reader, context);
                instance.setCodproduto(((java.lang.Integer)member).intValue());
                reader.nextElementContent();
                continue;
            }
            if (elementName.equals(ns1_status_QNAME)) {
                member = ns2_myns2_string__java_lang_String_String_Serializer.deserialize(ns1_status_QNAME, reader, context);
                if (member instanceof SOAPDeserializationState) {
                    if (builder == null) {
                        builder = new servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct_SOAPBuilder();
                    }
                    state = registerWithMemberState(instance, state, member, mySTATUS_INDEX, builder);
                    isComplete = false;
                } else {
                    instance.setStatus((java.lang.String)member);
                }
                reader.nextElementContent();
                continue;
            } else {
                throw new DeserializationException("soap.unexpectedElementName", new Object[] {ns1_status_QNAME, elementName});
            }
        }
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (isComplete ? (java.lang.Object)instance : (java.lang.Object)state);
    }
    
    public void doSerializeAttributes(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct instance = (servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct)obj;
        
    }
    
    public void doSerializeInstance(java.lang.Object obj, XMLWriter writer, SOAPSerializationContext context) throws java.lang.Exception {
        servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct instance = (servico_web.GestaoCondominioPortType_atualizarProduto_RequestStruct)obj;
        
        ns2_myns2_string__java_lang_String_String_Serializer.serialize(instance.getNome(), ns1_nome_QNAME, null, writer, context);
        ns2_myns2_string__java_lang_String_String_Serializer.serialize(instance.getValor(), ns1_valor_QNAME, null, writer, context);
        ns2_myns2_string__java_lang_String_String_Serializer.serialize(instance.getCodigobarra(), ns1_codigobarra_QNAME, null, writer, context);
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getQuantidade()), ns1_quantidade_QNAME, null, writer, context);
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getCodempresa()), ns1_codempresa_QNAME, null, writer, context);
        ns2_myns2__int__int_Int_Serializer.serialize(new java.lang.Integer(instance.getCodproduto()), ns1_codproduto_QNAME, null, writer, context);
        ns2_myns2_string__java_lang_String_String_Serializer.serialize(instance.getStatus(), ns1_status_QNAME, null, writer, context);
    }
}
