package com.shawnliang.weather.dao.convertor;

import com.shawnliang.weather.dao.info.AInfo;
import com.shawnliang.weather.dao.req.AUpdateReq;
import com.shawnliang.weather.dao.weather_market.entity.A;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/13
 */
@Mapper(componentModel="spring")
public interface AConvertor {

    /**
     * req -> info
     * @param aUpdateReq
     * @return
     */
    @Mappings({
            @Mapping(source = "userName", target = "name")
    })
    AInfo reqToInfo(AUpdateReq aUpdateReq);

    /**
     * info -> do
     * @param aInfo .
     * @return .
     */
    @Mappings({
            @Mapping(source = "name", target = "userName")
    })
    A infoToDo(AInfo aInfo);
}
