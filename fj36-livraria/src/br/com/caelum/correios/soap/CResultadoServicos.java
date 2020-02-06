
package br.com.caelum.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cResultadoServicos complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cResultadoServicos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServicosCalculo" type="{http://tempuri.org/}ArrayOfCServicosCalculo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cResultadoServicos", propOrder = {
    "servicosCalculo"
})
public class CResultadoServicos {

    @XmlElement(name = "ServicosCalculo")
    protected ArrayOfCServicosCalculo servicosCalculo;

    /**
     * Obtém o valor da propriedade servicosCalculo.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCServicosCalculo }
     *     
     */
    public ArrayOfCServicosCalculo getServicosCalculo() {
        return servicosCalculo;
    }

    /**
     * Define o valor da propriedade servicosCalculo.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCServicosCalculo }
     *     
     */
    public void setServicosCalculo(ArrayOfCServicosCalculo value) {
        this.servicosCalculo = value;
    }

}
