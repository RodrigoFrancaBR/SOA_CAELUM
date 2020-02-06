
package br.com.caelum.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getVersaoResult" type="{http://tempuri.org/}versao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getVersaoResult"
})
@XmlRootElement(name = "getVersaoResponse")
public class GetVersaoResponse {

    @XmlElement(required = true)
    protected Versao getVersaoResult;

    /**
     * Obtém o valor da propriedade getVersaoResult.
     * 
     * @return
     *     possible object is
     *     {@link Versao }
     *     
     */
    public Versao getGetVersaoResult() {
        return getVersaoResult;
    }

    /**
     * Define o valor da propriedade getVersaoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Versao }
     *     
     */
    public void setGetVersaoResult(Versao value) {
        this.getVersaoResult = value;
    }

}
