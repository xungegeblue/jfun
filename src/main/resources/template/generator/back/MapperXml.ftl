<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.xiejx.jfun.dao.${className}Mapper">


    <select id="select${className}Page" resultType="cn.xiejx.jfun.entity.${className}">
        select * from ${tableName}
    </select>

</mapper>