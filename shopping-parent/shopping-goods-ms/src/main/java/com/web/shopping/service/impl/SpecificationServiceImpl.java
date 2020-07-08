package com.web.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.shopping.mapper.TbSpecificationMapper;
import com.web.shopping.mapper.TbSpecificationOptionMapper;
import com.web.shopping.pojo.*;
import com.web.shopping.pojogroup.Specification;
import com.web.shopping.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService{

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Override
    public List<TbSpecification> findAll() {

        return specificationMapper.selectByExample(null);

    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>)specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;




    @Override
    public void update(Specification specification) {
          specificationMapper.updateByPrimaryKey(specification.getSpecification());

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();

        criteria.andSpecIdEqualTo(specification.getSpecification().getId());

        specificationOptionMapper.deleteByExample(example);

        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {

            specificationOption.setSpecId(specification.getSpecification().getId());

            specificationOptionMapper.insert(specificationOption);

        }
    }

    @Override
    public void add(Specification specification) {
        specificationMapper.insert(specification.getSpecification());
        for (TbSpecificationOption specificationOption:specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public void deleteManySpecific(int[] ids) {
        for(long id: ids){
            specificationMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<TbSpecification> querySpecificationByName(String searchName) {
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        List<TbSpecification> list = (List<TbSpecification>)criteria.andSpecNameLike("%"+searchName+"%");
        return list;
    }

    @Override
    public List<Map> selectSpecificationsOptionList() {
        return specificationMapper.selectOptionList();
    }


    @Override
    public Specification findSpecificationById(long id) {

        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);

        List<TbSpecificationOption> tbSpecificationOptions = specificationOptionMapper.selectByExample(example);
        Specification specification = new Specification();
        specification.setSpecification(tbSpecification);
        specification.setSpecificationOptionList(tbSpecificationOptions);

        return specification;
    }
}
