package exerciciodate;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatter {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		DateFormat[] date = new DateFormat[7];

		// pacote java.text é uma classe abstrata usada para formatar e analisar datas para qualquer localidade.
		date[0] = DateFormat.getInstance();

		// getDateInstance() O método da classe DateFormat em Java é usado para obter o formatador de data.
		date[1] = DateFormat.getDateInstance();

		// Obtém o formatador de data/hora com os estilos de formatação de data e hora
		// fornecidos para a localidade padrão.
		date[2] = DateFormat.getDateTimeInstance();

		// SHORTé completamente numérico, como 12.13.52ou3:30pm
		date[3] = DateFormat.getDateInstance(DateFormat.SHORT);

		// MEDIUM é mais longo, comoJan 12, 1952
		date[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);

		// LONG é mais longo, como January 12, 1952ou3:30:32pm
		date[5] = DateFormat.getDateInstance(DateFormat.LONG);

		// FULL é bastante especificado, como Tuesday, April 12, 1952 AD or 3:30:42pm
		date[6] = DateFormat.getDateInstance(DateFormat.FULL);

		for (DateFormat dateFormat : date) {
			System.out.println(dateFormat.format(calendar.getTime()));
		}
	}
}
