package com.ruoyi.admin.service.impl;

import com.ruoyi.admin.annotation.EnableRedisLock;
import com.ruoyi.admin.domain.SysFileInfo;
import com.ruoyi.admin.mapper.SysFileInfoMapper;
import com.ruoyi.admin.service.ISysFileInfoService;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.exception.user.UserException;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysUser;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-17
 */
@Service
public class SysFileInfoServiceImpl implements ISysFileInfoService 
{
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询【请填写功能名称】
     * 
     * @param fileid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysFileInfo selectSysFileInfoByFileid(Long fileid)
    {
        return sysFileInfoMapper.selectSysFileInfoByFileid(fileid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.selectSysFileInfoList(sysFileInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    @EnableRedisLock
    @GlobalTransactional(rollbackFor = Exception.class)
    public int insertSysFileInfo(SysFileInfo sysFileInfo) throws UserException {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("ygh");
        sysUser.setPassword("123456");
        sysUser.setNickName("guohui");
        sysFileInfoMapper.insertSysFileInfo(sysFileInfo);
        R<Boolean> booleanR = remoteUserService.registerUserInfo(sysUser, "1");
        if (200 != booleanR.getCode()) {
            throw new UserException("100",new Object[]{booleanR.getMsg()});
        }
        String str = null;
        System.out.println("开始事务前");
        if (str.equals("1")) {

      }
        return 1;
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysFileInfo(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.updateSysFileInfo(sysFileInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoByFileids(Long[] fileids)
    {
        return sysFileInfoMapper.deleteSysFileInfoByFileids(fileids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param fileid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoByFileid(Long fileid)
    {
        return sysFileInfoMapper.deleteSysFileInfoByFileid(fileid);
    }
}
