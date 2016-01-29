package com.zpy.yy.base;

/**
 *
 * 基本mapper接口
 *
 */
public interface BaseMapper<T> {

    /**
     * 新增
     *
     * @param t
     */
    public void save(T t);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 查找
     *
     * @param id
     * @return
     */
    public T findById(Integer id);

    /**
     * 修改
     *
     * @param t
     */
    public void update(T t);

}
