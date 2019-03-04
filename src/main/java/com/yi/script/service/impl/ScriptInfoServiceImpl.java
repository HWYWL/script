package com.yi.script.service.impl;

import com.yi.script.dao.ScriptInfoMapper;
import com.yi.script.model.ScriptInfo;
import com.yi.script.model.ScriptInfoExample;
import com.yi.script.service.ScriptInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作脚本数据源
 * @author YI
 * @date 2018-4-27 15:55:57
 */
@Service
public class ScriptInfoServiceImpl implements ScriptInfoService {
    @Resource
    ScriptInfoMapper scriptInfoMapper;

    @Override
    public int insertSelective(ScriptInfo record) {
        return scriptInfoMapper.insertSelective(record);
    }

    @Override
    public List<ScriptInfo> selectByExample(ScriptInfoExample example) {
        return scriptInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(ScriptInfo record) {
        return scriptInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ScriptInfo record) {
        return scriptInfoMapper.updateByPrimaryKey(record);
    }
}
