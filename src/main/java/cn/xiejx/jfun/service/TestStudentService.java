package cn.xiejx.jfun.service;


import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.service.dto.TestStudentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;
/**
 * @Author miv
 * @Date 2019-04-09 13:48:50
 */
public interface TestStudentService extends IService<TestStudent> {

    TestStudentDTO create(TestStudent testStudent);

    public IPage<TestStudentDTO> selectTestStudentPage(Page<TestStudent> page,TestStudentDTO testStudentDTO);

    void update(TestStudentDTO testStudentDTO);

    void delete(Long id);
}