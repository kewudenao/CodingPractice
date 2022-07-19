package collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author zhujinman 2022-06-08 19:20
 **/
public class test {
	public static final String ssl_ca = "C:\\Users\\Administrator\\Desktop\\DigiCertGlobalRootCA.crt.pem";
	public static void main(String[] args) throws Exception {
		String importCert = " -import "+
				" -alias mysqlServerCACert "+
				" -file " + ssl_ca +
				" -keystore truststore "+
				" -trustcacerts " +
				" -storepass password -noprompt ";
		String genKey = " -genkey -keyalg rsa " +
				" -alias mysqlClientCertificate -keystore keystore " +
				" -storepass password123 -keypass password " +
				" -dname CN=MS ";
		System.out.println(importCert);
		System.out.println(genKey);
//		sun.security.tools.keytool.Main.main(importCert.trim().split("\\s+"));
//		sun.security.tools.keytool.Main.main(genKey.trim().split("\\s+"));
//		sun.security.tools.keytool.Main.main(importCert.trim().split("\\s+"));
//		sun.security.tools.keytool.Main.main(genKey.trim().split("\\s+"));

// use the generated keystore and truststore

		System.setProperty("javax.net.ssl.keyStore","D:\\Code\\CodingPractice\\keystore");
		System.setProperty("javax.net.ssl.keyStorePassword","password");
		System.setProperty("javax.net.ssl.trustStore","D:\\Code\\CodingPractice\\truststore");
		System.setProperty("javax.net.ssl.trustStorePassword","password");
		Class.forName("com.mysql.jdbc.Driver");
		String url = String.format("jdbc:mysql://%s/%s?serverTimezone=UTC&useSSL=true", "backuptest01181600.mysqldb.chinacloudapi.cn:3306", "prodmysql");
		Properties properties = new Properties();
		properties.setProperty("user", "backuptest01181600%john");
		properties.setProperty("password", "qwer1234!@#$");
		Connection connection = DriverManager.getConnection(url, properties);
		connection.getTypeMap();
	}
}
