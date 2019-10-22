package utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyPasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {

        return BCrypt.hashpw(rawPassword.toString(),BCrypt.gensalt(12));

    }

    private String getMD5(CharSequence rawPassword) {
        String resultPassword= null;
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(rawPassword.toString().getBytes());
            resultPassword=new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return resultPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return BCrypt.checkpw(rawPassword.toString(),encodedPassword);
    }

}
