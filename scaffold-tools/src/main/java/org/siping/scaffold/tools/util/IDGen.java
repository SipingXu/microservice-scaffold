package org.siping.scaffold.tools.util;


import java.util.UUID;

/**
 * @author Siping
 * id生成器
 */
public class IDGen {

    public static String genId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
