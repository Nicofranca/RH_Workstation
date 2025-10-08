package org.rhworkstation.context;

public class CacheContext {

    private static String cacheCpf;

    public CacheContext(){}

    public static void setCacheCpf(String cpf) {
        cacheCpf = cpf;
    }

    public static String getCacheCpf() {
        return cacheCpf;
    }
}
