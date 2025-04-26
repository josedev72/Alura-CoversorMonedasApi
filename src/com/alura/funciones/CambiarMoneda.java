package com.alura.funciones;

import com.alura.modelos.Cambio;
import com.alura.modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CambiarMoneda {

    public JsonObject cargarCotizacion(){
        //double monedaDestino = 0;
        //String direccion = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/" + obtenerOrigenDestino(opcion);
        //Moneda moneda;

        JsonObject conversionRates = new JsonObject();

        try {
            // Setting URL
            String api_Key = "51bdf0a4ae35b4ce46acc03e";
            String url_str = "https://v6.exchangerate-api.com/v6/" + api_Key + "/latest/USD";

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accediendo al object
            String req_result = jsonobj.get("result").getAsString();

            if (!req_result.equals("error")) {
                System.out.println("req_result = " + req_result);
                conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener cotización: " + e.getMessage());
        }
        return conversionRates;
    }

    private String obtenerOrigenDestino(int opcion) {
        String cambio = "";
        switch (opcion){
            case 1:
                cambio="ARS/USS";
                break;
            case 2:
                cambio="USS/ARS";
                break;
            case 3:
                cambio="";
                break;
            case 4:
                cambio="";
                break;
            case 5:
                cambio="";
                break;
            case 6:
                cambio="";
                break;
            default:
                cambio="";
                break;
        }
        return cambio;
    }

//    public double cambiar(int opcion, double valor){
//        double monedaDestino = 0;
//        String direccion = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/" + obtenerOrigenDestino(opcion);
//        Moneda moneda;
//
//        try {
//            // Setting URL
//            String api_Key = "51bdf0a4ae35b4ce46acc03e";
//            String url_str = "https://v6.exchangerate-api.com/v6/" + api_Key + "/latest/USD";
//
//            // Making Request
//            URL url = new URL(url_str);
//            HttpURLConnection request = (HttpURLConnection) url.openConnection();
//            request.connect();
//
//            // Convert to JSON
//            JsonParser jp = new JsonParser();
//            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//            JsonObject jsonobj = root.getAsJsonObject();
//
//            // Accediendo al object
//            String req_result = jsonobj.get("result").getAsString();
//
//            System.out.println("req_result = " + req_result);
//
//            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
//
//
////            conversionRates.entrySet().forEach(entry -> {
////                        System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
////                    });
//            String claveBuscada = "";
//            double valorEncontrado = 0;
//            double resultado = 0;
//
//            switch (opcion){
//                case 1:
//                    claveBuscada = "ARS";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor * valorEncontrado;
//                    break;
//                case 2:
//                    claveBuscada = "ARS";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor / valorEncontrado;
//                    break;
//                case 3:
//                    claveBuscada = "BRL";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor * valorEncontrado;
//                    break;
//                case 4:
//                    claveBuscada = "BRL";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor / valorEncontrado;
//                    break;
//                case 5:
//                    claveBuscada = "COP";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor * valorEncontrado;
//                    break;
//                case 6:
//                    claveBuscada = "COP";
//                    valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
//                    resultado = valor / valorEncontrado;
//                    break;
//            }
//
//            String azul = "\u001B[34m";
//            String reset = "\u001B[0m";
//            System.out.println(azul + "País buscado = " + claveBuscada + ", cotización = " + valorEncontrado + ", resultado = " + resultado + reset);
//
////            String claveBuscada = "ARS";
////            double valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
////            System.out.println("valor Buscado en Pesos Argentinos = " + valorEncontrado);
////
////            claveBuscada = "BRL";
////            valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
////            System.out.println("valor Buscado en Reales Brasileños = " + valorEncontrado);
////
////            claveBuscada = "COP";
////            valorEncontrado = conversionRates.get(claveBuscada).getAsDouble();
////            System.out.println("valor Buscado en Pesos Colombianos = " + valorEncontrado);
//
//            // ARS	Argentine Peso	Argentina
//            // BRL	Brazilian Real	Brazil
//            // COP	Colombian Peso	Colombia
//
//
//        } catch (Exception e) {
//            System.out.println("Error al convertir moneda origen, " + e.getMessage());
//            monedaDestino = 0;
//        }
//        return monedaDestino;
//    }


}
