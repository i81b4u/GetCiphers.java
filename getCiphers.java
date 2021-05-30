import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLContext;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {

	final SSLContext sslContext = SSLContext.getInstance("TLS");
	sslContext.init(null, null, null);
	final List<String> supportedProtocols = Arrays.asList(sslContext.getSupportedSSLParameters().getProtocols());
	final List<String> supportedCipherSuites = Arrays.asList(sslContext.getSupportedSSLParameters().getCipherSuites());

	Collections.sort(supportedProtocols);
	Collections.sort(supportedCipherSuites);

	System.out.println("Protocols:");
	for (String Protocols: supportedProtocols) {
		System.out.println(Protocols);
	}

	System.out.println();

	System.out.println("Ciphers:");
	for (String Ciphers: supportedCipherSuites) {
		System.out.println(Ciphers);
	}
    }
}
