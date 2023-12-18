package com.example.demospringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demospringboot.entity.InviteCode;

/**
 * desc 正常情况下肯定不会吧邀请码直接放到数据库，而是放到redis中并设置过期时间。我这里还没有添加redis就放到数据库了。
 */
@Mapper
public interface InviteCodeMapper {
  public int createInviteCode(InviteCode inviteCode);
}
