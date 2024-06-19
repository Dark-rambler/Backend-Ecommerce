package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

public class SpanishEntityNameProvider {
  private static final Map<String, String> NAME_MAP = new HashMap<>();

  static {
    NAME_MAP.put("Transaction", "transacción");
    NAME_MAP.put("DocumentType", "Tipo de documento");
  }

  public static String getSpanishName(String englishName) {
    return NAME_MAP.getOrDefault(englishName, englishName);
  }
}
