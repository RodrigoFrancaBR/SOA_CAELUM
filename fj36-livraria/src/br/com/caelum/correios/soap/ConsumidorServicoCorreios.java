package br.com.caelum.correios.soap;

import java.math.BigDecimal;
import java.util.List;

public class ConsumidorServicoCorreios {

	private final String codigoSedex = "40010";
	private final String cepOrigemCaelumSP = "04101300"; // Caelum SP
	private final String peso3kg = "3";
	private final BigDecimal comprimento20cm = new BigDecimal(20);
	private final BigDecimal altura10cm = new BigDecimal(10);
	private final BigDecimal largura15cm = new BigDecimal(15);
	private final BigDecimal diametro10cm = new BigDecimal(10);
	private final int formatoEncomendaCaixa = 1; // 1 é caixa ou pacote
	private final BigDecimal semValorDeclarado = BigDecimal.ZERO;
	private final String semEntregueEmMaos = "N";
	private final String semAvisoRecebimento = "N";
	private final String semCodigoEmpresa = "";
	private final String semSenhaEmpresa = "";

	// Documentacao:
	// http://www.correios.com.br/webServices/PDF/SCPP_manual_implementacao_calculo_remoto_de_precos_e_prazos.pdf
	public BigDecimal calculaFrete(String cepDestino) {

		CalcPrecoPrazoWSSoap servico = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();

		cepDestino = this.tirarHifenDoCep(cepDestino);

		String valorFrete = null;

		CResultado resultado = servico.calcPrecoPrazo(semCodigoEmpresa, semSenhaEmpresa, codigoSedex, cepOrigemCaelumSP,
				cepDestino, peso3kg, formatoEncomendaCaixa, comprimento20cm, altura10cm, largura15cm, diametro10cm,
				semEntregueEmMaos, semValorDeclarado, semAvisoRecebimento);

		List<CServico> servicoPesquisado = resultado.getServicos().getCServico();

		 valorFrete = servicoPesquisado.get(0).getValor();

		System.out.printf("Frete para %s e  de %s %n ", cepDestino, valorFrete);

		return converterParaBigDecimal(valorFrete);
	}

	private BigDecimal converterParaBigDecimal(String valor) {
		return new BigDecimal(valor.replace(',', '.'));
	}

	public String tirarHifenDoCep(String cep) {
		return cep.replaceAll("-", "");
	}

}
