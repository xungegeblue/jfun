package cn.xiejx.jfun.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.service.dto.TestStudentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * @Author miv
 * @Date 2019-04-09 13:48:50
 */
@Mapper
public interface TestStudentMapper extends BaseMapper<TestStudent> {

    public IPage<TestStudent> selectTestStudentPage (IPage<TestStudent> page,@Param(value = "test_student") TestStudentDTO testStudentDTO);
}
