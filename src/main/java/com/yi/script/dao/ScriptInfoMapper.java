package com.yi.script.dao;

import com.yi.script.model.ScriptInfo;
import com.yi.script.model.ScriptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 操作脚本数据库
 * @author YI
 * @date 2018-5-2 09:22:38
 */
public interface ScriptInfoMapper {
    long countByExample(ScriptInfoExample example);

    int deleteByExample(ScriptInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScriptInfo record);

    int insertSelective(ScriptInfo record);

    List<ScriptInfo> selectByExample(ScriptInfoExample example);

    ScriptInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScriptInfo record, @Param("example") ScriptInfoExample example);

    int updateByExample(@Param("record") ScriptInfo record, @Param("example") ScriptInfoExample example);

    int updateByPrimaryKeySelective(ScriptInfo record);

    int updateByPrimaryKey(ScriptInfo record);
}