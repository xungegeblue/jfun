package cn.xiejx.jfun.service.impl;

import cn.xiejx.jfun.config.exection.BadRequestException;
import cn.xiejx.jfun.config.exection.EntityExistException;
import cn.xiejx.jfun.dao.TestStudentMapper;
import cn.xiejx.jfun.entity.TestStudent;
import cn.xiejx.jfun.service.TestStudentService;
import cn.xiejx.jfun.service.dto.TestStudentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
/**
 * @Author miv
 * @Date 2019-04-09 13:48:50
 */
@Slf4j
@Service
public class TestStudentServiceImpl extends ServiceImpl<TestStudentMapper, TestStudent> implements TestStudentService {
    @Autowired
    private TestStudentMapper testStudentMapper;

    @Override
    public TestStudentDTO create(TestStudent testStudent){
        if(testStudent.getId()!=null){
            throw new BadRequestException("新添加的对象不可以有ID");
        }
        testStudentMapper.insert(testStudent);
        TestStudentDTO testStudentDTO = new TestStudentDTO();
        BeanUtils.copyProperties(testStudent,testStudentDTO);
        return testStudentDTO;
    }
    @Override
    public IPage<TestStudentDTO> selectTestStudentPage(Page<TestStudent> page,TestStudentDTO testStudentDTO){
        IPage<TestStudent> dbPage = testStudentMapper.selectTestStudentPage(page,testStudentDTO);
        IPage<TestStudentDTO> pages = new Page();
        pages.setCurrent(dbPage.getCurrent());
        pages.setPages(dbPage.getPages());
        pages.setSize(dbPage.getSize());
        pages.setTotal(dbPage.getTotal());

        List<TestStudentDTO> dtos = new ArrayList<>();
            dbPage.getRecords().forEach(it->{
            TestStudentDTO dto = new TestStudentDTO();
            BeanUtils.copyProperties(it,dto);
            dtos.add(dto);
        });
        pages.setRecords(dtos);
        return pages;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(TestStudentDTO testStudentDTO){
        TestStudent testStudent = testStudentMapper.selectById(testStudentDTO.getId());
        if(testStudent==null){
            throw new EntityExistException(TestStudent.class,"id",testStudent.getId()+"");
        }
        //TODO  手动把DTO对象的属性设置到testStudent
        testStudentMapper.updateById(testStudent);
    }

    @Override
    public void delete(Long id){
        testStudentMapper.deleteById(id);
    }
}