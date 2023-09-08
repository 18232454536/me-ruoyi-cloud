package com.ruoyi.admin.mapper;

import com.ruoyi.admin.domain.SysFileInfo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-17
 */
public interface SysFileInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param fileid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysFileInfo selectSysFileInfoByFileid(Long fileid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysFileInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param fileid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysFileInfoByFileid(Long fileid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFileInfoByFileids(Long[] fileids);
}
