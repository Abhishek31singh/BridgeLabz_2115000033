package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

class MergeJsonObjects {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        String json1 = "{\"name\":\"John\", \"age\":30}";
        String json2 = "{\"email\":\"john@example.com\", \"city\":\"New York\"}";

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        JsonNode mergedNode = node1.deepCopy();
        ((ObjectNode) mergedNode).setAll((ObjectNode) node2);

        System.out.println("Merged JSON: " + mergedNode.toString());
    }
}
