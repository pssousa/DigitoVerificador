package br.edu.ufopa.util;

/*
 * Copyright (C) 2018 Enoque Alves
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

/**
 * Classe utilitária para cálculo de digito verificador. Calcula os principais 
 * dígitos utilizados no Brasil. Desenvolvido na disciplina Laboratório de Programação, 
 * Curso de Ciência da Computação, Universidade Federal do Oeste do Pará (UFOPA).
 * 
 * @author Enoque Alves
 * @version 1.0
 * 
 */
public class DigitoVerificador {
    
    /**
     * Método para cálculo dos dígitos verificadores do CPF.
     * 
     * @param numeroCPF String - Número do CPF, apenas números, sem os dígitos verificadores.
     * @return String - Dígitos verificadores do CPF
     */
    public static String digitoCPF(String numeroCPF) {
        
        if (! numeroCPF.matches("\\d{9}")) {
            throw new NumberFormatException("Número do CPF incorreto: "
                    + "deve conter 9 dígitos numéricos");
        }
        
        return modulo11(numeroCPF, 2, 12, true);
    }
    
    /**
     * Método para cálculo do dígito verificador do CNPJ.
     * 
     * @param numeroCNPJ String - Número do CNPJ, apenas números, sem os dígitos verificadores.
     * @return String - Dígitos verificadores do CNPJ.
     */
    public static String digitoCNPJ(String numeroCNPJ) {
        
        if (! numeroCNPJ.matches("\\d{12}")) {
            throw new NumberFormatException("Número CNPJ incorreto: "
                    + "deve conter 12 dígitos numéricos");
        }
        
        return modulo11(numeroCNPJ, 2, 9, true);
    }

    /**
     * Método para cálculo do dígito verificador do PIS.
     * 
     * @param numeroPIS String - Número do PIS, apenas números, sem o dígito verificador.
     * @return String - Dígito verificador do PIS
     */
    public static String digitoPIS(String numeroPIS) {
        
        if (! numeroPIS.matches("\\d{10}")) {
            throw new NumberFormatException("Número do PIS incorreto: "
                    + "deve conter 10 dígitos numéricos");
        }
        
        return modulo11(numeroPIS, 1, 9, true);
    }
    
    /**
     * Método para cálculo do dígito verificador do RG.
     * 
     * @param numeroRG String - Número do RG-SP, apenas números, sem o dígito verificador.
     * @return String - Dígito verificador do RG-SP
     */
    public static String digitoRGSP(String numeroRG) {
        
        if (! numeroRG.matches("\\d+")) {
            throw new NumberFormatException("Número do RG incorreto: "
                    + "deve conter apenas dígitos numéricos");
        }
        
        return modulo11(numeroRG, 1, 9, false);
    }
    
    /**
     * Método para cálculo do dígito verificador de Agência BB.
     * 
     * @param numeroAgencia String - Número da Agência, apenas números, sem o dígito verificador.
     * @return String - Dígito verificador da Agência.
     */
    public static String digitoAgenciaBB(String numeroAgencia) {
        
        if (! numeroAgencia.matches("\\d{4}")) {
            throw new NumberFormatException("Número da Agência incorreto: "
                    + "deve conter 4 dígitos numéricos");
        }
        
        return modulo11(numeroAgencia, 1, 9, true, 'X');
    }
    
    
    /**
     * Método para cálculo do dígito verificador de Conta Corrente BB.
     * 
     * @param numeroContaCorrente String - Número da Conta Corrente, apenas números, sem o dígito verificador.
     * @return String - Dígito verificador da Conta Corrente.
     */
    public static String digitoContaCorrenteBB(String numeroContaCorrente) {
        
        if (! numeroContaCorrente.matches("\\d+")) {
            throw new NumberFormatException("Número da Conta Corrente incorreto: "
                    + "deve conter apenas dígitos numéricos");
        }
        
        return modulo11(numeroContaCorrente, 1, 9, true, 'X');
    }
    
    
    /**
     * Método que implementa o tradicional modulo10 para cálculo de dígito verificador.
     * @param numero String - String contendo apenas números.
     * @return String - Dígito verificador para o número fornecido.
     */
    public static String modulo10(String numero) {
        
        if (! numero.matches("\\d+")) {
            throw new NumberFormatException("Parâmetro numero deve conter apenas "
                    + "dígitos numéricos");
        }
        
        int soma = 0;        
        int mult = 2;
        
        for (int i = numero.length() - 1; i >= 0; i--) {
            int n = Integer.valueOf(numero.substring(i, i + 1));
            soma += (n * mult) % 9;
            mult =  3 - mult;
        }

        int resto = soma % 10;
        int dv = (10 - resto) % 10;
       
        return String.valueOf(dv);
   
    }

    /**
     * Método que implementa o tradicional modulo10 para cálculo de dígito verificador.
     * 
     * @param numero String - String contendo apenas números.
     * @return String - Dígito verificador para o número fornecido.
     */
    public static String modulo11(String numero) {
        return modulo11(numero, 1, 9, true);
    }
    
    /**
     * Método que implementa o tradicional modulo10 para cálculo de dígito verificador.
     * 
     * @param numero String - String contendo apenas números.
     * @param numDig int - Quantidade de dígitos verificadores a serem calculados.
     * @param limMult int - Limite máximo para o multiplicador. O multiplicador inicia em 2, 
     * sendo incrementado para cada dígito. Quando o limite for atingido o multiplicador será 
     * reiniciado a partir de 2.
     * @param x10 boolean - Se true, a soma para cálculo do dígito sera multiplicada por 10.
     * @return String - Dígito(s) verificador(es) para o número fornecido.
     */
    public static String modulo11(String numero, int numDig, int limMult, boolean x10) {
        return modulo11(numero, numDig, limMult, x10, '0');
    }
    
    
    /**
     * Método que implementa o tradicional modulo10 para cálculo de dígito verificador.
     * 
     * @param numero String - String contendo apenas números.
     * @param numDig int - Quantidade de dígitos verificadores a serem calculados.
     * @param limMult int - Limite máximo para o multiplicador. O multiplicador inicia em 2, 
     * sendo incrementado para cada dígito. Quando o limite for atingido o multiplicador será 
     * reiniciado a partir de 2.
     * @param x10 boolean - Se true, a soma para cálculo do dígito sera multiplicada por 10.
     * @param ch10 char -  Caractere que substituirá o valor 10. Válido apenas se numDig = 1.
     * @return String - Dígito(s) verificador(es) para o número fornecido.
     */
    public static String modulo11(String numero, int numDig, int limMult, boolean x10, char ch10) {
        
        if (! numero.matches("\\d+")) {
            throw new NumberFormatException("Parâmetro numero deve conter apenas dígitos numéricos");
        }

        for (int x = 0; x < numDig; x++) {
            
            int mult = 2;
            int soma = 0;
        
            for (int i = numero.length() - 1; i >= 0; i--) {
                int n = Integer.valueOf(numero.substring(i, i + 1));
                soma += n * mult;
                mult = (mult - 1) % (limMult - 1) + 2;
            }
            
            if (x10) soma *= 10;
            
            int resto = (soma % 11);
            
            if (numDig > 1) resto = resto % 10;
            
            numero += (resto == 10)?ch10:String.valueOf(resto);
        }
        
        return numero.substring(numero.length() - numDig);
    }
    
}
