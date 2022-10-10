package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.SetUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://www.baeldung.com/apache-commons-setutils

class SetUtilsTests {
	Set<Integer> a, b;
	
	@BeforeEach
	void inicializar() {
		a = new HashSet<Integer>(Arrays.asList(1, 2, 5));
		b = new HashSet<Integer>(Arrays.asList(1, 2));
	}
	
	@Test
	void diferencaEntreSets() {
		SetUtils.SetView<Integer> result = SetUtils.difference(a, b);
		
		assertTrue(result.size() == 1);
		assertTrue(result.contains(5));
	}

}
