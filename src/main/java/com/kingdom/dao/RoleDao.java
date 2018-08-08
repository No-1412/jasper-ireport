package com.kingdom.dao;

import com.kingdom.model.Role;

@DaoType
public interface RoleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Role record);

    void saveRoleMenu(Role role);
}