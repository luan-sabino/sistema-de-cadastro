package persistencia;
import java.util.HashMap;
import java.util.Map;

public class Constantes {
	private static final Map<String, Integer> nivelFuncionario = new HashMap<>();
	
	public Constantes() {
		nivelFuncionario.put("T1", 10);
		nivelFuncionario.put("T2", 20);
		nivelFuncionario.put("D1", 5);
		nivelFuncionario.put("D2", 10);
		nivelFuncionario.put("D3", 20);
		nivelFuncionario.put("S1", 5);
		nivelFuncionario.put("S2", 10);
	}
	
	public static int Percentual(String nivel) {
		return nivelFuncionario.get(nivel);
	}
	
}
