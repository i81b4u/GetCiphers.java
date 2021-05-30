# GetCiphers.java
Get supported protocols and ciphers from java

Simple code that lists the supported protocols and ciphers because in newer java versions the following code does not work anymore:

jrunscript -e "java.util.Arrays.asList(javax.net.ssl.SSLServerSocketFactory.getDefault().getSupportedCipherSuites()).stream().forEach(println)"
