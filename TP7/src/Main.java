import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {

		String key = "MzJPF68KYbwEXaqFr3rasHfabgXU5dcd";
		String champ[] = null;
		String distance = null;
		String depart[] = new String[4];
		String arrive[] = new String[4];

		System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
		System.setProperty("http.proxyPort", "3128");

		URL u = new URL("http://open.mapquestapi.com/directions/v2/route?key=KEY&from=Lille&to=Paris");
	}
}
