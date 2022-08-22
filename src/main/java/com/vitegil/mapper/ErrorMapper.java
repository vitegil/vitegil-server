package com.vitegil.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vitegil.pojo.Error;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorMapper extends BaseMapper<Error> {
    //注意：Error一定是com.vitegil.pojo.Error下的！因为java.lang包下也有
}
