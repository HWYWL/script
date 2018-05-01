package com.yi.script.service.impl;

import com.yi.script.dao.ScriptInfoMapper;
import com.yi.script.model.ScriptInfo;
import com.yi.script.model.ScriptInfoExample;
import com.yi.script.service.ScriptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作脚本数据源
 * @author YI
 * @date 2018-4-27 15:55:57
 */
@Service
public class ScriptInfoServiceImpl implements ScriptInfoService {
    @Autowired
    ScriptInfoMapper scriptInfodao;

    @Override
    public long countByExample(ScriptInfoExample example) {
        return scriptInfodao.countByExample(example);
    }

    @Override
    public int deleteByExample(ScriptInfoExample example) {
        return scriptInfodao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return scriptInfodao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ScriptInfo record) {
        return scriptInfodao.insert(record);
    }

    @Override
    public int insertSelective(ScriptInfo record) {
        return scriptInfodao.insertSelective(record);
    }

    @Override
    public List<ScriptInfo> selectByExample(ScriptInfoExample example) {
        return scriptInfodao.selectByExample(example);
    }

    @Override
    public ScriptInfo selectByPrimaryKey(Long id) {
        return scriptInfodao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ScriptInfo record, ScriptInfoExample example) {
        return scriptInfodao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ScriptInfo record, ScriptInfoExample example) {
        return scriptInfodao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ScriptInfo record) {
        return scriptInfodao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ScriptInfo record) {
        return scriptInfodao.updateByPrimaryKey(record);
    }
}
