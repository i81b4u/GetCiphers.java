import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SSLContextWrapper implements AutoCloseable {
    private final SSLContext sslContext;

    public SSLContextWrapper(String protocol) throws NoSuchAlgorithmException, KeyManagementException {
        this.sslContext = SSLContext.getInstance(protocol);
        this.sslContext.init(null, null, null);
    }

    public SSLContext getSSLContext() {
        return sslContext;
    }

    @Override
    public void close() throws Exception {
        // You might want to add cleanup logic here if needed
    }
}

public class getCiphers {
    public static void main(String[] args) {
        try {
            // Use try-with-resources with SSLContextWrapper
            try (final SSLContextWrapper sslContextWrapper = new SSLContextWrapper("TLS")) {
                final SSLContext sslContext = sslContextWrapper.getSSLContext();

                // Rest of your code for retrieving and printing protocols and ciphers
                final List<String> supportedProtocols = Arrays.asList(sslContext.getSupportedSSLParameters().getProtocols());
                final List<String> supportedCipherSuites = Arrays.asList(sslContext.getSupportedSSLParameters().getCipherSuites());

                Collections.sort(supportedProtocols);
                Collections.sort(supportedCipherSuites);

                System.out.println("Supported TLS Protocols:");
                for (String protocol : supportedProtocols) {
                    System.out.println(protocol);
                }

                System.out.println();

                System.out.println("Supported Cipher Suites:");
                for (String cipher : supportedCipherSuites) {
                    System.out.println(cipher);
                }
            }
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            // Handle exceptions, maybe print an error message
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
