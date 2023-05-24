package com.shawnliang.web;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.google.common.collect.Lists;
import com.shawnliang.service.util.BaiDuMapUtil;
import com.shawnliang.weather.common.model.info.baidu.BaiDuGeoInfo;
import com.shawnliang.weather.dao.weather_market.entity.CityConfigDo;
import com.shawnliang.weather.dao.weather_market.repository.CityConfigDoRepository;
import java.io.File;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/4
 */
@Slf4j
public class UtilTest extends ApplicationTest {

    @Autowired
    private CityConfigDoRepository cityConfigDoRepository;

    //@Test
    public void initSQLTest() {
        File file = new File("D:\\生活\\天气\\【墨迹天气专业版】API接口相关材料\\【墨迹天气专业版】API接口相关材料\\a.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        int i = 0;
        List<CityConfigDo> cityConfigDoList = Lists.newLinkedList();
        for (List<Object> objects : read) {
            i++;
            Object o = objects.get(0);
            Object o1 = objects.get(1);
            Object o2 = objects.get(2);
            Object o3 = objects.get(3);
            Object o4= objects.get(4);
            Object o5 = objects.get(5);
            CityConfigDo cityConfigDo = new CityConfigDo();

            cityConfigDo.setCityId(Integer.valueOf(o.toString()));
            cityConfigDo.setDistrictName((String) o1);
            cityConfigDo.setProvinceName((String) o2);
            cityConfigDo.setCityName((String) o3);
            cityConfigDo.setLng(String.valueOf(o4));
            cityConfigDo.setLat(String.valueOf(o5));
            cityConfigDoList.add(cityConfigDo);

            log.info("o{} , o1{}, o2{}, o3{}, o4{}, o5{}, 第{}条数据"
           , o, o1, o2, o3, o4, o5, i);

        }
        cityConfigDoRepository.saveBatch(cityConfigDoList);
        log.info("===初始化完成==");
    }


    @Test
    public void getByBaiduClient() {
        File file = new File("D:\\生活\\天气\\【墨迹天气专业版】API接口相关材料\\【墨迹天气专业版】API接口相关材料\\a.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        int i = 0;
        for (List<Object> objects : read) {
            i++;
            BaiDuGeoInfo baiDuGeoInfo = BaiDuMapUtil
                    .getLocationByGeo(String.valueOf(objects.get(5)),
                            String.valueOf(objects.get(4)));
            log.info("baiDuGeoInfo is {}, i是 {}", baiDuGeoInfo, i);
            if (baiDuGeoInfo == null || baiDuGeoInfo.getAddressComponent() == null)  {
                log.info("百度地区返回空： {}", objects);
                continue;
            }
            String district = baiDuGeoInfo.getAddressComponent().getDistrict();
            String province = baiDuGeoInfo.getAddressComponent().getProvince();
            String city = baiDuGeoInfo.getAddressComponent().getCity();

            CityConfigDo configDo = cityConfigDoRepository.getByProvinceAndCityLikeDistrict(province, city, district);
            if (Objects.isNull(configDo)) {
                log.info("百度districtName查询为空 i是 {}", i);
                continue;
            }
            log.info("百度api查询结果  {}", configDo);
            if (!configDo.getCityId().equals(284609)) {
                Long o = (Long) objects.get(0);
//                Assert.assertEquals(Integer.valueOf(Math.toIntExact(o)), configDo.getCityId());
            }
            if (!configDo.getCityId().equals(Math.toIntExact((Long) objects.get(0)))) {
                log.error("不匹配 {}", objects.get(0));
            }

        }
    }
}
