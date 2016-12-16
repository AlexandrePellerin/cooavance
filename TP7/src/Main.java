import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

	private final static String KEY = "MzJPF68KYbwEXaqFr3rasHfabgXU5dcd";

	public static void main(String[] args) throws Exception {

		String champ[] = null;
		String distance = null;
		String depart[] = new String[4];
		String arrive[] = new String[4];

		System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
		System.setProperty("http.proxyPort", "3128");

		URL u = new URL("http://open.mapquestapi.com/directions/v2/route?key=" + KEY + "&from=Lille&to=Paris");
		URLConnection c = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}
