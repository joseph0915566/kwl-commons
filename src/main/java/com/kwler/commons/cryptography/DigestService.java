package com.kwler.commons.cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class DigestService {

    public byte[] getDigest(byte[] data) {
    	return getDigest(data, DigestAlgorithm.SHA_256);
    }

    public byte[] getDigest(byte[] data, DigestAlgorithm algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.getName());
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
