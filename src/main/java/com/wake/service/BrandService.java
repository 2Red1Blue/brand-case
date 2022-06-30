package com.wake.service;

import com.wake.pojo.Brand;
import com.wake.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Brand service.
 */
public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 批量删除
     * 这里不加@Param
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize  每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    /**
     * Select by page and condition page bean.
     *分页条件查询
     * @param currentPage the current page
     * @param pageSize    the page size
     * @param brand       the brand
     * @return the page bean
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
