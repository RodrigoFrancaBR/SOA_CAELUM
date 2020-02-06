
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
 *         &lt;element name="VerificaModalResult" type="{http://tempuri.org/}cResultadoModal"/>
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
    "verificaModalResult"
})
@XmlRootElement(name = "VerificaModalResponse")
public class VerificaModalResponse {

    @XmlElement(name = "VerificaModalResult", required = true)
    protected CResultadoModal verificaModalResult;

    /**
     * Obtém o valor da propriedade verificaModalResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultadoModal }
     *     
     */
    public CResultadoModal getVerificaModalResult() {
        return verificaModalResult;
    }

    /**
     * Define o valor da propriedade verificaModalResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultadoModal }
     *     
     */
    public void setVerificaModalResult(CResultadoModal value) {
        this.verificaModalResult = value;
    }

}
