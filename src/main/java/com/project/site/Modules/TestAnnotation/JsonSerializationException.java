package com.project.site.Modules.TestAnnotation;

public class JsonSerializationException extends Exception {
    public JsonSerializationException(String message) {
        throw new RuntimeException(message);
    }
}
