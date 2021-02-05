package com.zh.limit.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangHai
 * @Date: 2021/2/5 16:36
 */
public class ExpireHashMap<K, V> {
    private Map<K, Map<String, Object>> _map = new HashMap<>();
    private final static String EXPIRE_KEY = "expire";
    private final static String VALUE_KEY = "value";
    public ExpireHashMap(){};
    public void put(K key, V value, long expire){
        this._map.put(key, new HashMap(){
            {
                put("value", value);
                put("expire", new Date().getTime() + expire);
            }
        });
    }
    public V get(K key){
        if(!this._map.containsKey(key)){
            return null;
        }
        if (this.isExpire(key)){
            this._map.remove(key);
            return null;
        }else {
            return (V)this._map.get(key).get(VALUE_KEY);
        }
    }

    public boolean isExpire(K key){
        Long expire = (Long) this._map.get(key).get(EXPIRE_KEY);
        if (new Date().getTime() > expire){
            return true;
        }else{
            return false;
        }
    }

    public long expire(K key){
        return this._map.containsKey(key)?(long)this._map.get(key).get(EXPIRE_KEY):0l;
    }
}
