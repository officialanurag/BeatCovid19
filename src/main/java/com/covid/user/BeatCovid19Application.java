package com.covid.user;

import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bol.crypt.CryptVault;
import com.bol.secure.CachedEncryptionEventListener;

@SpringBootApplication
public class BeatCovid19Application {
	
	public static void main(String[] args) {
		SpringApplication.run(BeatCovid19Application.class, args);
		System.out.println("App is running.....");
	}
	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener() {
	    return new ValidatingMongoEventListener(validator());
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
	    return new LocalValidatorFactoryBean();
	}
	@Bean
	public CryptVault cryptVault() {
		final byte[] secretKey = Base64.getDecoder().decode("hqHKBLV83LpCqzKpf8OvutbCs+O5wX5BPu3btWpEvXA=");
	    final byte[] oldKey = Base64.getDecoder().decode("cUzurmCcL+K252XDJhhWI/A/+wxYXLgIm678bwsE2QM=");

	return new CryptVault()
	         .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(0, oldKey)
	         .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(1, secretKey)
	         // can be omitted if it's the highest version
	         .withDefaultKeyVersion(1);
	}

	@Bean
	public CachedEncryptionEventListener encryptionEventListener(CryptVault cryptVault) {
	   return new CachedEncryptionEventListener(cryptVault);
	}

}
