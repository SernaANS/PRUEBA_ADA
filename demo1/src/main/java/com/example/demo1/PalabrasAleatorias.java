package com.example.demo1;

import java.util.*;

public class PalabrasAleatorias {

    public static void main(String[] args) {

        Set<String> diccionario= new HashSet<>();
        diccionario.add("WHITE");
        diccionario.add("RES");
        diccionario.add("FIRE");

        char[] letras={'W','S','T','W','F','R','H','A','B','C','D','E','F','U','E','E','R','T'};

        Set<String> x= encontrarPalabrasConstruibles(diccionario,letras);

        for (String palabra:x) {
            System.out.println(palabra);
        }
    }

    private static Set<String> encontrarPalabrasConstruibles(Set<String> diccionario, char[] letrasDisponibles) {
        Set<String> palabrasConstruibles = new HashSet<>();
        Map<Character, Integer> mapaLetrasDisponibles = contarLetras(letrasDisponibles);

        for (String palabra : diccionario) {
            if (sePuedeConstruir(palabra, mapaLetrasDisponibles)) {
                palabrasConstruibles.add(palabra);
            }
        }

        return palabrasConstruibles;
    }

    private static boolean sePuedeConstruir(String palabra, Map<Character, Integer> mapaLetrasDisponibles) {
        Map<Character, Integer> mapaLetrasPalabra = contarLetras(palabra.toCharArray());

        for (Map.Entry<Character, Integer> entry : mapaLetrasPalabra.entrySet()) {
            char letra = entry.getKey();
            int cantidadNecesaria = entry.getValue();

            if (mapaLetrasDisponibles.getOrDefault(letra, 0) < cantidadNecesaria) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> contarLetras(char[] letras) {
        Map<Character, Integer> mapaLetras = new HashMap<>();

        for (char letra : letras) {
            mapaLetras.put(letra, mapaLetras.getOrDefault(letra, 0) + 1);
        }

        return mapaLetras;
    }
}
