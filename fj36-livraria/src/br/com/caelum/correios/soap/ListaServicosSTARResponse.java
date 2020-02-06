
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
 *         &lt;element name="ListaServicosSTARResult" type="{http://tempuri.org/}cResultadoServicos"/>
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
    "listaServicosSTARResult"
})
@XmlRootElement(name = "ListaServicosSTARResponse")
public class ListaServicosSTARResponse {

    @XmlElement(name = "ListaServicosSTARResult", required = true)
    protected CResultadoServicos listaServicosSTARResult;

    /**
     * Obtém o valor da propriedade listaServicosSTARResult.
     * 
     * @return
     *     possible object is
     *     {@link CResultadoServicos }
     *     
     */
    public CResultadoServicos getListaServicosSTARResult() {
        return listaServicosSTARResult;
    }

    /**
     * Define o valor da propriedade listaServicosSTARResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CResultadoServicos }
     *     
     */
    public void setListaServicosSTARResult(CResultadoServicos value) {
        this.listaServicosSTARResult = value;
    }

}
