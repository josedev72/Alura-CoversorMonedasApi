package com.alura.principal;

import com.alura.funciones.CambiarMoneda;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;



public class Principal {
    public static void main(String[] args) {

        // Modificar para que al iniciar el programa cargue la cotizacion y agregar en el menú la opcion de actualizar cotizacion
        // a fin de hacerlo más rápido y que no requiera que cada vez que consultamos una cotizacion, deba consultar la API

        CambiarMoneda cotizacion = new CambiarMoneda();
        JsonObject conversionRates = cotizacion.cargarCotizacion();

        Scanner lectura = new Scanner(System.in);
        int opcion = -1;
        String opcionString = "";

        String titulo = "";

        while (opcion != 0){
            menu();

            try {
                opcionString = lectura.nextLine();
                opcion =Integer.parseInt(opcionString);
                switch (opcion){
                    case 1:
                        titulo = "U$S a Ars";
                        break;
                    case 2:
                        titulo = "Ars a U$S";
                        break;
                    case 3:
                        titulo = "U$S a Reales Brasileños";
                        break;
                    case 4:
                        titulo = "Reales Brasileños a U$S";
                        break;
                    case 5:
                        titulo = "U$S a Pesos Colombianos";
                        break;
                    case 6:
                        titulo = "Pesos Colombianos a U$S";
                        break;
                    case 7:
                        conversionRates = cotizacion.cargarCotizacion();
                        break;

                    case 0:
                        System.out.println("Eligió salir del Conversor de Moneda, hasta pronto !!!");
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }

                if (opcion != 0 && opcion != 7) {
                    consultarCotizacion(conversionRates, titulo, opcion);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void consultarCotizacion(JsonObject conversionRates, String titulo, int opcion) {
        double monedaOrigen = 0, monedaDestino = 0;
        Scanner lectura = new Scanner(System.in);
        String claveBuscada = "";
        double cotiza = 0;
        double resultado = 0;

        System.out.println(titulo);
        System.out.print("Ingrese el valor que desea convertir: ");
        monedaOrigen = lectura.nextDouble();

        switch (opcion){
            case 1:
                claveBuscada = "ARS";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen * cotiza;
                break;
            case 2:
                claveBuscada = "ARS";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen / cotiza;
                break;
            case 3:
                claveBuscada = "BRL";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen * cotiza;
                break;
            case 4:
                claveBuscada = "BRL";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen / cotiza;
                break;
            case 5:
                claveBuscada = "COP";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen * cotiza;
                break;
            case 6:
                claveBuscada = "COP";
                cotiza = conversionRates.get(claveBuscada).getAsDouble();
                resultado = monedaOrigen / cotiza;
                break;
        }

        String azul = "\u001B[34m";
        String quitarFormato = "\u001B[0m";

        String resultadoFormateado = String.format("%s %,.2f; %s %,.2f",
                "Cotización actual: ", cotiza,
                "resultado =", resultado);
        System.out.println(azul + resultadoFormateado + quitarFormato);



    }

    private static void menu() {
        String verde = "\u001B[32m"; // Color verde
        String rojo = "\u001B[31m"; // Color rojo
        String quitarFormato = "\u001B[0m"; // Resetear color

        System.out.print(verde + """
                --------------------------------------------\u001B[1m \u001B[5m
                            Menú de Opciones
                --------------------------------------------
                 1. Dólar EEUU =>> Peso Argentino (U$D - ARS)
                 2. Peso Argentino =>> Dolar EEUU (ARS - U$D)
                 3. Dólar EEUU =>> Real Brasileño
                 4. Real Brasileño =>> Dolar EEUU
                 5. Dólar EEUU =>> Peso Colombiano
                 6. Peso Colombiano =>> Dolar EEUU
                 7. Actualizar cotización desde API
                 0. Salir
                --------------------------------------------
                    Elija una opción:\s""" + quitarFormato);
    }
}
