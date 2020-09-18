package com.titanic.javatest.serializable;

import java.io.*;
import java.util.Base64;

public class Serializer {

    public String serialize(Object object) {
        /*
         * 자바 직렬화 : ObjectOutputStream을 이용한다
         */
        byte[] serialized;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(object);
                serialized = baos.toByteArray();

                // 바이트로 변환된 (직렬화된) 결과를 String으로 인코딩
                return Base64.getEncoder().encodeToString(serialized);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Object deserialize(String serialized) {
        /*
         * 자바 역직렬화 : ObjectInputStream을 이용한다.
         */
        byte[] serializedSingleton = Base64.getDecoder().decode(serialized);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedSingleton)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                Object objectAccount = ois.readObject();
                return objectAccount;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
