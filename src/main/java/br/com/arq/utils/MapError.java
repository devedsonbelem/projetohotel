package br.com.arq.utils;

import java.util.Map;
import java.util.TreeMap;

public class MapError {

	
	private  static Map<String,Object> mapa= new TreeMap<String,Object>();
	static {
		mapa.put("404", "Quarto Nao ENcontrado");
		mapa.put("500", "Erro Interno");
		mapa.put("400","Bad Request");
	}
	public static Map<String,Object> getMapa() {
        return mapa;
    }
}
