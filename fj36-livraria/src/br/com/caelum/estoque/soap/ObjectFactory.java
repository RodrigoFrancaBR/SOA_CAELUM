
package br.com.caelum.estoque.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.estoque.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Token_QNAME = new QName("http://caelum.com.br/estoquews/v1", "token");
    private final static QName _ItensPeloCodigoResponse_QNAME = new QName("http://caelum.com.br/estoquews/v1", "ItensPeloCodigoResponse");
    private final static QName _ItensPeloCodigo_QNAME = new QName("http://caelum.com.br/estoquews/v1", "ItensPeloCodigo");
    private final static QName _AuthorizationException_QNAME = new QName("http://caelum.com.br/estoquews/v1", "AuthorizationException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.estoque.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthorizationException }
     * 
     */
    public AuthorizationException createAuthorizationException() {
        return new AuthorizationException();
    }

    /**
     * Create an instance of {@link ItensPeloCodigoResponse }
     * 
     */
    public ItensPeloCodigoResponse createItensPeloCodigoResponse() {
        return new ItensPeloCodigoResponse();
    }

    /**
     * Create an instance of {@link ItensPeloCodigo }
     * 
     */
    public ItensPeloCodigo createItensPeloCodigo() {
        return new ItensPeloCodigo();
    }

    /**
     * Create an instance of {@link ItemEstoque }
     * 
     */
    public ItemEstoque createItemEstoque() {
        return new ItemEstoque();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "token")
    public JAXBElement<String> createToken(String value) {
        return new JAXBElement<String>(_Token_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItensPeloCodigoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "ItensPeloCodigoResponse")
    public JAXBElement<ItensPeloCodigoResponse> createItensPeloCodigoResponse(ItensPeloCodigoResponse value) {
        return new JAXBElement<ItensPeloCodigoResponse>(_ItensPeloCodigoResponse_QNAME, ItensPeloCodigoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItensPeloCodigo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "ItensPeloCodigo")
    public JAXBElement<ItensPeloCodigo> createItensPeloCodigo(ItensPeloCodigo value) {
        return new JAXBElement<ItensPeloCodigo>(_ItensPeloCodigo_QNAME, ItensPeloCodigo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "AuthorizationException")
    public JAXBElement<AuthorizationException> createAuthorizationException(AuthorizationException value) {
        return new JAXBElement<AuthorizationException>(_AuthorizationException_QNAME, AuthorizationException.class, null, value);
    }

}
