package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://www.baeldung.com/apache-commons-setutils

class SetUtilsTests {
	Set<Integer> a, b, esperado;
	
	@BeforeEach
	void inicializar() {
		a = new HashSet(Arrays.asList(1, 2, 5));
	}

}
