package grupo_04.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTFormatter {

	public static void main(String[] args) {

		/*
		 * DateTimeFormatter: Permite fazer vários tipos de formatação diferentes,
		 * conseguimos exibir como String a data de várias formas e pegar String e
		 * transformar em data de várias formas também.
		 */

		// Formato de data e o mais curto
		DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		// Defino o formato que eu quero
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);

		System.out.println("====Date Time Formatter====");
		String format1 = formatter1.format(dateTime);
		System.out.println(format1);
		
		String format2 = formatter2.format(dateTime);
		System.out.println(format2);
	}

}
