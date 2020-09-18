package com.titanic.javatest.serializable;

import java.io.*;
import java.util.Base64;

public class Serializer {

    public static void main(String[] args) {


    }

    public String serialize(Account account) {
        /*
         * 자바 직렬화 : ObjectOutputStream을 이용한다
         */
        byte[] serializedAccount;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(account);
                serializedAccount = baos.toByteArray();

                // 바이트로 변환된 (직렬화된) 결과를 String으로 인코딩
                return Base64.getEncoder().encodeToString(serializedAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Account deserialize(byte[] serializedAccount) {
        /*
         * 자바 역직렬화 : ObjectInputStream을 이용한다.
         */
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedAccount)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                Object objectAccount = ois.readObject();
                return (Account) objectAccount;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
