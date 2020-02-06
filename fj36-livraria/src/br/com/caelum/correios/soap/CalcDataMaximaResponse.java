
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
 *         &lt;element name="CalcDataMaximaResult" type="{http://tempuri.org/}cResultadoObjeto"/>
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
    "calcDataMaximaResult"
})
@XmlRootElement(name = "CalcDataMaximaResponse")
public class CalcDataMaximaResponse {

    @XmlElement(name = "CalcDataMaximaResult", required = true)
    protected CResultadoObjeto calcDataMaximaResult;

    /**
     * Obtém o valor da propriedade calcDataMaximaResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultadoObjeto }
     *     
     */
    public CResultadoObjeto getCalcDataMaximaResult() {
        return calcDataMaximaResult;
    }

    /**
     * Define o valor da propriedade calcDataMaximaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultadoObjeto }
     *     
     */
    public void setCalcDataMaximaResult(CResultadoObjeto value) {
        this.calcDataMaximaResult = value;
    }

}
