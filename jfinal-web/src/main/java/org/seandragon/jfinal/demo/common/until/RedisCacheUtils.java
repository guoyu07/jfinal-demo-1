package org.seandragon.jfinal.demo.common.until;

import pro.mojo.redis.dao.RedisAdapter;

import java.io.*;

/**
 * Created by nanusl on 2016/12/14/0014.
 * 方便操作Redis缓存
 */
public class RedisCacheUtils {

    private static boolean commit() {
        return true;
    }


    /**
     * @param key   键
     * @param value 值
     */
    public static void addCache(String key, String value) throws Exception {
        if (commit())
            RedisAdapter.selectHost("redis-cache").set(key, value);
    }

    /**
     * @param key   键
     * @param value 值
     */
    public static void addCache(byte[] key, byte[] value) throws Exception {
        if (commit())
            RedisAdapter.selectHost("redis-cache").set(key, value);
    }

//    /**
//     * @param key 键
//     * @param value 值
//     * @param time 存活时间(秒)
//     */
//    public static void addCache(byte[] key, byte[] value, int time) {
//        lockAdapter.set(key, value, time);
//    }


    /**
     * @param key 键
     */
    public static String getCache(String key) throws Exception {
        if (commit())
            return RedisAdapter.selectHost("redis-cache").get(key);
        return null;
    }

    /**
     * @param key 键
     */
    public static byte[] getCache(byte[] key) throws Exception {
        if (commit())
            return RedisAdapter.selectHost("redis-cache").get(key);
        return null;
    }

//    /**
//     * @param key 键
//     */
//    public static void delete(String key){
//        cacheAdapter.del(key);
//    }

    /**
     * Object转byte[]
     *
     * @param obj
     * @return
     */
    public static byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * byte[]转Object
     *
     * @param bytes
     * @return
     */
    public static Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

}
