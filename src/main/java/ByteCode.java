import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ByteCode {
	public static void main(String[] args) throws ParseException {
		Integer a = new Integer(1);
		Integer b = new Integer(10);
		int r = a + b;
		System.out.println(r);

		String s = "2016-15-13";
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(format.parse(s));
	}
}
