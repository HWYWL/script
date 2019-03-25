package com.yi.script.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import com.yi.script.model.Message;
import com.yi.script.model.Script;
import com.yi.script.model.ScriptInfo;
import com.yi.script.model.ScriptInfoExample;
import com.yi.script.model.ScriptInfoExample.Criteria;
import com.yi.script.service.ScriptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.util.List;

/**
 * 数据源访问
 * @author YI
 * @date 2018-4-27 16:11:21
 */
@Controller
public class ScriptController {
    @Autowired
    ScriptInfoService scriptInfoService;

    private static final int PORT = 22;

    /**
     * 主机页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 脚本页
     * @return
     */
    @RequestMapping("/scriptHome")
    public String scriptHome(){
        return "scriptHome";
    }

    /**
     * 打开添加脚本页面
     * @return
     */
    @RequestMapping("/addScript")
    public String addScript(){
        return "script/addScript";
    }

    /**
     * 获取所有脚本数据
     * @return
     */
    @RequestMapping("/fidnAllScript")
    @ResponseBody
    public Message fidnAllScript(){
        ScriptInfoExample scriptInfoExample = new ScriptInfoExample();
        Criteria criteria = scriptInfoExample.createCriteria();

        criteria.andDelNotEqualTo((byte)-1);

        Message message = new Message();
        try {
            //把查询到的数据转换为数组
            List<ScriptInfo> scriptInfoList = scriptInfoService.selectByExample(scriptInfoExample);
            ScriptInfo[] scriptInfos = new ScriptInfo[scriptInfoList.size()];
            ScriptInfo[] infos = scriptInfoList.toArray(scriptInfos);

            message.setCode(0);
            message.setCount(scriptInfoList.size());
            message.setData(infos);
            message.setMsg("数据查询成功");
        }catch (Exception e){
            message.setCode(-1);
            message.setMsg("数据查询失败");
        }

        return message;
    }

    /**
     * 根据id删除数据
     * @param scriptInfo
     * @return
     */
    @RequestMapping(value = "/delID", method = RequestMethod.POST)
    @ResponseBody
    public Message delID(@RequestBody ScriptInfo scriptInfo){
        Message message = new Message();

        scriptInfo.setDel((byte)-1);
        int key = scriptInfoService.updateByPrimaryKey(scriptInfo);

        if (key > 0){
            message.setCode(0);
            message.setMsg("数据删除成功!");
        }else {
            message.setCode(-1);
            message.setMsg("数据删除失败!");
        }

        return message;
    }

    /**
     * 查看脚本
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView detail(Long id) {
        ModelAndView modelAndView = new ModelAndView("script/code");

        Message message = new Message();
        ScriptInfoExample scriptInfoExample = new ScriptInfoExample();
        Criteria criteria = scriptInfoExample.createCriteria();

        criteria.andIdEqualTo(id);
        List<ScriptInfo> scriptInfoList = scriptInfoService.selectByExample(scriptInfoExample);

        if (scriptInfoList != null && scriptInfoList.size() > 0){
            ScriptInfo scriptInfo = scriptInfoList.get(0);
            Byte type = scriptInfo.getType();
            try {
                //读取读命令
                if (Script.RED.getValue() == type || Script.BLANK.getValue() == type){
                    message.setData(scriptInfo.getCommand());
                }else if (Script.YELLO.getValue() == type){
                    //读取本地windows脚本
                    BufferedReader reader = FileUtil.getReader(scriptInfo.getPath(), "UTF-8");

                    String str = null;
                    StringBuffer stringBuffer = new StringBuffer();

                    while((str=reader.readLine()) != null){
                        stringBuffer.append(str + "\n");
                    }

                    message.setData(stringBuffer.toString());
                }else if (Script.GREEN.getValue() == type){
                    //读取远程linux脚本
//                    FileAttributes attributes = SshGetFile.getMessage(scriptInfo.getHost(), PORT, scriptInfo.getUserName(), scriptInfo.getPassWord(), scriptInfo.getPath());
                    message.setMsg("暂时不支持Linux文件读取!");
                    message.setData("暂时不支持Linux文件读取!");
                }else {
                    message.setCode(-1);
                    message.setMsg("数据读取失败,只能读取本都资源!");
                }
            }catch (Exception e){
                message.setCode(-1);
                message.setMsg("数据读取失败,请检查目录是否正确!");
                message.setData(e.getMessage());
            }

        }

        modelAndView.addObject("message", message);

        return modelAndView;
    }


    /**
     * 执行脚本
     * @param id
     * @return
     */
    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView execute(Long id){
        ModelAndView modelAndView = new ModelAndView("script/code");
        Message message = new Message();

        ScriptInfoExample scriptInfoExample = new ScriptInfoExample();
        Criteria criteria = scriptInfoExample.createCriteria();

        criteria.andIdEqualTo(id);

        try {
            List<ScriptInfo> scriptInfoList = scriptInfoService.selectByExample(scriptInfoExample);
            ScriptInfo scriptInfo = scriptInfoList.get(0);
            if (scriptInfo != null && scriptInfo.getEnable() == 0) {
                Byte type = scriptInfo.getType();
                String str;
                if (Script.BLANK.getValue() == type || Script.YELLO.getValue() == type) {
                    str = RuntimeUtil.execForStr(scriptInfoList.get(0).getCommand());
                } else {
                    Session session = JschUtil.getSession(scriptInfo.getHost(), PORT, scriptInfo.getUserName(), scriptInfo.getPassWord());
                    str = JschUtil.exec(session, scriptInfo.getCommand(), CharsetUtil.CHARSET_UTF_8);
                }

                message.setData(str);
            }else {
                message.setMsg("已失效,请关闭失效开关再执行！");
                message.setData(scriptInfo);
                message.setCode(-1);
            }
        }catch (Exception e){
            message.setMsg("执行失败！");
            message.setData(e.getMessage());
            message.setCode(-1);
        }

        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Message save(@RequestBody ScriptInfo scriptInfo){
        Message message = new Message();
        try {
            if (scriptInfo != null && scriptInfo.getType() == Script.YELLO.getValue()){
                scriptInfo.setCommand(scriptInfo.getCommand().replace("\\", "/"));
                scriptInfo.setPath(scriptInfo.getPath().replace("\\", "/"));
            }

            scriptInfoService.insertSelective(scriptInfo);
            message.setMsg("数据提交成功!");
        }catch (Exception e){
            message.setMsg("保存失败！");
            message.setData(e.getMessage());
            message.setCode(-1);
        }

        return message;
    }

    @RequestMapping(value = "/updata", method = RequestMethod.POST)
    @ResponseBody
    public Message updata(@RequestBody ScriptInfo scriptInfo){
        Message message = new Message();
        try {
            scriptInfoService.updateByPrimaryKeySelective(scriptInfo);
            message.setMsg("状态更改成功!");
        }catch (Exception e){
            message.setMsg("状态更改失败！");
            message.setData(e.getMessage());
            message.setCode(-1);
        }

        return message;
    }
}
