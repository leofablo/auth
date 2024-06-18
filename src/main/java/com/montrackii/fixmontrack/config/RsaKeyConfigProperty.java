package com.montrackii.fixmontrack.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyConfigProperty (RSAPublicKey publicKey, RSAPrivateKey privateKey){

}
