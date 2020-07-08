package com.web.shopping.service;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.TbSpecification;
import com.web.shopping.pojogroup.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationService {
    public List<TbSpecification> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public void update(Specification specification);

    public void add(Specification specification);

    public Specification findSpecificationById(long id);

    public void deleteManySpecific(int[] ids);

    public List<TbSpecification> querySpecificationByName(String searchName);

    public List<Map> selectSpecificationsOptionList();

}
