package com.aluracursos.screenmatch.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsultaChatGPT {

    private static final String API_URL = "https://api.openai.com/v1/responses";

    public static String obtenerTraduccion(String texto) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            String body = """
                    {
                      "model": "gpt-5-nano",
                      "input": "Traduce a español el siguiente texto: %s"
                    }
                    """.formatted(texto);

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openai.com/v1/responses")).header("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY")).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(body)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 🔍 1. VALIDAR STATUS HTTP
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error OpenAI HTTP " + response.statusCode() + ": " + response.body());
            }

            JsonNode root = mapper.readTree(response.body());

            // 🔍 2. VALIDAR QUE EXISTA OUTPUT
            JsonNode output = root.path("output");
            if (!output.isArray() || output.isEmpty()) {
                throw new RuntimeException("Respuesta OpenAI sin output: " + response.body());
            }

            // 🔍 3. EXTRAER TEXTO DE FORMA SEGURA
            JsonNode content = output.get(0).path("content");
            if (!content.isArray() || content.isEmpty()) {
                throw new RuntimeException("Respuesta OpenAI sin content: " + response.body());
            }

            String textoTraducido = content.get(0).path("text").asText(null);

            if (textoTraducido == null || textoTraducido.isBlank()) {
                throw new RuntimeException("Respuesta OpenAI sin texto: " + response.body());
            }

            return textoTraducido;

        } catch (Exception e) {
            throw new RuntimeException("Error consultando ChatGPT", e);
        }
    }

}
