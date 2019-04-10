package cn.xiejx.jfun.service.impl;


import cn.xiejx.jfun.service.RedisService;
import cn.xiejx.jfun.util.PageUtil;
import cn.xiejx.jfun.vo.Page;
import cn.xiejx.jfun.vo.RedisVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 谢镜勋
 * @Date 2019/4/10
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired // @Qualifier("redisPoolFactory")
    JedisPool pool;

    @Override
    public Page findByKey(String key, Pageable pageable) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            List<RedisVo> redisVos = new ArrayList<>();

            if (!key.equals("*")) {
                key = "*" + key + "*";
            }
            for (String s : jedis.keys(key)) {
                RedisVo redisVo = new RedisVo(s, jedis.get(s));
                redisVos.add(redisVo);
            }
            org.springframework.data.domain.Page<RedisVo> page = new PageImpl<RedisVo>(
                    PageUtil.toPage(pageable.getPageNumber(), pageable.getPageSize(), redisVos),
                    pageable,
                    redisVos.size());

            Page p = new Page();
            p.setRecords(page.getContent());
            p.setTotal(page.getContent().size());
            p.setPage(pageable.getPageNumber());
            return p;
        } finally {
            if (null != jedis) {
                jedis.close(); // 释放资源还给连接池
            }
        }

    }

    @Override
    public void save(RedisVo redisVo) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(redisVo.getKey(), redisVo.getValue());
        } finally {
            if (null != jedis) {
                jedis.close(); // 释放资源还给连接池
            }
        }
    }

    @Override
    public void delete(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.del(key);
        } finally {
            if (null != jedis) {
                jedis.close(); // 释放资源还给连接池
            }
        }

    }

    @Override
    public void flushdb() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.flushDB();
        } finally {
            if (null != jedis) {
                jedis.close(); // 释放资源还给连接池
            }
        }

    }
}
