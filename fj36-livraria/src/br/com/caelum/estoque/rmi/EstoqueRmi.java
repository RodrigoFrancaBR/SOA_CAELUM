package br.com.caelum.estoque.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EstoqueRmi extends Remote {
	public ItemEstoque getItemEstoque(String codigoProduto) throws RemoteException;
}
