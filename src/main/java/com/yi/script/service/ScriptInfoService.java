package com.yi.script.service;

import com.yi.script.model.ScriptInfo;
import com.yi.script.model.ScriptInfoExample;

import java.util.List;

/**
 * 脚本数据接口
 * @author YI
 * @date 2018-4-27 16:00:59
 */
public interface ScriptInfoService {
    long countByExample(ScriptInfoExample example);

    int deleteByExample(ScriptInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScriptInfo record);

    int insertSelective(ScriptInfo record);

    List<ScriptInfo> selectByExample(ScriptInfoExample example);

    ScriptInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(ScriptInfo record, ScriptInfoExample example);

    int updateByExample(ScriptInfo record, ScriptInfoExample example);

    int updateByPrimaryKeySelective(ScriptInfo record);

    int updateByPrimaryKey(ScriptInfo record);
}
