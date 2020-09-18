package com.titanic.javatest.serializable;

import java.io.*;
import java.util.Base64;

public class SerializableTest {

    public static void main(String[] args) {

        /*
         * 자바 직렬화 : ObjectOutputStream을 이용한다
         */
        Account account = Account.of("jack", "010-7720-7954", 28);
        byte[] serializedAccount = new byte[1000];

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(account);
                serializedAccount = baos.toByteArray();

                // 바이트로 변환된 (직렬화된) 결과를 String으로 인코딩
                System.out.println(Base64.getEncoder().encodeToString(serializedAccount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 자바 역직렬화 : ObjectInputStream을 이용한다.
         */
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedAccount)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                Object objectAccount = ois.readObject();
                Account accountFromSerialized = (Account) objectAccount;
                System.out.println(accountFromSerialized);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
