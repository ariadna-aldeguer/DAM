import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	
	public static int compareTo(String unaFecha, String otraFecha) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date data1 = format.parse(unaFecha);
		Date data2 = format.parse(otraFecha);

		if (data1.compareTo(data2) < 0) {
		    return 1;
		} else if (data1.compareTo(data2) > 0){
			return -1;
		} else {
			return 0;
		}
	}
	
	public static String getAnyoDeFecha(String fecha) {
		String [] fechaPartes = fecha.split(".");	
		return fechaPartes[2];
	}
	public static String getFechaActual() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
}
