package br.com.caelum.estoque.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import br.com.caelum.estoque.rmi.ItemEstoque;

public class TestaLeituraDeObjetos {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("itens.bin"));
		{
			List<ItemEstoque> itens = (List<ItemEstoque>) ois.readObject();
			for (ItemEstoque itemEstoque : itens) {
				System.out.println(itemEstoque.getCodigo());
				System.out.println(itemEstoque.getQuantidade());
			}
		}

	}

}
