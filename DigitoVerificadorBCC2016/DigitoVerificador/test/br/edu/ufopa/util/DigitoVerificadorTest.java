/*
 * Copyright (C) 2018 Midias
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.ufopa.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Midias
 */
public class DigitoVerificadorTest {
    
    public DigitoVerificadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         System.out.println("Iniciando testes DigitoVerificador...");
    }
    
    @AfterClass
    public static void tearDownClass() {
         System.out.println("Testes DigitoVerificador concluído!");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of digitoCPF method, of class DigitoVerificador.
     */
    
    @Test
    public void testDigitoCPFValido() {
        //Caso de Teste de sucesso
        String numero = "345678123";
        String expResult = "79";
        String result = DigitoVerificador.digitoCPF(numero);
        System.out.println("[CPF] Testando número: " + numero + " -> dígito: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testDigitoCPFDigitosInsuficientes() {    
        //Caso de teste com poucos digítos   
        System.out.println("[CPF} Testando com poucos dígitos...");
        try {
           DigitoVerificador.digitoCPF("123456"); 
           fail("Aceitou valor com poucos dígitos");
        } catch (NumberFormatException e) {
           assert(true);
        }
    }

        //Implementação do Caso de Teste CPF com muitos dígitos       
        
        //Implementação do Caso de Teste CPF com valores alfanuméricos    
    
    
    /**
     * Test of digitoCNPJ method, of class DigitoVerificador.
     */
    @Test
    public void testDigitoCNPJ() {

    }

    /**
     * Test of digitoPIS method, of class DigitoVerificador.
     */
    @Test
    public void testDigitoPIS() {

    }

    /**
     * Test of digitoRGSP method, of class DigitoVerificador.
     */
    @Test
    public void testDigitoRGSP() {

    }

    /**
     * Test of digitoAgenciaBB method, of class DigitoVerificador.
     */
    @Test
    public void testDigitoAgenciaBB() {

    }

    /**
     * Test of digitoContaCorrenteBB method, of class DigitoVerificador.
     */
    @Test
    public void testDigitoContaCorrenteBB() {

    }

