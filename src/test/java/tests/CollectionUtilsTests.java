package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Cliente;

class CollectionUtilsTests {
	Cliente cli1, cli2, cli3, cli4, cli5, cli6;
	List<Cliente> lista1, lista2, lista3, linkedList;
	
	@BeforeEach
	void inicializar() {
		cli1 = new Cliente(1, "Dona Florinda", "Rio de Janeiro", "RJ");
		cli2 = new Cliente(2, "Professor Girafales", "Rio de Janeiro", "RJ");
		cli3 = new Cliente(3, "Seu Barriga", "Rio de Janeiro", "RJ");
		cli4 = new Cliente(4, "Chaves", "Rio de Janeiro", "RJ");
		cli5 = new Cliente(5, "Quico", "Rio de Janeiro", "RJ");
		cli6 = new Cliente(6, "Seu Madruga", "Rio de Janeiro", "RJ");
		
		lista1 = Arrays.asList(cli1, cli2, cli3);
		lista2 = Arrays.asList(cli4, cli5, cli6);
		lista3 = Arrays.asList(cli1, cli2);
		
		linkedList = new LinkedList<Cliente>(lista1);
	}
	
	@Test
	void adicionarNuloNaLista() {
	    CollectionUtils.addIgnoreNull(lista1, null); //collection, object
	    assertFalse(lista1.contains(null));
	}
	
	@Test
	void verificarListaVazia() {
		assertTrue(CollectionUtils.isNotEmpty(lista1));
		assertTrue(CollectionUtils.isNotEmpty(linkedList));
		assertFalse(CollectionUtils.isEmpty(lista1));
	}
	
	@Test
	void verificarASubListaEntreDuasListas() {
		//para A ser sublista de B, A deve conter alguns ou todos os elementos de B.
		assertTrue(CollectionUtils.isSubCollection(lista3, lista1));
		assertTrue(CollectionUtils.isSubCollection(lista1, linkedList));
		assertTrue(CollectionUtils.isSubCollection(lista1, lista1));
		assertFalse(CollectionUtils.isSubCollection(lista2, lista1));
	}
	
	@Test
	void interseccaoDeDuasColecoes() {
		//objeto collection contendo a interseccao entre duas listas
		Collection<Cliente> interseccao = CollectionUtils.intersection(lista1, lista3);
		assertTrue(interseccao.size() == 2);
	}
	
	@Test
	void subtrairItensDiferentesEntreDuasColecoes() {
		Collection<Cliente> sub = CollectionUtils.subtract(lista1, lista3);
		assertFalse(sub.contains(cli1));
		assertTrue(sub.contains(cli3));
	}
	
	@Test
	void uniaoEntreDuasColecoes() {
		Collection<Cliente> uniao = CollectionUtils.union(lista1, lista2);
		
		assertTrue(uniao.contains(cli1));
		assertTrue(uniao.contains(cli5));
		assertTrue(uniao.size() == 6);
	}
	
	@Test
	void filtrarECorrigirTamanhoDeUmaLinkedList() {
	    //--> filter recebe uma lista a ser filtrada e um 'Predicate'
		//--> 'Predicate' é uma classe do Apache. Usaremos ela para validar filtragem.
		// A cada cliente dentro da linkedList é verificado se ele existe na lista com
		// os filtros que estamos a realizar
	    boolean modificar = CollectionUtils.filter(linkedList, 
	      new Predicate<Cliente>() {
	        public boolean evaluate(Cliente cliente) {
	            return Arrays.asList("Dona Florinda","Seu Barriga").contains(cliente.getNome());
	        }
	    });
	     
	    assertTrue(linkedList.size() == 2);
	}
	
	
}
