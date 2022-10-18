package exerciciodate;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatter {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		DateFormat[] date = new DateFormat[7];

		// pacote java.text � uma classe abstrata usada para formatar e analisar datas para qualquer localidade.
		date[0] = DateFormat.getInstance();

		// getDateInstance() O m�todo da classe DateFormat em Java � usado para obter o formatador de data.
		date[1] = DateFormat.getDateInstance();

		// Obt�m o formatador de data/hora com os estilos de formata��o de data e hora
		// fornecidos para a localidade padr�o.
		date[2] = DateFormat.getDateTimeInstance();

		// SHORT� completamente num�rico, como 12.13.52ou3:30pm
		date[3] = DateFormat.getDateInstance(DateFormat.SHORT);

		// MEDIUM � mais longo, comoJan 12, 1952
		date[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);

		// LONG � mais longo, como January 12, 1952ou3:30:32pm
		date[5] = DateFormat.getDateInstance(DateFormat.LONG);

		// FULL � bastante especificado, como Tuesday, April 12, 1952 AD or 3:30:42pm
		date[6] = DateFormat.getDateInstance(DateFormat.FULL);

		for (DateFormat dateFormat : date) {
			System.out.println(dateFormat.format(calendar.getTime()));
		}
	}
}
