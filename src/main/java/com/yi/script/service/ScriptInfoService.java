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
    int insertSelective(ScriptInfo record);

    List<ScriptInfo> selectByExample(ScriptInfoExample example);

    int updateByPrimaryKeySelective(ScriptInfo record);

    int updateByPrimaryKey(ScriptInfo record);
}
