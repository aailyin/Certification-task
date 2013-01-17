package util;

import java.util.UUID;

/**
 * @author aa.ilyin
 * Class IdGenerator is intended for generating a unique id for posters.
 */
public class IdGenerator {

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}